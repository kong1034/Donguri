package com.donguri.find;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.main.Common;
import com.donguri.main.DBManager;

public class DAOFind {
	private Connection conn = null;
	public static final DAOFind RDAO = new DAOFind();
	
	private DAOFind() {
		try {
			conn = DBManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void findId(HttpServletRequest request, HttpServletResponse response) {
		// db setting
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// parameter
		String email = request.getParameter("email");
		String name = request.getParameter("name");

		System.out.println("check email => " + email);
		System.out.println("check name => " + name);

		// sql
		String sql = "select * from d_user where u_email = ? and u_name = ?";

		try {
			// account valid check
			conn = DBManager.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();

			// account valid success
			if (rs.next()) {
				// Gmail SMTP server setting
				String host = "smtp.gmail.com";
				final String username = Common.googleEmail; // Gmail account
				final String password = Common.googlePw; // Gmail account password
				// kqyrqtymndcgmhtg
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
				message.setSubject("DONGGURI Find ID Result.");

				message.setText("Your ID : " + rs.getString("u_id"));

				// send message
				Transport.send(message);

				// response
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().println("Email sent successfully!");
				// account valid error
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().println("Invalid account.");
				System.err.println("account invalid error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("server error");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	public void findPw(HttpServletRequest request, HttpServletResponse response) {
		// db setting
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;

		// parameter
		String email = request.getParameter("email");
		String id = request.getParameter("id");

		System.out.println("check email => " + email);
		System.out.println("check id => " + id);

		// sql
		String sql = "select * from d_user where u_email = ? and u_id = ?";
		String sql2 = "update d_user set u_pw = ? where u_id = ?";

		// create Random number
        Random random = new Random();
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(9) + 1; 
            randomNumber.append(num);
        }

		try {
			// account valid check
			conn = DBManager.connect();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, id);

			rs = pstmt.executeQuery();

			// account valid success
			if (rs.next()) {
				// update pw

				pstmt2 = conn.prepareStatement(sql2);

				pstmt2.setString(1, randomNumber.toString());
				pstmt2.setString(2, id);

				pstmt2.executeQuery();

				if (pstmt2.executeUpdate() == 1) {
					// Gmail SMTP server setting
					String host = "smtp.gmail.com";
					final String username = Common.googleEmail; // Gmail accpunt
					final String password = Common.googlePw; // Gmail account password

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
					message.setSubject("DONGGURI Find PW Result.");
					message.setText("仮パスワード : " + randomNumber);

					// send message
					Transport.send(message);

					// response
					response.setStatus(HttpServletResponse.SC_OK);
					response.getWriter().println("Email sent successfully!");
				}
				// account valid error
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().println("Invalid account.");
				System.err.println("account invalid error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("server error");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

	}
}
