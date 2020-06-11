package com.java.wisdom.group.ishow.icommo.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author ：terry
 * @date ：Created in 2020/4/27 11:40
 * @description：TODO
 * @version: 1.0
 */
public class EmailUtil {
    // 发件人的邮箱地址和密码
    public static String sendEmailAccount = "2523796216@qq.com";

    //如果有授权码，此处填写授权码
    public static String sendEmailPassword = "jqqpepoppswfeach";

    // 发件人邮箱的 SMTP 服务器地址, 可以登录web邮箱查询
    public static String sendEmailSMTPHost = "smtp.qq.com";

    /**
     * @param receiveMailAccount 收件人邮箱
     */
    public static void sendEmail(String receiveMailAccount){
        // 参数配置

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", sendEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        // 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(false);
        // 创建一封邮件
        Message message = createMimeMessage(session, sendEmailAccount, receiveMailAccount);
        // 根据 Session 获取邮件传输对象
        try {
            Transport transport = session.getTransport();
            // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错
            transport.connect(sendEmailAccount, sendEmailPassword);
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Message createMimeMessage(Session session, String sendMail, String receiveMail){
        Message message = new MimeMessage(session);
        try{
            message.setFrom(new InternetAddress(sendMail));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));
            // 设置邮件标题
            message.setSubject("发送邮件测试");
            // 设置邮件正文
            message.setText("这是测试内容，请忽略此内容详情");
            message.setSentDate(new Date());
            //保存设置
            message.saveChanges();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public static void main(String[] args) {
        //String receiveMailAccount = "2944435016@qq.com";
        System.out.println("开始发送邮件");
        String receiveMailAccount = "38754610@qq.com";
        sendEmail(receiveMailAccount);
        System.out.println("发送邮件完成");
    }
}
