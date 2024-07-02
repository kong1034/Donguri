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
import com.google.gson.JsonObject;
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
	private static final byte[] SECRET_KEY = Common.SECRET_KEY.getBytes();
	
	// Create RandomNumber for e-maiil Chk
	static StringBuilder randomNumber = new StringBuilder();
	
	// get JWT(Cookie)
    public static Claims extractAndValidateToken(HttpServletRequest request) throws Exception {
        String jwtToken = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtToken")) {
                    jwtToken = cookie.getValue();
                }
            }
        }

        if (jwtToken != null) {
           return validateToken(jwtToken);
        } else {
            throw new Exception("JWT Token not found");
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
    
  //Get User Session Method
  	public static void getUserSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
  		
  		HttpSession session = request.getSession();
  		
  		if (session != null) {
  			UserDTO user = (UserDTO) session.getAttribute("user");
  		}
  		
  	}
    
	// Login Method(JWT Token/Gson)
	public void login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw =  request.getParameter("pw");
		
		UserDTO user = null;
		
		String dbID = "" ;
		String dbPW = "" ;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from d_user where u_id = ?";
		
		Gson gson = new Gson();
		JsonObject resData = new JsonObject();
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbPW = rs.getString(3);
				if (pw.equals(dbPW)) {
					System.out.println("Login successful");
					
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
					
					// Session
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(3600);
					
					//JSON Key, Json Value
			        resData.addProperty("success", true);
			        resData.add("user", gson.toJsonTree(user));
			        
			        response.setContentType("application/json");
			        response.setCharacterEncoding("utf-8");
			        response.getWriter().write(gson.toJson(resData));
			         
			       // 256-bit random key
					Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
				
				  //Generate JST Token
					String jwtToken = Jwts.builder()
							.setSubject(id)
							.setIssuedAt(new Date())
							.setExpiration(new Date(System.currentTimeMillis()+3600000))
							.signWith(Keys.hmacShaKeyFor(SECRET_KEY), SignatureAlgorithm.HS256)
							.compact();
					
				 //Generate Cookie
					Cookie jwtCookie = new Cookie("jwtToken", jwtToken);
				
				 // login status time limit
					jwtCookie.setMaxAge(3600);
					response.addCookie(jwtCookie); 
					
				}else {
					System.out.println("Password error");
	                resData.addProperty("message", "パスワードが違います。");
	                resData.addProperty("success", false);
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                response.getWriter().write(resData.toString());
					
				}
			}else {
				System.out.println("Non-existent Account");
                resData.addProperty("message", "アカウントが存在しません。");
                resData.addProperty("success", false);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(resData.toString());
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	// Logout Method
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Cookie delete
		Cookie jwtCookie = new Cookie("jwtToken", "");
		jwtCookie.setMaxAge(0);
		
		System.out.println(jwtCookie.getMaxAge());
		
		response.addCookie(jwtCookie);
		// Session delete
		HttpSession hs = request.getSession();
		hs.setAttribute("user", null);
	}

	// SignUp Method
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
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			HttpSession session = request.getSession();
			String randomNumber = (String) session.getAttribute("randomNumber");
			String code = request.getParameter("code");
			System.out.println("確認コード: " + randomNumber);
			System.out.println("入力番号: " + request.getParameter("code"));
			if (code.equals(randomNumber)) {
				// send server(boolean)
					response.getWriter().print(true);
			}

			}catch(IOException e){
				e.printStackTrace();
			}
	}

	
	// User Delete Method
	public void userDel(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String sql = "DELETE FROM d_user WHERE u_id = ? ";
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("会員退会成功");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
	
	// checking xUser already sign in
	public void xUserRegChk(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		XUserDTO xuser = (XUserDTO) session.getAttribute("twitterUser");
		String xuserID = xuser.getX_id();
		
		UserDTO user = null;
		
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		String sql = "select * from d_user where u_id = ?";	
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, xuserID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("Login successful");
				
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
				
				// Session
				HttpSession session2 = request.getSession();
				session2.setAttribute("user", user);
				session2.setMaxInactiveInterval(3600);
		         
			// 256-bit random key
				Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			//Generate JST Token
				String jwtToken = Jwts.builder()
						.setSubject(xuserID)
						.setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis()+3600000))
						.signWith(Keys.hmacShaKeyFor(SECRET_KEY), SignatureAlgorithm.HS256)
						.compact();
				  
				request.setAttribute("jwtToken", jwtToken);
			
			//Generate Cookie
			
				Cookie jwtCookie = new Cookie("jwtToken", jwtToken);
				
			 // login status time limit(1H)
				
				jwtCookie.setMaxAge(3600);
				response.addCookie(jwtCookie); 
				request.getRequestDispatcher("HC").forward(request, response);
				 
			}else {
				response.sendRedirect("SignupInfoC");
				System.out.println("Can't find User information in DB. You should signIn first.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
	}	

}
