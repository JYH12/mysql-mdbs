package com.lsl.utils;

import com.lsl.po.Backup;

public class RecoveryInfo {
    Backup backup;
    String host;
    String user;
    String password;
    String instanceUser;
    String instancePassword;
    String time;

    public RecoveryInfo(Backup backup, String host, String user, String password, String instanceUser, String instancePassword) {
        this.backup = backup;
        this.host = host;
        this.user = user;
        this.password = password;
        this.instanceUser = instanceUser;
        this.instancePassword = instancePassword;
    }

    public RecoveryInfo() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Backup getBackup() {
        return backup;
    }

    public void setBackup(Backup backup) {
        this.backup = backup;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstanceUser() {
        return instanceUser;
    }

    public void setInstanceUser(String instanceUser) {
        this.instanceUser = instanceUser;
    }

    public String getInstancePassword() {
        return instancePassword;
    }

    public void setInstancePassword(String instancePassword) {
        this.instancePassword = instancePassword;
    }
}
