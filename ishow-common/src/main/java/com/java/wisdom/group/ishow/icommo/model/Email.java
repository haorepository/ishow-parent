package com.java.wisdom.group.ishow.icommo.model;

/**
 * @author ：terry
 * @date ：Created in 2020/6/12 11:41
 * @description：TODO
 * @version: 1.0
 */
public class Email {
    private String receiveMailAccount;
    private String mailTitle;
    private String mailContent;

    public String getReceiveMailAccount() {
        return receiveMailAccount;
    }

    public void setReceiveMailAccount(String receiveMailAccount) {
        this.receiveMailAccount = receiveMailAccount;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
