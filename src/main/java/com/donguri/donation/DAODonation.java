package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonation {

    public DTODonation getDonationById(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTODonation donation = null;

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM donations WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DTODonation();
                donation.setId(rs.getString("id"));
                donation.setImageUrl(rs.getString("image_url"));
                donation.setTag(rs.getString("tag"));
                donation.setAmount(rs.getBigDecimal("amount"));
                donation.setProgress(rs.getInt("progress"));
                donation.setStartDate(rs.getDate("start_date"));
                donation.setEndDate(rs.getDate("end_date"));
                donation.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return donation;
    }

    public List<DTODonation> getAllDonations() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DTODonation> donations = new ArrayList<DTODonation>();

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM donations";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTODonation donation = new DTODonation();
                donation.setId(rs.getString("id"));
                donation.setImageUrl(rs.getString("image_url"));
                donation.setTag(rs.getString("tag"));
                donation.setAmount(rs.getBigDecimal("amount"));
                donation.setProgress(rs.getInt("progress"));
                donation.setStartDate(rs.getDate("start_date"));
                donation.setEndDate(rs.getDate("end_date"));
                donation.setDescription(rs.getString("description"));
                donations.add(donation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return donations;
    }
}