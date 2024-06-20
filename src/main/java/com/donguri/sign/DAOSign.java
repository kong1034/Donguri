package com.donguri.sign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.main.Common;
import com.donguri.main.DBManager;
import com.github.scribejava.core.model.Response;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class DAOSign {
	
	private Connection con = null;
	public static final DAOSign RDAO = new DAOSign();
	
	private DAOSign() {
		try {
			con = DBManager.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// SECRET_KEY
	private static final String SECRET_KEY = Common.SECRET_KEY;
	// Create RandomNumber for e-maiil Chk
	static StringBuilder randomNumber = new StringBuilder();
	
	//Get User Session
	public void getUserSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		if (session != null) {
			UserDTO user = (UserDTO) session.getAttribute("user");
			System.out.println("세션 불러오기 성공");
		}else {
			System.out.println("로그인 하세요");
			response.sendRedirect("LoginC");
		}
		
	}
	
	// JWT Validation Method
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
	
	// Login Method(JWT Token/Gson)
	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw =  request.getParameter("pw");
		
		UserDTO user = null;
		
		String dbID = "" ;
		String dbPW = "" ;
		
		String result;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from d_user where u_id = ?";
		
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			result = "logout";
			
			if (rs.next()) {
				dbPW = rs.getString(3);
				if (pw.equals(dbPW)) {
					System.out.println("Login successful");
					result = id;
					
					user = new UserDTO(
							rs.getString(1), 
							rs.getString(2), 
							rs.getString(3),
							rs.getString(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7), 
							rs.getString(8), 
							rs.getDate(9), 
							rs.getString(10)
							);
					
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					
					// Session
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(600);
					
					//JSON Key, Json Value
			         Gson gson = new Gson();
			         String userJson = gson.toJson(user);         // 생성된 Json 문자열 출력        System.out.println(jsonStr);
			         response.getWriter().print(userJson);
			         System.out.println(userJson);
			         
				// 256-bit random key
					Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
				//Generate JST Token
					String jwtToken = Jwts.builder()
							.setSubject(id)
							.setIssuedAt(new Date())
							.setExpiration(new Date(System.currentTimeMillis()+3600000))
							.signWith(key)
							.compact();
					  
					 request.setAttribute("jwtToken", jwtToken);
					
				}else {
					System.out.println("Password error");
					result = "logout";
				}
			}else {
				System.out.println("Non-existent Account");
				result = "logout";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			result = "logout";
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		request.setAttribute("result", result);
	}

	// Logout method
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie jwtCookie = new Cookie("jwtToken", "");
		jwtCookie.setMaxAge(0);
		
		System.out.println(jwtCookie.getMaxAge());
		
		response.addCookie(jwtCookie);

	}

	// SignUp method
	public void signUp(HttpServletRequest request) throws IOException {
		
		String path = request.getServletContext().getRealPath("img/server");
		
		MultipartRequest mr = new MultipartRequest(
				request,
				path,	
				1024*1024*20,  
				"utf-8", 
				new DefaultFileRenamePolicy()
				);
		
		String u_id = mr.getParameter("u_id");
		String u_name = mr.getParameter("u_name");
		String u_pw = mr.getParameter("u_pw");
		String u_telenumber = mr.getParameter("u_telenumber");
		String u_email = mr.getParameter("u_email");
		String u_birth = mr.getParameter("u_birth");
		String u_profileimg = mr.getFilesystemName("u_profileimg"); 
		
		System.out.println(u_id);
		System.out.println(u_name);
		System.out.println(u_pw);
		System.out.println(u_telenumber);
		System.out.println(u_email);
		System.out.println(u_profileimg);
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into D_USER values (?, ?, ?, DEFAULT, d_user_seq.nextval, DEFAULT, ?, ?, ?, ? )";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_name);
			pstmt.setString(3, u_pw);
			pstmt.setString(4, u_telenumber);
			pstmt.setString(5, u_email);
			
			LocalDate birthDate = LocalDate.parse(u_birth);
	        pstmt.setDate(6, java.sql.Date.valueOf(birthDate));
			
	        pstmt.setString(7, u_profileimg);
	        
	       if (pstmt.executeUpdate() == 1) {
	    	   System.out.println("SignUp Complete!");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Server ERROR");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	// EmailVerify method for signIn
	public static void emailVerify(HttpServletRequest request, HttpServletResponse response) {
		// parameter
		String email = request.getParameter("email");

		System.out.println("check email => " + email);

		// create Random number
		 Random random = new Random();
	        StringBuilder randomNumber = new StringBuilder();
	        for (int i = 0; i < 6; i++) {
	            int num = random.nextInt(9) + 1; 
	            randomNumber.append(num);
	        }

		// set RandomNum (For confirm user's e-mail)
	    HttpSession session2 = request.getSession();
		session2.setAttribute("randomNumber", randomNumber.toString());
		System.out.println("Generated random number: " + randomNumber);

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

	// compare input code and confirmation code for signIn
	public static void codeVerify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		try {
			// Do not remove this 
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			HttpSession session = request.getSession();
			String randomNumber = (String) session.getAttribute("randomNumber");
			String code = request.getParameter("code");
			System.out.println("랜덤 숫자 값: " + randomNumber);
			System.out.println("입력 숫자 값: " + request.getParameter("code"));
			if (code.equals(randomNumber)) {
				// send server(boolean)
					response.getWriter().print(true);
					System.out.println("조건문 통과");
			}

	}catch(IOException e)
	{
			
			e.printStackTrace();
		}
	}

}
