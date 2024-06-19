package com.donguri.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.donguri.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAOBoard {
	private static ArrayList<DTOBoard> boardlists;

	public static void getAllBoardList(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list order by g_date desc" ;

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			boardlists = new ArrayList<DTOBoard>();
			DTOBoard b = null;
			while (rs.next()) {
				b = new DTOBoard();
				b.setNo(rs.getInt("g_no"));
				b.setId(rs.getString("u_id"));
				b.setTitle(rs.getString("g_title"));
				b.setContent(rs.getString("g_content"));
				b.setDate(rs.getDate("g_date"));
				b.setTag(rs.getString("g_tag"));
				if (rs.getString("g_status").equals("구")) {
					b.setStatus("募集中");
				}else {
					b.setStatus("募集終了");
				}
				
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));
				boardlists.add(b);
			}
			request.setAttribute("boardlists", boardlists);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getOneBoardList(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list where g_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			DTOBoard b = null;
			if (rs.next()) {
				b = new DTOBoard();
				b.setNo(rs.getInt("g_no"));
				b.setId(rs.getString("u_id"));
				b.setTitle(rs.getString("g_title"));
				b.setContent(rs.getString("g_content"));
				b.setDate(rs.getDate("g_date"));
				b.setTag(rs.getString("g_tag"));
				b.setStatus(rs.getString("g_status"));
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));

				request.setAttribute("boardlists", b);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void makeBoard(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into d_group_list values(d_group_list_seq.nextval,?,?,?,?,?,?,?,?)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String path = request.getServletContext().getRealPath("img/local/board");
			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20,"utf-8", new DefaultFileRenamePolicy());
			
			String userid = request.getParameter("id"); 
			String title = mr.getParameter("title");
			String tag = mr.getParameter("tag");
			String file = mr.getFilesystemName("file");
			String place = mr.getParameter("place");
			String date = mr.getParameter("date");
			String info = mr.getParameter("info");
			
			System.out.println(userid);
			
			pstmt.setString(1, "yuree");
			pstmt.setString(2, title);
			pstmt.setString(3, info);
			pstmt.setString(4, date);
			pstmt.setString(5, tag);
			pstmt.setString(6, "구");
			pstmt.setString(7, place);
			pstmt.setString(8, file);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 ㅜㅜ");
			
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 4;		// 한페이지당 보여줄 개수
		int total = boardlists.size();	// 총 데이터 개수
		
		// 총 페이지수  = 곧 마지막페이지 
		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount);
		
		// 시작, 끝
		int start = total - (cnt * (page -1));
		int end = (page == pageCount) ? -1 : start - (cnt +1);
		
		ArrayList<DTOBoard> pages = new ArrayList<DTOBoard>();
		for (int i = start-1; i > end; i--) {
			pages.add(boardlists.get(i));
		}
		request.setAttribute("boardlists", pages);
	}

	public static void search(HttpServletRequest request) {
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from d_group_list where g_title like '%'||?||'%' order by g_date desc" ;
		if (field.equals("id")) {
			sql = "select * from d_group_list where u_id like '%'||?||'%' order by g_date desc" ;
		} 
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			if (query == null) {
				pstmt.setString(1, field);
			}
			pstmt.setString(1, query);
			rs = pstmt.executeQuery();
			
			boardlists = new ArrayList<DTOBoard>();
			DTOBoard b = null;
			while (rs.next()) {
				b = new DTOBoard();
				b.setNo(rs.getInt("g_no"));
				b.setId(rs.getString("u_id"));
				b.setTitle(rs.getString("g_title"));
				b.setContent(rs.getString("g_content"));
				b.setDate(rs.getDate("g_date"));
				b.setTag(rs.getString("g_tag"));
				if (rs.getString("g_status").equals("구")) {
					b.setStatus("募集中");
				}else {
					b.setStatus("募集終了");
				}
				
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));
				boardlists.add(b);
			}
			request.setAttribute("boardlists", boardlists);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		
	}
	
	
	
	
}
