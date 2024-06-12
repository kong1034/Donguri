package com.donguri.sign;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.donguri.main.DBManager;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class DAOSign {
	
	private static final String SECRET_KEY = System.getenv("JWT_SECRET_KEY");
	

	public static void login(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw =  request.getParameter("pw");
		
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
			
			if (rs.next()) {
				dbPW = rs.getString(3);
				if (pw.equals(dbPW)) {
					System.out.println("Login successful");
					result = "login";
				// 256-bit random key
					Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
				//Generate JST Token
					String jwtToken = Jwts.builder()
							.setSubject(dbID)
							.setIssuedAt(new Date())
							.setExpiration(new Date(System.currentTimeMillis()+3600000))
							.signWith(key)
							.compact();
					
					// Test
					  System.out.println("Generated JWT Token: " + jwtToken);
					  
					 request.setAttribute("jstToken", jwtToken);
					
				}else {
					System.out.println("Password error");
					result = "Password error";
				}
			}else {
				System.out.println("Non-existent Account");
				result = "Non-existent Account";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			result = "ServerError";
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		request.setAttribute("result", result);
	}

}
