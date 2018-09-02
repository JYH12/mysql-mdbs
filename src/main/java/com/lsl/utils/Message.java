package com.lsl.utils;

import com.lsl.po.User;

import java.io.Serializable;

public class Message implements Serializable {
    private String msg;
    private Integer status;
    private Object data;
    private EasyUIDataGridResult result;

    public Message(Object data, EasyUIDataGridResult result) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
        this.result=result;
    }

    public static Message build(String msg,Integer status,Object data){
        return new Message(msg,status,data);
    }

    public static Message build(String msg,Integer status){
        return new Message(msg,status,null);
    }

    public static Message ok(Object data,EasyUIDataGridResult result){
        return  new Message(data,result);
    }

    public static Message ok(){
        return new Message(null);
    }

    public Message(String msg, Integer status, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public Message(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public static Message ok(User user) {
        return new Message(user);
    }

    public EasyUIDataGridResult getResult() {
        return result;
    }

    public void setResult(EasyUIDataGridResult result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
