package com.donguri.board;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.main.DBManager;
import com.donguri.sign.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import twitter4j.JSONObject;

public class DAOBoard2 {
	private static ArrayList<DTOBoard2> epilogues;
	private static ArrayList<DTOBoard2> comments;
	public static DAOBoard2 DAOB2 = new DAOBoard2();
	private Connection con = null;
		
	private DAOBoard2() {
		try {
			con = DBManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void getAllEpilogue(HttpServletRequest request) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review order by r_date";

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

	public void getOneEpilogue(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review where r_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			DTOBoard2 r = null;
			if (rs.next()) {
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

				request.setAttribute("epilogues", r);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void search(HttpServletRequest request) {
		String field = request.getParameter("f");
		String query = request.getParameter("q");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from review where r_title like '%'||?||'%' order by r_date desc";
		if (field.equals("id")) {
			sql = "select * from review where u_id like '%'||?||'%' order by r_date desc";
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
	
	public void makeEpilogue(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql ="insert into review values(review_seq.nextval,?,?,?,?,?,?,sysdate,?)";
		try {
			con= DBManager.connect();
			pstmt= con.prepareStatement(sql);

			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			
			String path = request.getServletContext().getRealPath("img/local/board");
			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20,"utf-8", new DefaultFileRenamePolicy());
			
			int v_no = Integer.parseInt(mr.getParameter("v_no"));
		    int g_no = Integer.parseInt(mr.getParameter("g_no"));
			String userid = user.getU_id();
			String tag = mr.getParameter("r_tag");
			String title = mr.getParameter("r_title");
			String content = mr.getParameter("r_content");
			String file = mr.getFilesystemName("r_file");
			
			System.out.println(v_no);
			System.out.println(g_no);
			
				pstmt.setInt(1, v_no);
		        pstmt.setInt(2, g_no);
		        pstmt.setString(3, userid);
		        pstmt.setString(4, tag);
		        pstmt.setString(5, title);
		        pstmt.setString(6, content);
		        pstmt.setString(7, file);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공vv");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	
	public void getComment(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_comment where r_no=? order by c_date";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			comments = new ArrayList<DTOBoard2>();
			DTOBoard2 c = null;
			while (rs.next()) {
				c = new DTOBoard2();
				c.setC_no(rs.getInt("c_no"));
				c.setId(rs.getString("u_id"));
				c.setNo(rs.getInt("r_no"));
				c.setC_content(rs.getString("c_content"));
				c.setC_date(rs.getDate("c_date"));
				comments.add(c);

				request.setAttribute("comments", comments);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public void insertComment(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into d_comment (C_NO, U_ID, R_NO, C_CONTENT, C_DATE) values (d_comment_seq.nextval,?,?,?,sysdate)";

		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql, new String[] { "C_NO" });
			
			// User session for get u_id
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			
			JSONObject jsonObject = new JSONObject(sb.toString());
			String userId = user.getU_id();
			String reviewId = jsonObject.getString("reviewId");
			String content = jsonObject.getString("content");

			pstmt.setString(1, userId);
			pstmt.setString(2, reviewId);
			pstmt.setString(3, content);

			if (pstmt.executeUpdate() == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					long generatedKey = rs.getLong(1);

					JSONObject jsonResponse = new JSONObject();
					jsonResponse.put("c_no", generatedKey);
					jsonResponse.put("userId", userId);
					jsonResponse.put("content", content);
					jsonResponse.put("date", new SimpleDateFormat("yy.MM.dd hh:mm").format(new Date()));

					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					PrintWriter out = response.getWriter();
					out.print(jsonResponse.toString());
					out.flush();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public void deleteComment(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		String sql = "delete from d_comment where c_no=?";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("c_no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
				response.getWriter().write("{\"status\": \"success\"}");
			} else {
				response.getWriter().write("{\"status\": \"error\", \"message\": \"Failed to delete comment\"}");
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void updateComment(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
		String sql = "update d_comment set c_content=?, c_date=sysdate where c_no=?"; 
		
		try {
	        con = DBManager.connect();
	        pstmt = con.prepareStatement(sql);
	        
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = request.getReader().readLine()) != null) {
	        	sb.append(line);
	        }
	        JSONObject json = new JSONObject(sb.toString());
	        String c_no = json.getString("comment_no");
	        String comment = json.getString("comment_content");
	        
	        pstmt.setString(1, comment);
	        pstmt.setString(2, c_no);
	        
	        response.setContentType("application/json; charset=UTF-8");

	        if (pstmt.executeUpdate() == 1) {
				System.out.println("업뎃 성공");
				JSONObject jsonResponse = new JSONObject();
				jsonResponse.put("status", "success");
	            response.getWriter().write(jsonResponse.toString());
			} else {
				JSONObject jsonResponse = new JSONObject();
	            jsonResponse.put("status", "error");
	            jsonResponse.put("message", "Failed to update comment");
	            response.getWriter().write(jsonResponse.toString());
			}
		} catch (Exception e) {
		e.printStackTrace();
	
		} finally {
		DBManager.close(con, pstmt, null);
		}
	}
	
	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 4; // 한페이지당 보여줄 개수
		int total = epilogues.size(); // 총 데이터 개수

		int pageCount = (int) Math.ceil((double) total / cnt);
		request.setAttribute("pageCount", pageCount);

		int start = total - (cnt * (page - 1));
		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<DTOBoard2> pages = new ArrayList<DTOBoard2>();
		for (int i = start - 1; i > end; i--) {
			pages.add(epilogues.get(i));
		}
		request.setAttribute("epilogues", pages);
	}

	public List<DTOBoard2> getVolunteerList(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from volunteer_list where g_no=? order by v_date";

		List<DTOBoard2> volunteerList = new ArrayList<>();
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(request.getParameter("no")));
			rs = pstmt.executeQuery();

			DTOBoard2 v = null;
			while (rs.next()) {
				v = new DTOBoard2();
				v.setV_no(rs.getInt("v_no"));
				v.setG_no(rs.getInt("g_no"));
				v.setId(rs.getString("u_id"));
				v.setV_date(rs.getDate("v_date"));
				volunteerList.add(v);

			 request.setAttribute("volunteer", volunteerList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
			return volunteerList;
	}

	public void applyVolunteer(HttpServletRequest request) {

		 	PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    String checkSql = "SELECT COUNT(*) FROM volunteer_list WHERE g_no = ? AND u_id = ?";
		    String insertSql = "insert into volunteer_list values (volunteer_list_seq.nextval, ?, ?, sysdate)";

		    try {
		        con = DBManager.connect();
		        pstmt = con.prepareStatement(checkSql);

		        HttpSession session = request.getSession();
		        UserDTO user = (UserDTO) session.getAttribute("user");

		        int gNo = Integer.parseInt(request.getParameter("no"));
		        String uId = user.getU_id();

		        pstmt.setInt(1, gNo);
		        pstmt.setString(2, uId);
		        rs = pstmt.executeQuery();
		        rs.next();

		        if (rs.getInt(1) > 0) {
		            // 이미 지원한 경우
		            System.out.println("이미 지원한 사용자입니다.");
		            request.setAttribute("errorMessage", "重複支援は不可です");
		        } else {
		            // 지원 가능
		            pstmt.close();
		            pstmt = con.prepareStatement(insertSql);
		            pstmt.setInt(1, gNo);
		            pstmt.setString(2, uId);

		            if (pstmt.executeUpdate() == 1) {
		                System.out.println("지원 완료");
		                request.setAttribute("successMessage", "支援完了");
		            }
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("에러");
		    } finally {
		        DBManager.close(con, pstmt, rs);
		    }
	}
	
	public List<DTOBoard2> getMyVolApply(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select v.v_no, v.g_no, v.u_id, v.v_date, g.g_title from volunteer_list v join d_group_list g on v.g_no = g.g_no  where v.u_id = ? order by v.v_date desc";

		List<DTOBoard2> volunteerList = new ArrayList<>();
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			
			System.out.println(user.getU_id());
			
			pstmt.setString(1, user.getU_id());
			rs = pstmt.executeQuery();

			DTOBoard2 v = null;
			while (rs.next()) {
				v = new DTOBoard2();
				v.setV_no(rs.getInt("v_no"));
				v.setG_no(rs.getInt("g_no"));
				v.setId(rs.getString("u_id"));
				v.setV_date(rs.getDate("v_date"));
				v.setTitle(rs.getString("g_title"));
				volunteerList.add(v);

			 request.setAttribute("myvolapply", volunteerList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
			return volunteerList;
		
		
	}

}
