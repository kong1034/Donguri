package com.donguri.donation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonation {

    public List<DTODonation> getAllDonations() {
        List<DTODonation> donations = new ArrayList<>();
        try (Connection conn = DBManager.connect();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM d_donation_list");
             ResultSet rs = pstmt.executeQuery()) {
             
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
        }
        return donations;
    }
}