package com.acm.msgtomail.front.entity;

import java.io.Serializable;

public class Mail implements Serializable {
//    发送者
    private String from;
    /**
     * 接收人
     */
    private String sendTo;

//    抄送人
    private String cc;
    /**
     *  邮件主题
     */
    private String subject;

    /**
     *  邮件内容
     */
    private String text;
  //文件名字
    private String name;

    /**
     *  附件路径
     */
    private String filePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }



    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }




    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}

