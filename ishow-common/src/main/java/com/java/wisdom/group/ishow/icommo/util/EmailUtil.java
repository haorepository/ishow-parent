package com.java.wisdom.group.ishow.icommo.util;

import com.java.wisdom.group.ishow.icommo.commons.Code;
import com.java.wisdom.group.ishow.icommo.model.Email;

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

    /**
     * 发送邮件
     * @param email 邮件实体类
     */
    public static void sendEmail(Email email){
        // 参数配置

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", Code.SMTP_HOST);
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        // 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
        session.setDebug(false);
        // 创建一封邮件
        Message message = createMimeMessage(session,email);
        // 根据 Session 获取邮件传输对象
        try {
            Transport transport = session.getTransport();
            // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错
            transport.connect(Code.SEND_EMAIL_ACCOUNT, Code.MAIL_AUTHORIZATION_CODE);
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Message createMimeMessage(Session session, Email email){
        Message message = new MimeMessage(session);
        try{
            //生成发送邮件地址
            InternetAddress sendInternetAddress = new InternetAddress(Code.SEND_EMAIL_ACCOUNT);
            //生成接收邮件地址
            InternetAddress receiveInternetAddress = new InternetAddress(email.getReceiveMailAccount());
            message.setFrom(sendInternetAddress);
            message.setRecipient(MimeMessage.RecipientType.TO,receiveInternetAddress);
            // 设置邮件标题
            message.setSubject(email.getMailTitle());
            // 设置邮件正文
            message.setText(email.getMailContent());
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
        String receiveMailAccount = "38754610@qq.com";
        Email emailVo = new Email();
        emailVo.setReceiveMailAccount(receiveMailAccount);
        emailVo.setMailTitle("发送邮件测试");
        emailVo.setMailContent("这是测试内容，请忽略此邮件");
        sendEmail(emailVo);
        System.out.println("发送邮件完成");
    }
}
