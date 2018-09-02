package com.lsl.utils;

import com.jcraft.jsch.*;
import com.lsl.po.Backup;

//远程执行shell脚本进行即刻备份的工具类(xtrabackup/mysqlpump)，
//需要主机的ip，用户名，密码；mysql的用户名，密码，
//backupinfo可以提供备份类型(逻辑/物理)，逻辑单库备份的库名，

public class ShellUtil {

    private static final int DEFAULT_PORT=22;
    private static final String LOGICAL_BACKUP_PATH = "/backup/backupshell/logicalshell.sh";
    private static final String PHYSICAL_BACKUP_PATH = "/backup/backupshell/physicalbackup.sh";
    private static final String LOGICAL_BACKUP_PATH_ONE = "/backup/backupshell/logicalshellone.sh";
    private static final String LOGICAL_RECOVERY_PATH = "/backup/recoveryshell/logicalrecovery.sh";
    private static final String PHYSICAL_RECOVERY_PATH = "/backup/recoveryshell/physicalrecovery.sh";
    private static final String POINT_IN_TIME_RECOVERY = "/backup/recoveryshell/pointintime.sh";
    private static final String OPEN_SLAVE_PATH="/backup/backupshell/openslave.sh";
    private static final String SLAVE_SH_PATH="/backup/shell/slave.sh";

    //Type：0为物理备份，1为逻辑备份
    //!!!!!!!!!!!!!!!
    // junit已测试
    public static Message backupNow(BackupInfo backupInfo){
        Message result = null;
        if (backupInfo.getType()==0)
        {
            result = physicalBackup(backupInfo);
        }
        if (backupInfo.getType()==1){
            result = logicalBackup(backupInfo);
        }

        return result;
    }


    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message logicalBackup(BackupInfo backupInfo){
        //strategyType: 0为实例备份，1为单库备份；
        String command;
        if (backupInfo.getStrategyType()==1){
            command= LOGICAL_BACKUP_PATH_ONE+" "+backupInfo.getInstanceUser()+" "+backupInfo.getInstancePassword()
                    +" "+backupInfo.getDatabaseName();
        }else {
            command = LOGICAL_BACKUP_PATH+" "+backupInfo.getInstanceUser()+" "+backupInfo.getInstancePassword();
        }

        return exec(backupInfo.getUser(),backupInfo.getHost(),backupInfo.getPassword(),command,"备份成功");
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message physicalBackup(BackupInfo backupInfo){
        String command = PHYSICAL_BACKUP_PATH+" "+backupInfo.getInstanceUser()+" "+backupInfo.getInstancePassword();

        return exec(backupInfo.getUser(),backupInfo.getHost(),backupInfo.getPassword(),command,"备份成功");
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    public static Message backupSet(SettingInfo settingInfo){
        String[] days= settingInfo.getDays().split(",");
        String hour = settingInfo.getHour();
        String minute = settingInfo.getMinute();
        String fullDays  = "";
        for (int i = 0; i < days.length; i++) {
            String tmp = days[i];
            if (i != days.length-1)
                fullDays+=tmp+",";
            else
                fullDays+=tmp+" ";
        }
        String command = "echo \""+minute+" "+hour+" * * "+fullDays+" root "+PHYSICAL_BACKUP_PATH +" "+settingInfo.getInstanceUser()
                            +" "+settingInfo.getInstancePassword()+"\" >> /etc/crontab&&service crond restart";


        return exec(settingInfo.getUser(),settingInfo.getHost(),settingInfo.getPassword(),command,"设置成功");
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    public static Message recovery(RecoveryInfo recoveryInfo){
        Message result = null;
        Backup backup = recoveryInfo.getBackup();
        if (backup.getType().equals("逻辑备份")){
            result = logicalRecovery(recoveryInfo);
        }
        if (backup.getType().equals("物理备份")){
            result = physicalRecovery(recoveryInfo);
        }
        return  result;
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message logicalRecovery(RecoveryInfo recoveryInfo){
        String command = LOGICAL_RECOVERY_PATH+" "+recoveryInfo.getInstanceUser()+" "+
                recoveryInfo.getInstancePassword()+" "+recoveryInfo.getBackup().getBackupName();

        return exec(recoveryInfo.getUser(),recoveryInfo.getHost(),recoveryInfo.getPassword(),command,"恢复成功");
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message physicalRecovery(RecoveryInfo recoveryInfo){
        String command = PHYSICAL_RECOVERY_PATH+" "+recoveryInfo.getBackup().getBackupName();

        return exec(recoveryInfo.getUser(),recoveryInfo.getHost(),recoveryInfo.getPassword(),command,"恢复成功");
    }


    //!!!!!!!!!!!!!!!
    // junit已测试
    public static Message pointInTimeRecovery(RecoveryInfo recoveryInfo,String time){
        String command = POINT_IN_TIME_RECOVERY+" "+recoveryInfo.getInstanceUser()+" "+recoveryInfo.getInstancePassword()
                +" \"" +time+"\" "+recoveryInfo.getBackup().getBackupName();

        return exec(recoveryInfo.getUser(),recoveryInfo.getHost(),recoveryInfo.getPassword(),command,"恢复成功");
    }


    //主库调用脚本先mysqlpump导出数据(防止主库已有部分binlog被删除)
    //从库通过scp拷贝主库上的sql文件并导入从库，
    // 脚本需要主库主机的host，user，主库实例的repl_user/password，从库实例的user/password

    //!!!!!!!!!!!!!!!
    // junit已测试
    public static Message openSlave(SlaveInfo slaveInfo){
        Message masterMessage = openSlaveOne(slaveInfo);
        if (masterMessage ==null){
            return Message.build("主库出现故障",400);
        }
        Message slaveMessage = openSlaveTwo(slaveInfo);
        if (slaveMessage==null){
            return Message.build("从库出现故障",400);
        }
        return slaveMessage;
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message openSlaveOne(SlaveInfo slaveInfo){
        String masterCommand = OPEN_SLAVE_PATH+" "+slaveInfo.getInstanceUser()+" "+slaveInfo.getInstancePassword();
        return exec(slaveInfo.getUser(),slaveInfo.getHost(),slaveInfo.getPassword(),masterCommand,"主库备份成功");
    }

    //!!!!!!!!!!!!!!!
    // junit已测试
    private static Message openSlaveTwo(SlaveInfo slaveInfo){
        String slaveCommand = SLAVE_SH_PATH+" "+slaveInfo.getUser()+" "+slaveInfo.getHost()+" "
                + slaveInfo.getSlaveInstanceUser()+" "+slaveInfo.getSlaveInstancePassword()+" "+slaveInfo.getReplUser()
                +" "+slaveInfo.getReplPassword();
        return exec(slaveInfo.getSlaveUser(),slaveInfo.getSlaveHost(),slaveInfo.getSlavePassword(),slaveCommand,"从库开启成功");
    }

    private static Message exec(String user,String host,String password,String command,String msg){
        JSch jSch = new JSch();
        Session session = null;
        Channel channel = null;
        Message result = null;
        try {
            session = jSch.getSession(user, host, DEFAULT_PORT);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();
            channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.connect();
            result = Message.build(msg,200);
        } catch (JSchException e) {
            e.printStackTrace();
        }finally {
            if (channel!=null&&!channel.isClosed()){
                channel.disconnect();
            }
            if (session!=null&&session.isConnected()){
                session.disconnect();
            }
        }
        return result;
    }


}
