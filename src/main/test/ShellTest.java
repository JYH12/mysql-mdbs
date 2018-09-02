import com.lsl.po.Backup;
import com.lsl.utils.*;
import org.junit.Test;

public class ShellTest {

    @Test
    public void physicalBackupTest(){
        BackupInfo backupInfo = new BackupInfo();
        backupInfo.setUser("root");
        backupInfo.setPassword("070800");
        backupInfo.setInstancePassword("070800");
        backupInfo.setInstanceUser("root");
        backupInfo.setHost("192.168.25.133");
        backupInfo.setType(0);
        Message message = ShellUtil.backupNow(backupInfo);
        System.out.println(message.getMsg());
    }

    @Test
    public void logicalBackupTest(){
        BackupInfo backupInfo = new BackupInfo();
        backupInfo.setUser("root");
        backupInfo.setPassword("070800");
        backupInfo.setInstancePassword("070800");
        backupInfo.setInstanceUser("root");
        backupInfo.setHost("192.168.25.133");
        backupInfo.setType(1);
        backupInfo.setStrategyType(0);
        Message message = ShellUtil.backupNow(backupInfo);
        System.out.println(message.getMsg());
    }

    @Test
    public void logicalOneBackupTest(){
        BackupInfo backupInfo = new BackupInfo();
        backupInfo.setUser("root");
        backupInfo.setPassword("070800");
        backupInfo.setInstancePassword("070800");
        backupInfo.setInstanceUser("root");
        backupInfo.setHost("192.168.25.133");
        backupInfo.setType(1);
        backupInfo.setStrategyType(1);
        backupInfo.setDatabaseName("test");
        Message message = ShellUtil.backupNow(backupInfo);
        System.out.println(message.getMsg());
    }

    @Test
    public void backupSetTest(){
        SettingInfo settingInfo = new SettingInfo();
        settingInfo.setPassword("070800");
        settingInfo.setUser("root");
        settingInfo.setHost("192.168.25.133");
        settingInfo.setInstancePassword("070800");
        settingInfo.setInstanceUser("root");
        /*settingInfo.setHour(16);
        settingInfo.setMinute(45);*/
        //settingInfo.setDays(new int[]{0,1,2,3,4,5,6,7});
        Message message = ShellUtil.backupSet(settingInfo);
        System.out.println(message.getMsg());
    }

    @Test
    public void physicalRecoveryTest(){
        RecoveryInfo recoveryInfo = new RecoveryInfo();
        Backup backup = new Backup();
        backup.setType("物理备份");
        backup.setBackupName("2018-07-01_16:48:53.tar.gz");
        recoveryInfo.setBackup(backup);
        recoveryInfo.setPassword("070800");
        recoveryInfo.setUser("root");
        recoveryInfo.setHost("192.168.25.133");
        recoveryInfo.setInstanceUser("root");
        recoveryInfo.setInstancePassword("070800");
        Message recovery = ShellUtil.recovery(recoveryInfo);
        System.out.println(recovery.getMsg());
    }

    @Test
    public void logicalRecoverTestq(){
        RecoveryInfo recoveryInfo = new RecoveryInfo();
        Backup backup = new Backup();
        backup.setType("逻辑备份");
        backup.setBackupName("2018-07-01_17:25:33.sql");
        recoveryInfo.setBackup(backup);
        recoveryInfo.setPassword("070800");
        recoveryInfo.setUser("root");
        recoveryInfo.setHost("192.168.25.133");
        recoveryInfo.setInstanceUser("root");
        recoveryInfo.setInstancePassword("070800");
        Message recovery = ShellUtil.recovery(recoveryInfo);
        System.out.println(recovery.getMsg());
    }

    @Test
    public void pointIntTimeRecoveryTest(){
        RecoveryInfo recoveryInfo = new RecoveryInfo();
        Backup backup = new Backup();
        backup.setBackupName("2018-07-02_13:29:10.tar.gz");
        recoveryInfo.setBackup(backup);
        recoveryInfo.setUser("root");
        recoveryInfo.setInstanceUser("root");
        recoveryInfo.setPassword("070800");
        recoveryInfo.setInstancePassword("070800");
        recoveryInfo.setHost("192.168.25.133");
        String time = "2018-07-02 14:00:00";
        Message message = ShellUtil.pointInTimeRecovery(recoveryInfo, time);
        System.out.println(message.getMsg());
    }

    @Test
    public void openSlaveTest(){
        SlaveInfo slaveInfo = new SlaveInfo();
        slaveInfo.setUser("root");
        slaveInfo.setPassword("070800");
        slaveInfo.setHost("192.168.25.133");
        slaveInfo.setInstanceUser("root");
        slaveInfo.setInstancePassword("070800");
        slaveInfo.setReplUser("repl_user");
        slaveInfo.setReplPassword("070800");

        slaveInfo.setSlaveUser("root");
        slaveInfo.setSlavePassword("070800");
        slaveInfo.setSlaveHost("192.168.25.134");
        slaveInfo.setSlaveInstanceUser("root");
        slaveInfo.setSlaveInstancePassword("070800");

        Message message = ShellUtil.openSlave(slaveInfo);
        System.out.println(message.getMsg());
    }

}
