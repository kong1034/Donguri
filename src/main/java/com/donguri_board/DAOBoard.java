package com.donguri_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.donguri.main.DBManager;

public class DAOBoard {

	public static void getAllBoardList(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<DTOBoard> boardlists = new ArrayList<DTOBoard>();
			while (rs.next()) {
				
				DTOBoard b = new DTOBoard();
				b.setNo(rs.getInt("g_no"));
				b.setId(rs.getString("u_id"));
				b.setTitle(rs.getString("g_title"));
				b.setContent(rs.getString("g_content"));
				b.setDate(rs.getDate("g_date"));
				b.setStatus(rs.getString("g_status"));
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));
				boardlists.add(b);
			}
			request.setAttribute("boardlists", boardlists);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void getOneBoardList(HttpServletRequest request) {

		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list where g_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				DTOBoard b = new DTOBoard();
				b.setNo(rs.getInt("g_no"));
				b.setId(rs.getString("u_id"));
				b.setTitle(rs.getString("g_title"));
				b.setContent(rs.getString("g_content"));
				b.setDate(rs.getDate("g_date"));
				b.setStatus(rs.getString("g_status"));
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));
				
				request.setAttribute("boardlists", b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		}finally {
			DBManager.close(con, pstmt, rs);
		}
				
	}

}
