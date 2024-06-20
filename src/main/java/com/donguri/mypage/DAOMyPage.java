package com.donguri.mypage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.main.DBManager;
import com.donguri.sign.DAOSign;
import com.donguri.sign.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAOMyPage {
		
	private Connection con = null;
	public static final DAOMyPage RDAO = new DAOMyPage();
	
	private DAOMyPage() {
		try {
			con = DBManager.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateMyPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE D_USER SET u_pw = ?, u_name = ?, u_telenumber = ?, u_profileimg = ? WHERE u_id = ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, u_pw);
			pstmt.setString(2, u_name);
			pstmt.setString(3, u_telenumber);
			pstmt.setString(4, u_profileimg);
			pstmt.setString(5, u_id);
			
	       if (pstmt.executeUpdate() == 1) {
	    	   System.out.println("Update Complete!");
		}else {
			System.out.println("Can't Update");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Server ERROR");
		}finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

}
