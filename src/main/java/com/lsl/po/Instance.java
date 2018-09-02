package com.lsl.po;

public class Instance {
    private Integer instanceid;

    private Integer userid;

    private String host;

    private String port;

    private String replUser;

    private String replPassword;

    private String instanceName;

    private String instanceUser;

    private String instancePassword;

    public Integer getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(Integer instanceid) {
        this.instanceid = instanceid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getReplUser() {
        return replUser;
    }

    public void setReplUser(String replUser) {
        this.replUser = replUser == null ? null : replUser.trim();
    }

    public String getReplPassword() {
        return replPassword;
    }

    public void setReplPassword(String replPassword) {
        this.replPassword = replPassword == null ? null : replPassword.trim();
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName == null ? null : instanceName.trim();
    }

    public String getInstanceUser() {
        return instanceUser;
    }

    public void setInstanceUser(String instanceUser) {
        this.instanceUser = instanceUser == null ? null : instanceUser.trim();
    }

    public String getInstancePassword() {
        return instancePassword;
    }

    public void setInstancePassword(String instancePassword) {
        this.instancePassword = instancePassword == null ? null : instancePassword.trim();
    }
}