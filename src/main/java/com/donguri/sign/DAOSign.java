package com.donguri.sign;

import java.io.IOException;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.main.Common;
import com.donguri.main.DBManager;
import com.github.scribejava.core.model.Response;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class DAOSign {
	
	private static final String SECRET_KEY = Common.SECRET_KEY;
	

	public static void login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw =  request.getParameter("pw");
		
		UserDTO user = null;
		
		String dbID = "" ;
		String dbPW = "" ;
		
		String result;
		
		Connection con = null;
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
						null, // User_PW
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
					
					 //JSON Key, Json Value
			         Gson gson = new Gson();
					 
					String userJson = gson.toJson(user);         // 생성된 Json 문자열 출력        System.out.println(jsonStr);
//				
//					request.setAttribute("user", userJson);
					response.getWriter().print(userJson);
					
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


	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie jwtCookie = new Cookie("jwtToken", "");
		jwtCookie.setMaxAge(0);
		
		System.out.println(jwtCookie.getMaxAge());
		
		response.addCookie(jwtCookie);

	}


	public static void signUp(HttpServletRequest request) throws IOException {
		
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
//		String u_grade;
//		String u_no;
//		String u_type;
		String u_telenumber = mr.getParameter("u_telenumber");
		String u_email = mr.getParameter("u_email");
		String u_birth = mr.getParameter("u_birth");
		String u_profileimg = mr.getFilesystemName("u_profileimg"); 
		
		
		
		Connection con = null;
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
	    	   request.getRequestDispatcher("jsp/sign/sign_done.jsp");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Server ERROR");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
		
		
	}
}