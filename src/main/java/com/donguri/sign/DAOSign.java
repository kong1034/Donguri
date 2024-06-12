package com.donguri.sign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.donguri.main.DBManager;

public class DAOSign {

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
				//Generate JST Token
					
					
					
					
				}else {
					System.out.println("Password error");
					result = "Password error";
				}
			}else {
				System.out.println("Non-existent Account");
				result = "Password erroNon-existent Account";
			} 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		
		
	}

}
