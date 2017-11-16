package com.zhanghao.core.utils;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮件工具类
 * 
 * @author zhanghao
 * @datetime 2017年11月16日 下午1:43:30
 */
public class EmailUtils {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(EmailUtils.class.getClassLoader().getResourceAsStream("email.properties"));
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("1181500972@qq.com", "rmsrzakmcoyrhccc");
			}
		});
		// 创建默认的 MimeMessage 对象
		MimeMessage message = new MimeMessage(session);

		// 收件人电子邮箱
		String to = "2845594279@qq.com";
		// 发件人电子邮箱
		String from = "1181500972@qq.com";
		// Set From: 头部头字段
		message.setFrom(new InternetAddress(from));
		message.setHeader("setHeader", "header");
		// Set To: 头部头字段
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// Set Subject: 头部头字段
		message.setSubject("This is the Subject Line!");
		// 设置消息体
		message.setText("This is actual message");

		MimeBodyPart imagePart = new MimeBodyPart();
		DataHandler handler = new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Pictures\\welcome.jpg"));
		imagePart.setDataHandler(handler);
		imagePart.setContentID("welcome");

		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent("这是一张图片<br><img src=\"cid:welcome\"/>", "text/html;charset=utf-8");
		// 发送消息
		MimeMultipart mp = new MimeMultipart();
		mp.addBodyPart(imagePart);
		mp.addBodyPart(textPart);
		MimeBodyPart mb = new MimeBodyPart();
		mb.setContent(mp);

		MimeBodyPart fujian = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Desktop\\goodsType.csv"));
		fujian.setDataHandler(dh);
		fujian.setFileName(MimeUtility.encodeText(dh.getName()));

	    MimeBodyPart video=new MimeBodyPart();
	    DataHandler dh1=new DataHandler(new FileDataSource("C:\\Users\\Administrator\\Desktop\\帮助文档\\Vim用户手册中文版72.pdf"));
	    video.setDataHandler(dh1);
	    video.setFileName(MimeUtility.encodeText(dh1.getName()));
		
		MimeMultipart mm = new MimeMultipart();
		mm.addBodyPart(mb);
		mm.addBodyPart(fujian); // 如果有多个附件，可以创建多个多次添加
		mm.addBodyPart(fujian);
		mm.addBodyPart(video);
		mm.setSubType("mixed"); // 混合关系
		message.setContent(mm);
		message.saveChanges();
		Transport.send(message);
		System.out.println("Sent message successfully....from runoob.com");
	}
}
