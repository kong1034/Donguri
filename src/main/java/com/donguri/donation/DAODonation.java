package com.donguri.donation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonation {
    
    public List<DTODonation> getAllDonations() {
        List<DTODonation> donations = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.connect();
            String sql = "SELECT * FROM d_donation_list";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTODonation donation = new DTODonation();
                donation.setD_no(rs.getInt("d_no"));
                donation.setUser_id(rs.getString("user_id"));
                donation.setDonation_title(rs.getString("donation_title"));
                donation.setDonation_content(rs.getString("donation_content"));
                donation.setDonation_date(rs.getDate("donation_date"));
                donation.setPayment_no(rs.getInt("payment_no"));
                donation.setPrice(rs.getDouble("price"));
                donation.setPayment_date(rs.getDate("payment_date"));
                donations.add(donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return donations;
    }
}