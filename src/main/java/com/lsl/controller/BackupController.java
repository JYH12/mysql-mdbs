package com.lsl.controller;

import com.lsl.service.BackupService;
import com.lsl.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/backup")
public class BackupController {

    @Autowired
    private BackupService backupService;

    /* //ajax调用查询出用户所有的mysql实例
    @RequestMapping("/instance")
    @ResponseBody
    public EasyUIDataGridResult showInstances(HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        Integer userId = user.getUserid();
        return backupService.selectInstance(userId);
    }*/

    /*//用户点击某一个实例，查询出该实例的所有备份记录
    @RequestMapping("/showlist")
    @ResponseBody
    public EasyUIDataGridResult showList(@RequestBody int page, @RequestBody int rows, @RequestBody int instanceId){
        return  backupService.showBackupList(page,rows,instanceId);
    }*/

    @RequestMapping("/")
    public String show(){
        return "index";
    }


    //查询用户输入的日期范围内指定实例的备份记录
    @RequestMapping("/search")
    @ResponseBody
    public EasyUIDataGridResult searchBackups( String dateFrom , String dateTo, int instanceId){

        return backupService.selectByDate(dateFrom,dateTo,instanceId);
    }


    //用户自定义的备份策略(只能物理全量，用户定义备份周期)
    @RequestMapping(value = "/settings")
    @ResponseBody
    public Message backupSet(SettingInfo settingInfo) throws IOException {
       return backupService.backupSet(settingInfo);
    }


    //用户出于某种需求(如:想要将当前的所有数据迁移到本地)，要立即备份实例。
    @RequestMapping("/backupinstance")
    @ResponseBody
    public Message backupInstance(BackupInfo backupInfo){

        return  backupService.backupInstance(backupInfo);
    }


    //直接根据已有的备份文件进行恢复
    @RequestMapping("/recovery")
    @ResponseBody
    public Message recovery(RecoveryInfo recoveryInfo){
        return backupService.recovery(recoveryInfo);
    }


    //mysql主机每进行一次备份后，通过一个get请求(curl)到达该方法，进行备份记录表的更新
    /**
     *
     * @param type 逻辑/物理
     * @param size  备份文件大小
     * @param strategy  实例/单库
     * @param time  备份时间
     * @param host  实例主机的IP
     * @param backupName    本分文件的名字(以备份时间命名)
     */
    @RequestMapping("/backupinsert")
    public void backupInsert(String type,String size,String strategy,String time,String host,String backupName){
        System.out.println(type);
        System.out.println(size);
        System.out.println(strategy);
        System.out.println(time);
        System.out.println(host);
        System.out.println(backupName);
        backupService.backupInsert(type,size,strategy,time,host,backupName);
    }



    //基于时间点的恢复
    @RequestMapping("/pointintime")
    @ResponseBody
    public Message pointInTimeRecovery(RecoveryInfo recoveryInfo){
        return backupService.pointInTimeRecovery(recoveryInfo,recoveryInfo.getTime());
    }

    //开启一个灾备实例
    @RequestMapping("/openslave")
    @ResponseBody
    public Message openSlave(SlaveInfo slaveInfo){
        return backupService.openSlave(slaveInfo);
    }
}

