package com.lsl.utils;

public class BackupInfo {
    private int instanceId;
    private int type;//0/1------物理/逻辑
    private int strategyType;//0/1------实例/单库
    private String databaseName;
    private String host;
    private String password;
    private String user;
    private String instanceUser;
    private String instancePassword;

    public BackupInfo(int type, int instanceId, int strategyType, String databaseName,
                      String host, String password, String user, String instanceUser, String instancePassword) {
        this.type = type;
        this.instanceId = instanceId;
        this.strategyType = strategyType;
        this.databaseName = databaseName;
        this.host = host;
        this.password = password;
        this.user = user;
        this.instanceUser = instanceUser;
        this.instancePassword = instancePassword;
    }

    public BackupInfo() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public int getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(int strategyType) {
        this.strategyType = strategyType;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
