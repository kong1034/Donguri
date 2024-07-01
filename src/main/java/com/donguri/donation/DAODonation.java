package com.donguri.donation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.donguri.main.DBManager;
import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAODonation {
	private List<DTODonation> donations;
	private List<Integer> imgCntList;
	private Connection con = null;
	public static final DAODonation RDAO = new DAODonation();
	
	private DAODonation() {
		try {
			con = DBManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    // Method to get donation details by ID
    public DTODonation getDonationById(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTODonation donation = null;

        String sql = "SELECT dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, SUM(dp.p_price) AS sum, COUNT(dp.p_price) AS count, dd.d_start_date, dd.d_end_date, dd.d_organization " +
                     "FROM d_donation_list dd " +
                     "LEFT JOIN d_payment dp ON dd.d_no = dp.d_no " +
                     "WHERE dd.d_no = ? " +
                     "GROUP BY dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, dd.d_start_date, dd.d_end_date, dd.d_organization";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DTODonation();
//                donation.setTitle(rs.getString("d_title"));
//                donation.setDate(rs.getString("d_date"));
//                donation.setThumnail(rs.getString("d_thumnail"));
//                donation.setAmount(rs.getInt("d_amount"));
//                donation.setSum(rs.getInt("sum"));
//                donation.setCreatedDate(rs.getString("d_created_date"));
//                donation.setDate(rs.getString("d_date"));
//                donation.setPublisher(rs.getString("d_publisher"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return donation;
    }

    // Method to get all donations
    public void getAllDonations(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        donations = new ArrayList<DTODonation>();
        imgCntList = new ArrayList<Integer>();
        String sql = "select dd.d_no, dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, coalesce(sum(dp.p_price), 0) as SUM"
        		+" from d_donation_list dd"
        		+" left join d_payment dp"
        		+" on dd.d_no = dp.d_no"
        		+" group by dd.d_no, dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount"
        		+" order by dd.d_no desc";
        
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int imgCnt = 0;
                DTODonation donation = new DTODonation();
                donation.setNo(rs.getInt("d_no"));
                donation.setTitle(rs.getString("d_title"));
                donation.setDate(rs.getString("d_date"));
                donation.setThumnail(rs.getString("d_thumnail"));
                donation.setAmount(rs.getInt("d_amount"));
                donation.setSum(rs.getInt("SUM"));
                
                int amount = rs.getInt("d_amount");
                int sum = rs.getInt("SUM");

                double percentage = ((double) sum / amount) * 100;
                imgCnt = (int)(percentage / 10);

                donations.add(donation);
                imgCntList.add(imgCnt);
                System.out.println("check imgCntList => "+imgCntList);
                //request.setAttribute("imgCntList", imgCntList);
            }

            request.setAttribute("donationList", donations);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }

    // Method for pagination
    public void paging(int page, HttpServletRequest request) {
    	int cnt = 8; // show page count
        int total = donations.size(); // show page data count
        int totalPage = (int) Math.ceil((double) total / cnt); // total page count

        // start index & end index
        int start = (page - 1) * cnt;
        int end = Math.min(start + cnt, total);

        ArrayList<DTODonation> dItems = new ArrayList<DTODonation>();
        ArrayList<Integer> pagedImgCntList = new ArrayList<Integer>();

        for (int i = start; i < end; i++) {
            dItems.add(donations.get(i));
            pagedImgCntList.add(imgCntList.get(i));
        }

        request.setAttribute("pageCnt", totalPage);
        request.setAttribute("curPageNo", page);
        request.setAttribute("dItems", dItems);
        request.setAttribute("pagedImgCntList", pagedImgCntList);
	}

	public void postDonationMake(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement pstmt = null;
        String sql = "insert into d_donation_list values(d_donation_list_seq.nextval, default, ?,?,?,?,?,?,?,　default)";
        
        try {
        	String path = request.getServletContext().getRealPath("img/server");
			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*20, "utf-8", new DefaultFileRenamePolicy());
        	
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String thumbnail = mr.getFilesystemName("thumbnail");
			int amount = Integer.parseInt(mr.getParameter("amount"));
			String end_date = mr.getParameter("end_date");
			String publisher = mr.getParameter("publisher");
			String tag = mr.getParameter("tag");
			
			LocalDate localDate = LocalDate.parse(end_date);
			Date date = Date.valueOf(localDate);
			
			content = content.replaceAll("\r\n", "<br>");
;			
			System.out.println("check title in dao => "+title);
			System.out.println("check content in dao => "+content);
			System.out.println("check thumbnail in dao => "+thumbnail);
			System.out.println("check amount in dao => "+amount);
			System.out.println("check date in dao => "+date);
			System.out.println("check publisher in dao => "+publisher);
			System.out.println("check tag in dao => "+tag);
			
        	pstmt = con.prepareStatement(sql);
        	
        	pstmt.setString(1, title);
        	pstmt.setString(2, content);
        	pstmt.setString(3, thumbnail);
        	pstmt.setInt(4, amount);
        	pstmt.setDate(5, date);
        	pstmt.setString(6, publisher);
        	pstmt.setString(7, tag);
        	
        	if(pstmt.executeUpdate() == 1) {
				System.out.println("입력 성공");
        	}
        	
        } catch(Exception e) {
        	e.printStackTrace();
			System.err.println("서버에러");
        } finally {
			DBManager.close(con, pstmt, null);
		}
	}

	
}