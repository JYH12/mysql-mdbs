package com.lsl.po;

public class Slave {
    private String host;

    private String instancePassword;

    private String isntancecUser;

    private Integer isuse;

    private Integer masterid;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getInstancePassword() {
        return instancePassword;
    }

    public void setInstancePassword(String instancePassword) {
        this.instancePassword = instancePassword == null ? null : instancePassword.trim();
    }

    public String getIsntancecUser() {
        return isntancecUser;
    }

    public void setIsntancecUser(String isntancecUser) {
        this.isntancecUser = isntancecUser == null ? null : isntancecUser.trim();
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public Integer getMasterid() {
        return masterid;
    }

    public void setMasterid(Integer masterid) {
        this.masterid = masterid;
    }
}