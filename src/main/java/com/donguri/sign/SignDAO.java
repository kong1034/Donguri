package com.donguri.sign;

import java.util.Properties;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class SignDAO {

	public static void emailVerify(HttpServletRequest request) {
		System.out.println(request.getParameter("email"));
		
		String recipientEmail = "yureeeee@naver.com";
        String subject = "이메일 인증";
        String body = "안녕하세요, 이메일을 인증해주세요!";
        // mzapp
        // izkr fdqd lrou xszr
        
        
     // Gmail 계정 정보
        final String username = "milo.lee1605@gmail.com";
        final String password = "izkrfdqdlrouxszr";

        // SMTP 서버 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS 사용
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // 인증 정보 설정
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 이메일 메시지 작성
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Test Email ^ 3^");
            message.setText("This is a test email sent using SMTP with Gmail");

            // 이메일 전송
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
		
	

}
