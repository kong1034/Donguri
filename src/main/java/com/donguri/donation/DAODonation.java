package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donguri.find.DAOFind;
import com.donguri.main.DBManager;
import com.google.gson.Gson;

public class DAODonation {
	private List<DTODonation> donations;
	private Connection con = null;
	public static final DAODonation RDAO = new DAODonation();
	
	private DAODonation() {
		try {
			con = DBManager.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void getDonationById(String id) {
        
    }

    public void getAllDonations(HttpServletRequest request, HttpServletResponse response) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        donations = new ArrayList<DTODonation>();
        List<Integer> imgCntList = new ArrayList<Integer>();
        String sql = "select dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, sum(dp.p_price) as SUM"
        		+" from d_donation_list dd"
        		+" inner join d_payment dp"
        		+" on dd.d_no = dp.d_no"
        		+" group by dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount";
        
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
            	int imgCnt = 0;
                DTODonation donation = new DTODonation();
                donation.setTitle(rs.getString("d_title"));
                donation.setDate(rs.getString("d_date"));
                donation.setThumnail(rs.getString("d_thumnail"));
                donation.setAmount(rs.getInt("d_amount"));
                donation.setSum(rs.getInt("SUM"));
                
                int amount = rs.getInt("d_amount");
                int sum = rs.getInt("SUM");
                
                System.out.println("==============");
                System.out.println("check amount => "+amount);
                System.out.println("check sum => "+sum);
                
                double percentage = ((double) sum/amount) * 100;
                
                System.out.println("check percentage => "+percentage);
                
                imgCnt = (int)(percentage/10);
                
                donations.add(donation);
                System.out.println("check imgCnt => "+imgCnt);
                System.out.println("==============");
                imgCntList.add(imgCnt);
                request.setAttribute("imgCntList", imgCntList);
            }
            
            
            
            //JSON Key, Json Value
//            Gson gson = new Gson();
//            String donationJson = gson.toJson(donations);
            
            request.setAttribute("donationList", donations);
			/*
			 * response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8");
			 * response.setStatus(HttpServletResponse.SC_OK);
			 * response.getWriter().print(donationJson);
			 */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }
    
    public void paging(int page, HttpServletRequest request) {
		int cnt = 8; // 한 페이지당 보여줄 개수
		int total = donations.size(); // 총 데이터 개수
		int totalPage = (int)Math.ceil((double)total/cnt); // 총 페이지수
		
		//시작 데이터 번호2 = 총 데이터 수 - (한 페이지당 보여줄 개수 * (페이지 번호 - 1))
		int start = total - (cnt * (page - 1));
		//끝데이터 번호2 = (페이지 번호 == 총 페이지수) ? -1 : 시작데이터번호2 - (한 페이지당 보여줄 개수 +1);
		int end = (page == totalPage) ? -1 : start - (cnt +1);
		
		ArrayList<DTODonation> dItems = new ArrayList<DTODonation>();
		
		for(int i=start-1; i > end; i--) {
			dItems.add(donations.get(i));
		}
		request.setAttribute("pageCnt", totalPage);
		request.setAttribute("curPageNo", page);
		request.setAttribute("dItems", dItems);
	}

	public void daoDonation(HttpServletRequest request, HttpServletResponse response, String donationIdStr, int i) {
		// Implement the logic to retrieve and handle the donation details by ID
        String sql = "SELECT * FROM d_donation_list WHERE d_no = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, donationIdStr);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                DTODonation donation = new DTODonation();
                donation.setTitle(rs.getString("d_title"));
                donation.setDate(rs.getString("d_date"));
                donation.setThumnail(rs.getString("d_thumnail"));
                donation.setAmount(rs.getInt("d_amount"));
                // Set other properties if needed
                request.setAttribute("donation", donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
		
	}
}