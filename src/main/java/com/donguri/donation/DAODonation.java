package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<Integer> imgCntList = new ArrayList<Integer>();
        String sql = "SELECT dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount, SUM(dp.p_price) AS SUM " +
                     "FROM d_donation_list dd " +
                     "INNER JOIN d_payment dp ON dd.d_no = dp.d_no " +
                     "GROUP BY dd.d_title, dd.d_date, dd.d_thumnail, dd.d_amount";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int imgCnt = 0;
                DTODonation donation = new DTODonation();
//              

                int amount = rs.getInt("d_amount");
                int sum = rs.getInt("SUM");

                double percentage = ((double) sum / amount) * 100;
                imgCnt = (int)(percentage / 10);

                donations.add(donation);
                imgCntList.add(imgCnt);
                request.setAttribute("imgCntList", imgCntList);
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
        int cnt = 8; // Items per page
        int total = donations.size(); // Total number of items
        int totalPage = (int)Math.ceil((double)total / cnt); // Total number of pages

        int start = total - (cnt * (page - 1)); // Start item index
        int end = (page == totalPage) ? -1 : start - (cnt + 1); // End item index

        ArrayList<DTODonation> dItems = new ArrayList<DTODonation>();

        for(int i = start - 1; i > end; i--) {
            dItems.add(donations.get(i));
        }
        request.setAttribute("pageCnt", totalPage);
        request.setAttribute("curPageNo", page);
        request.setAttribute("dItems", dItems);
    }
}