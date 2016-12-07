package cn.it.shop.service.impl;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MessageSender {

	/*public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        //开启SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        msg.setSubject("邮件发送测试");
       
        msg.setContent("发送成功啦！！！","text/html;charset=utf-8");
        msg.setFrom(new InternetAddress("605613403@qq.com"));

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "605613403", "tfoqfoyllfzqbcbf");

        transport.sendMessage(msg, new Address[] { new InternetAddress("906852379@qq.com") });
        transport.close();
    }*/
}
