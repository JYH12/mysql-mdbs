package com.lsl.utils;

import java.io.Serializable;

public class SettingInfo implements Serializable {
    String days;
    String hour;
    String minute;
    String host;
    String instanceUser;
    String instancePassword;
    String user;
    String password;

    public SettingInfo(String days, String hour, String minute, String instanceUser, String instancePassword) {
        this.days = days;
        this.hour = hour;
        this.minute = minute;
        this.instanceUser = instanceUser;
        this.instancePassword = instancePassword;
    }

    public SettingInfo() {
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
