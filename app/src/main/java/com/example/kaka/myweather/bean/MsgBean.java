package com.example.kaka.myweather.bean;

public class MsgBean {
    private int id;
    private int msgId;

    public MsgBean() {
    }

    public MsgBean(int id, int msgId) {
        this.id = id;
        this.msgId = msgId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
