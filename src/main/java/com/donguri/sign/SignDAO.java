package com.donguri.sign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.donguri.main.Common;
import com.donguri.main.DBManager;
import com.google.gson.Gson;

public class SignDAO {

	public static String randomNumber = "";
	
	
	
	public static void emailVerify(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(request.getParameter("email"));
//		
//		String recipientEmail = request.getParameter("email");
//        String subject = "이메일 인증";
//        String body = "안녕하세요, 이메일을 인증해주세요!";
//        // mzapp
//        // izkr fdqd lrou xszr
//        
//        
//     // Gmail 계정 정보
//        final String username = "guridon60@gmail.com";
//        final String password = "donguri0527";
//
//        // SMTP 서버 설정
//        Properties prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); // TLS 사용
//        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//        // 인증 정보 설정
//        Session session = Session.getInstance(prop, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            // 이메일 메시지 작성
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//            message.setSubject("Test Email ^ 3^");
//            message.setText("This is a test email sent using SMTP with Gmail");
//
//            // 이메일 전송
//            Transport.send(message);
//
//            System.out.println("Email sent successfully");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }

		// parameter
		String email = request.getParameter("email");

		System.out.println("check email => " + email);

		// create Random number
		Random random = new Random();
		

		for (int i = 0; i < 6; i++) {
			int num = random.nextInt(9) + 1;
			randomNumber+=(num);
		}

		// set RandomNum (For confirm user's e-mail)
		request.setAttribute("randomNumber", randomNumber);
		System.out.println(randomNumber);

		try {
			// Gmail SMTP server setting
			String host = "smtp.gmail.com";
			final String username = Common.google_email; // Gmail accpunt
			final String password = Common.google_pw; // Gmail account password

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			// create session
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			// create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("DONGGURI Register Email");
			message.setText("確認コード : " + randomNumber);

			// send message
			Transport.send(message);
			// response
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("Email sent successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("server error");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}

	public static void codeVerify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		try {
			// Do not remove this 
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			
			String code = request.getParameter("code");
			System.out.println(request.getParameter("code"));
			System.out.println((randomNumber));
			if (code.equals(randomNumber)) {
				// send server(boolean)
					response.getWriter().print("true");
				
			}

	}catch(

	IOException e)
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

//	public static void chkConfirmNum(HttpServletRequest request) {
//		// chk emailVerify Num - user input Num
//		HttpSession email_session = request.getSession();
//		String randomNumber = (String) email_session.getAttribute("randomNumber");
//		
//		String confirmNum = request.getParameter("confirmNum");
//		
//		if (confirmNum.equals(randomNumber)) {
//			//존재하는 이메일
//			request.setAttribute("u_email", request.getParameter("email"));
//			System.out.println(request.getParameter("email"));
//		}else {
//			System.out.println("틀렸어.");
//		}
//		
//	}

}
