package com.lsl.service;

import com.lsl.mapper.*;
import com.lsl.po.*;
import com.lsl.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BackupService {

    @Autowired
    private BackupMapper backupMapper;
    @Autowired
    private InstanceMapper instanceMapper;
    @Autowired
    private DatabaseInfoMapper databaseInfoMapper;
    @Autowired
    private HostInfoMapper hostInfoMapper;
    @Autowired
    private SlaveMapper slaveMapper;

    /*//返回用户所有的mysql实例
    public EasyUIDataGridResult selectInstance(int userId){
        InstanceExample instanceExample = new InstanceExample();
        InstanceExample.Criteria criteria = instanceExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<Instance> instances = instanceMapper.selectByExample(instanceExample);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(instances);
        result.setTotal(instances.size());
        return result;
    }*/


    /*//返回指定mysql实例的所有备份记录
    public EasyUIDataGridResult showBackupList(int page,int rows,int instanceId){
        PageHelper.startPage(page,rows);
        BackupExample example = new BackupExample();
        BackupExample.Criteria criteria = example.createCriteria();
        criteria.andInstanceidEqualTo(instanceId);
        List<Backup> backups = backupMapper.selectByExample(example);
        PageInfo<Backup> pageInfo = new PageInfo<Backup>(backups);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(backups);
        result.setTotal(pageInfo.getTotal());
        return  result;
    }*/

    //根据用户输入的时间范围返回某个mysql实例的备份记录
    public EasyUIDataGridResult selectByDate(String dateFrom,String dateTo,int instanceId){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        try {
            Date from = simpleDateFormat.parse(dateFrom);
            Date to = simpleDateFormat.parse(dateTo);
            BackupExample backupExample = new BackupExample();
            BackupExample.Criteria criteria = backupExample.createCriteria();
            criteria.andTimeBetween(from,to);
            criteria.andInstanceidEqualTo(instanceId);
            List<Backup> backups = backupMapper.selectByExample(backupExample);
            result.setRows(backups);
            result.setTotal(backups.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    //根据用户自定义周期通过ShellUtils运行crontab命令
    public Message backupSet(SettingInfo settingInfo){
        HostInfoExample hostInfoExample = new HostInfoExample();
        HostInfoExample.Criteria hostCriteria = hostInfoExample.createCriteria();
        hostCriteria.andHostEqualTo(settingInfo.getHost());
        List<HostInfo> hostInfos = hostInfoMapper.selectByExample(hostInfoExample);
        HostInfo hostInfo = hostInfos.get(0); //查询并得到实例所在主机的相关信息
        settingInfo.setPassword(hostInfo.getPassword());
        settingInfo.setUser(hostInfo.getUser());
        return ShellUtil.backupSet(settingInfo);
    }


    //进行即刻备份
    public Message backupInstance(BackupInfo backupInfo){
        if (backupInfo.getType()==1&&backupInfo.getStrategyType()==1) {
            DatabaseInfoExample databaseInfoExample = new DatabaseInfoExample();
            DatabaseInfoExample.Criteria criteria = databaseInfoExample.createCriteria();
            criteria.andDatabaseNameEqualTo(backupInfo.getDatabaseName());
            criteria.andInstanceidEqualTo(backupInfo.getInstanceId());
            List<DatabaseInfo> databaseInfos = databaseInfoMapper.selectByExample(databaseInfoExample);

            if (databaseInfos == null || databaseInfos.size() == 0) {
                return Message.build("所指定数据库不存在", 400);
            }
        }

        HostInfoExample hostInfoExample = new HostInfoExample();
        HostInfoExample.Criteria hostCriteria = hostInfoExample.createCriteria();
        hostCriteria.andHostEqualTo(backupInfo.getHost());
        List<HostInfo> hostInfos = hostInfoMapper.selectByExample(hostInfoExample);
        HostInfo hostInfo = hostInfos.get(0);

        backupInfo.setPassword(hostInfo.getPassword());
        backupInfo.setUser(hostInfo.getUser());
        Message message = ShellUtil.backupNow(backupInfo);
        return message;
    }



    //根据已有的备份文件进行恢复
    public Message recovery(RecoveryInfo recoveryInfo){
        String host = recoveryInfo.getHost();
        HostInfoExample hostInfoExample = new HostInfoExample();
        HostInfoExample.Criteria criteria = hostInfoExample.createCriteria();
        criteria.andHostEqualTo(host);
        List<HostInfo> hostInfos = hostInfoMapper.selectByExample(hostInfoExample);
        HostInfo hostInfo = hostInfos.get(0);
        recoveryInfo.setUser(hostInfo.getUser());
        recoveryInfo.setPassword(hostInfo.getPassword());
        return ShellUtil.recovery(recoveryInfo);
    }


    //备份记录表的更新
    /**
     *
     * @param time: 备份结束时间
     * @param type:备份类型(物理/逻辑)
     * @param size:备份大小(压缩后的)
     * @param strategy:备份策略(实例/单库)
     * @param host:
     */
    public void backupInsert(String type,String size,String strategy,String time,String host,String backupName){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timeLong = Long.valueOf(time);
        String timeStamp = simpleDateFormat.format(timeLong);
        Date date = null;
        try {
             date = simpleDateFormat.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        InstanceExample instanceExample = new InstanceExample();
        InstanceExample.Criteria criteria = instanceExample.createCriteria();
        criteria.andHostEqualTo(host);
        List<Instance> instances = instanceMapper.selectByExample(instanceExample);
        Instance instance = instances.get(0);
        String url="http://"+host+"/";
        if (type.equals("physical")){
            url+="physical/"+backupName;
        }else {
            url+="logical/"+backupName;
        }
        type= type.equals("physical")? "物理备份" : "逻辑备份";
        strategy = strategy.equals("instance")? "实例备份" : "单库备份";
        Backup backup = new Backup();
        backup.setType(type);
        backup.setSize(size);
        backup.setStrategy(strategy);
        backup.setTime(date);
        backup.setHost(host);
        backup.setInstanceid(instance.getInstanceid());
        backup.setBackupName(backupName);
        backup.setUrl(url);
        backupMapper.insert(backup);
    }



    //基于时间点的恢复
    public Message pointInTimeRecovery(RecoveryInfo recoveryInfo,String time) {
        Message result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(time);
            BackupExample backupExample = new BackupExample();
            BackupExample.Criteria criteria = backupExample.createCriteria();
            criteria.andTimeLessThan(date);
            criteria.andTypeEqualTo("物理备份");
            backupExample.setOrderByClause("time desc");
            List<Backup> backups = backupMapper.selectByExample(backupExample);
            Backup backup = backups.get(0);
            recoveryInfo.setBackup(backup);
            HostInfoExample hostInfoExample = new HostInfoExample();
            HostInfoExample.Criteria hostCriteria = hostInfoExample.createCriteria();
            hostCriteria.andHostEqualTo(recoveryInfo.getHost());
            List<HostInfo> hostInfos = hostInfoMapper.selectByExample(hostInfoExample);
            HostInfo hostInfo = hostInfos.get(0);
            recoveryInfo.setUser(hostInfo.getUser());
            recoveryInfo.setPassword(hostInfo.getPassword());
            result = ShellUtil.pointInTimeRecovery(recoveryInfo,time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    //为用户创建一个从库
    public Message openSlave(SlaveInfo slaveInfo) {
        //填充master主机的信息(user/password)
        HostInfoExample hostInfoExample = new HostInfoExample();
        HostInfoExample.Criteria hostCriteria = hostInfoExample.createCriteria();
        hostCriteria.andHostEqualTo(slaveInfo.getHost());
        List<HostInfo> hostInfos = hostInfoMapper.selectByExample(hostInfoExample);
        HostInfo hostInfo = hostInfos.get(0);
        slaveInfo.setUser(hostInfo.getUser());
        slaveInfo.setPassword(hostInfo.getPassword());

        //填充slave实例信息
        SlaveExample slaveExample = new SlaveExample();
        SlaveExample.Criteria criteria = slaveExample.createCriteria();
        criteria.andIsuseEqualTo(0);
        List<Slave> slaves = slaveMapper.selectByExample(slaveExample);
        Slave slave = slaves.get(0);
        String host = slave.getHost();
        slaveInfo.setSlaveHost(host);
        slaveInfo.setSlaveInstanceUser(slave.getIsntancecUser());
        slaveInfo.setSlaveInstancePassword(slave.getInstancePassword());
        slave.setIsuse(1);
        slaveMapper.updateByExample(slave,slaveExample);

        //填充slave主机信息
        HostInfoExample hostInfoSlaveExample = new HostInfoExample();
        HostInfoExample.Criteria hostSlaveCriteria = hostInfoSlaveExample.createCriteria();
        hostSlaveCriteria.andHostEqualTo(host);
        List<HostInfo> hostSlaveInfos = hostInfoMapper.selectByExample(hostInfoExample);
        HostInfo hostSlaveInfo = hostSlaveInfos.get(0);
        slaveInfo.setSlaveUser(hostSlaveInfo.getUser());
        slaveInfo.setSlavePassword(hostSlaveInfo.getPassword());

        return ShellUtil.openSlave(slaveInfo);
    }
}
