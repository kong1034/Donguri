package com.donguri.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.donguri.main.DBManager;
import com.donguri.sign.UserDTO;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import twitter4j.JSONObject;

public class DAOBoard {
	private static ArrayList<DTOBoard> boardlists;
	public static DAOBoard DAOB = new DAOBoard();
	private Connection con = null;
	
	public DAOBoard() {
		try {
			con = DBManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getAllBoardList(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list order by g_date";

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
				if (rs.getString("g_status").equals("O")) {
					b.setStatus("募集中");
				}else {
					b.setStatus("募集終了");
				}
				b.setPlace(rs.getString("g_place"));
				b.setImg(rs.getString("g_img"));
				b.setStartdate(rs.getDate("g_startdate"));
				b.setEnddate(rs.getDate("g_enddate"));
				b.setMeetdate(rs.getDate("g_meetdate"));
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

	public void getOneBoardList(HttpServletRequest request) {
		
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
				b.setContent(rs.getString("g_content").replaceAll("\r\n", "<br>"));
				b.setDate(rs.getDate("g_date"));
				b.setStartdate(rs.getDate("g_startdate"));
				b.setEnddate(rs.getDate("g_enddate"));
				b.setMeetdate(rs.getDate("g_meetdate"));
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
	public List<DTOBoard> getMyBoard(HttpServletRequest request) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from d_group_list where u_id=? order by g_date desc";

		 List<DTOBoard> boardList = new ArrayList<>();
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			
			System.out.println(user.getU_id());
			
			String userid = user.getU_id();
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			DTOBoard mb = null;
			while (rs.next()) {
				mb = new DTOBoard();
				mb.setNo(rs.getInt("g_no"));
				mb.setId(rs.getString("u_id"));
				mb.setTitle(rs.getString("g_title"));
				mb.setContent(rs.getString("g_content"));
				mb.setDate(rs.getDate("g_date"));
				mb.setStartdate(rs.getDate("g_startdate"));
				mb.setEnddate(rs.getDate("g_enddate"));
				mb.setMeetdate(rs.getDate("g_meetdate"));
				mb.setTag(rs.getString("g_tag"));
				mb.setStatus(rs.getString("g_status"));
				mb.setPlace(rs.getString("g_place"));
				mb.setImg(rs.getString("g_img"));
				boardList.add(mb);

			}
			request.setAttribute("myboard", boardList);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("서버에러");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
			return boardList;
	}
	public void makeBoard(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "insert into d_group_list values(d_group_list_seq.nextval,?,?,?,sysdate,?,?,?,?,?,?,?, DEFAULT)";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String path = request.getServletContext().getRealPath("img/local/board");
			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20,"utf-8", new DefaultFileRenamePolicy());
			
			HttpSession session = request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			
			System.out.println(user.getU_id());
			
			String userid = user.getU_id();
			String title = mr.getParameter("title");
			String info = mr.getParameter("info");
			String tag = mr.getParameter("tag");
			String status = mr.getParameter("status");
			String place = mr.getParameter("place");
			String file = mr.getFilesystemName("file");
			String startDate = mr.getParameter("start_date");
			String endDate = mr.getParameter("end_date");
			String meetDate = mr.getParameter("meet_date");
			
			System.out.println(userid);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, title);
			pstmt.setString(3, info);
			pstmt.setString(4, tag);
			pstmt.setString(5, status);
			pstmt.setString(6, place);
			pstmt.setString(7, file);
			pstmt.setString(8, startDate );
			pstmt.setString(9, endDate);
			pstmt.setString(10, meetDate);
			
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
	
	public void paging(int page, HttpServletRequest request) {
		request.setAttribute("curPageNo", page);
		int cnt = 10;		// 한페이지당 보여줄 개수
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

	public void search(HttpServletRequest request) {
		String field = request.getParameter("f");
		String query = request.getParameter("q");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select g_no, u_id, g_title, g_date, g_tag, g_status, g_place from d_group_list where g_title like '%'||?||'%' order by g_date desc" ;
		if (field.equals("id")) {
			sql = "select g_no, u_id, g_title, g_date, g_tag, g_status, g_place from d_group_list where u_id like '%'||?||'%' order by g_date desc" ;
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
				b.setDate(rs.getDate("g_date"));
				b.setTag(rs.getString("g_tag"));
				if (rs.getString("g_status").equals("O")) {
					b.setStatus("募集中");
				}else {
					b.setStatus("募集終了");
				}
				b.setPlace(rs.getString("g_place"));
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

	public List<DTOBoard> tagBoard(HttpServletRequest request, HttpServletResponse response) {
		 
			String tag = request.getParameter("tag");
		    
		    PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from d_group_list where g_tag=? order by g_date desc" ;
			
			try {
				con = DBManager.connect();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, tag);
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
					if (rs.getString("g_status").equals("O")) {
						b.setStatus("募集中");
					}else {
						b.setStatus("募集終了");
					}
					b.setPlace(rs.getString("g_place"));
					b.setImg(rs.getString("g_img"));
					b.setStartdate(rs.getDate("g_startdate"));
					b.setEnddate(rs.getDate("g_enddate"));
					b.setMeetdate(rs.getDate("g_meetdate"));
					boardlists.add(b);
				}
				 response.setContentType("application/json");
			     response.setCharacterEncoding("UTF-8");
			        
				 Gson gson = new Gson();
			     String json = gson.toJson(boardlists);
			        
			    response.getWriter().write(json);
				return boardlists;
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("서버에러");
			} finally {
				DBManager.close(con, pstmt, rs);
			}
			return boardlists;
	}

	public void updateStatus(HttpServletRequest request) {
		PreparedStatement pstmt= null;
		String sql="update d_group_list set g_status=? where g_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "X");
			pstmt.setString(2, request.getParameter("no"));
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("status 모집종료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void deleteBoard(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "delete from d_group_list where g_no=?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("no"));

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
				request.setAttribute("deleteSuccess", "削除完了");
			} else {
				request.setAttribute("deleteError", "削除失敗");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}
	public void likesBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sqlCheckLike = "SELECT COUNT(*) FROM user_likes WHERE u_id = ? AND g_no = ?";
	    String sqlUpdateLikes = "UPDATE d_group_list SET g_likes = g_likes + 1 WHERE g_no = ?";
	    String sqlInsertLike = "INSERT INTO user_likes (u_id, g_no) VALUES (?, ?)";
	    String sqlGetLikes = "SELECT g_likes FROM d_group_list WHERE g_no = ?";
	    
	    HttpSession session = request.getSession();
	    UserDTO user = (UserDTO) session.getAttribute("user");
	    
	    String userId = user.getU_id();
	    String postNo = request.getParameter("no");
	    JSONObject json = new JSONObject();

	    try {
	        con = DBManager.connect();

	        // 사용자가 이미 좋아요 했는지 확인
	        pstmt = con.prepareStatement(sqlCheckLike);
	        pstmt.setString(1, userId);
	        pstmt.setString(2, postNo);
	        rs = pstmt.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            json.put("success", false);
	            json.put("message", "이미 좋아요를 누르셨습니다.");
	        } else {
	            // 좋아요 수 업데이트
	            pstmt.close();
	            pstmt = con.prepareStatement(sqlUpdateLikes);
	            pstmt.setString(1, postNo);
	            if (pstmt.executeUpdate() == 1) {
	                // user_likes 테이블에 삽입
	                pstmt.close();
	                pstmt = con.prepareStatement(sqlInsertLike);
	                pstmt.setString(1, userId);
	                pstmt.setString(2, postNo);
	                pstmt.executeUpdate();

	                // 업데이트된 좋아요 수 가져오기
	                pstmt.close();
	                pstmt = con.prepareStatement(sqlGetLikes);
	                pstmt.setString(1, postNo);
	                rs = pstmt.executeQuery();
	                
	                if (rs.next()) {
	                    int likes = rs.getInt("g_likes");
	                    json.put("success", true);
	                    json.put("likes", likes);
	                } else {
	                    json.put("success", false);
	                }
	            } else {
	                json.put("success", false);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        json.put("success", false);
	    } finally {
	        DBManager.close(con, pstmt, rs);
	    }

	    response.setContentType("application/json");
	    response.getWriter().write(json.toString());
	}
	
	public void likesBoard2(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        String sqlUpdateLikes = "update d_group_list set g_likes = g_likes + 1 where g_no = ?";
	        String sqlGetLikes = "select g_likes from d_group_list where g_no = ?";
	        JSONObject json = new JSONObject();

	        try {
	            con = DBManager.connect();
	            pstmt = con.prepareStatement(sqlUpdateLikes);
	            pstmt.setString(1, request.getParameter("no"));
	            
	            if (pstmt.executeUpdate() == 1) {
	                pstmt.close();

	                pstmt = con.prepareStatement(sqlGetLikes);
	                pstmt.setString(1, request.getParameter("no"));
	                rs = pstmt.executeQuery();
	                
	                if (rs.next()) {
	                    int likes = rs.getInt("g_likes");
	                    json.put("success", true);
	                    json.put("likes", likes);
	                } else {
	                    json.put("success", false);
	                }
	            } else {
	                json.put("success", false);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            json.put("success", false);
	        } finally {
	            DBManager.close(con, pstmt, rs);
	        }

	        response.setContentType("application/json");
	        response.getWriter().write(json.toString());
	    }

	public void updateBoard(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		String sql = "update d_group_list set g_title=?, g_content=?, g_tag=?, g_place=?, "
				+ "g_img=?, g_startdate=?, g_enddate=?, g_meetdate=? where g_no =?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String path = request.getServletContext().getRealPath("img/local/board");
			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20,"utf-8", new DefaultFileRenamePolicy());
			
			String title = mr.getParameter("title");
			String info = mr.getParameter("info");
			String tag = mr.getParameter("tag");
			String place = mr.getParameter("place");
			
			String newFile = mr.getFilesystemName("newFile");
			String oldFile = mr.getParameter("oldFile");
			
			String file3 = oldFile;
			if (newFile != null) {
				file3 = newFile;
			}
			String startDate = mr.getParameter("start_date");
			String endDate = mr.getParameter("end_date");
			String meetDate = mr.getParameter("meet_date");
			int no= Integer.parseInt(mr.getParameter("no"));
			
			pstmt.setString(1, title);
			pstmt.setString(2, info);
			pstmt.setString(3, tag);
			pstmt.setString(4, place);
			pstmt.setString(5, file3);
			pstmt.setString(6, startDate );
			pstmt.setString(7, endDate);
			pstmt.setString(8, meetDate);
			pstmt.setInt(9, no);
			
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

	public void getMyLikes(HttpServletRequest request) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select d.g_title, ul.g_no from user_likes ul join d_group_list d on ul.g_no = d.g_no where ul.u_id= ?";
		
		HttpSession session = request.getSession();
	    UserDTO user = (UserDTO) session.getAttribute("user");
	    String userId = user.getU_id();
		
	    try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			List<DTOBoard> dTitles = new ArrayList<>();
			DTOBoard dt = null;
			while (rs.next()) {
				dt = new DTOBoard();
				dt.setTitle(rs.getString("g_title"));
				dt.setNo(rs.getInt("g_no"));
				dTitles.add(dt);
			}
			request.setAttribute("dTitles", dTitles);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
	}
		
	}
	
	
	
	
