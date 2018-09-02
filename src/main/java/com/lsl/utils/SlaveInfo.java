package com.lsl.utils;

public class SlaveInfo {

    //Master相关属性
    private String host;
    private String user;
    private String password;
    private String instanceUser;
    private String instancePassword;
    private String replUser;
    private String replPassword;

    //Slave相关属性
    private String slaveHost;
    private String slaveUser;
    private String slavePassword;
    private String slaveInstanceUser;
    private String slaveInstancePassword;

    public SlaveInfo(String host, String user, String password, String replUser, String replPassword,
                     String instanceUser,String instancePassword) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.replUser = replUser;
        this.replPassword = replPassword;
        this.instanceUser = instanceUser;
        this.instancePassword = instancePassword;
    }

    public SlaveInfo() {
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

    public String getReplUser() {
        return replUser;
    }

    public void setReplUser(String replUser) {
        this.replUser = replUser;
    }

    public String getReplPassword() {
        return replPassword;
    }

    public void setReplPassword(String replPassword) {
        this.replPassword = replPassword;
    }

    public String getSlaveHost() {
        return slaveHost;
    }

    public void setSlaveHost(String slaveHost) {
        this.slaveHost = slaveHost;
    }

    public String getSlaveUser() {
        return slaveUser;
    }

    public void setSlaveUser(String slaveUser) {
        this.slaveUser = slaveUser;
    }

    public String getSlavePassword() {
        return slavePassword;
    }

    public void setSlavePassword(String slavePassword) {
        this.slavePassword = slavePassword;
    }

    public String getSlaveInstanceUser() {
        return slaveInstanceUser;
    }

    public void setSlaveInstanceUser(String slaveInstanceUser) {
        this.slaveInstanceUser = slaveInstanceUser;
    }

    public String getSlaveInstancePassword() {
        return slaveInstancePassword;
    }

    public void setSlaveInstancePassword(String slaveInstancePassword) {
        this.slaveInstancePassword = slaveInstancePassword;
    }
}
