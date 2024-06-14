package com.donguri.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.donguri.main.DBManager;

public class DAOBoard2 {
	private static ArrayList<DTOBoard2> epilogues;

	public static void getAllEpilogue(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review order by r_date desc" ;

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			epilogues = new ArrayList<DTOBoard2>();
			DTOBoard2 r = null;
			while (rs.next()) {
				r = new DTOBoard2();
				r.setNo(rs.getInt("r_no"));
				r.setV_no(rs.getInt("v_no"));
				r.setG_no(rs.getInt("g_no"));
				r.setId(rs.getString("u_id"));
				r.setTag(rs.getString("r_tag"));
				r.setTitle(rs.getString("r_title"));
				r.setContent(rs.getString("r_content"));
				r.setDate(rs.getDate("r_date"));
				r.setImg(rs.getString("r_img"));
				epilogues.add(r);
			}
			request.setAttribute("epilogues", epilogues);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}		
	}

	public static void search(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from review where r_title like '%'||?||'%' order by r_date desc" ;
		if (field.equals("id")) {
			sql = "select * from review where u_id like '%'||?||'%' order by r_date desc" ;
		} 
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			if (query == null) {
				pstmt.setString(1, field);
			}
			pstmt.setString(1, query);
			rs = pstmt.executeQuery();
			
			epilogues = new ArrayList<DTOBoard2>();
			DTOBoard2 r = null;
			while (rs.next()) {
				r = new DTOBoard2();
				r.setNo(rs.getInt("r_no"));
				r.setV_no(rs.getInt("v_no"));
				r.setG_no(rs.getInt("g_no"));
				r.setId(rs.getString("u_id"));
				r.setTag(rs.getString("r_tag"));
				r.setTitle(rs.getString("r_title"));
				r.setContent(rs.getString("r_content"));
				r.setDate(rs.getDate("r_date"));
				r.setImg(rs.getString("r_img"));
				epilogues.add(r);
			}
			request.setAttribute("epilogues", epilogues);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}
	
	public static void paging(int page, HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("curPageNo", page);
		int cnt = 4;		// 한페이지당 보여줄 개수
		int total = epilogues.size();	// 총 데이터 개수
		
		// 총 페이지수  = 곧 마지막페이지 
		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount);
		
		// 시작, 끝
		int start = total - (cnt * (page -1));
		int end = (page == pageCount) ? -1 : start - (cnt +1);
		
		ArrayList<DTOBoard2> pages = new ArrayList<DTOBoard2>();
		for (int i = start-1; i > end; i--) {
			pages.add(epilogues.get(i));
		}
		request.setAttribute("epilogues", pages);
	}

}
