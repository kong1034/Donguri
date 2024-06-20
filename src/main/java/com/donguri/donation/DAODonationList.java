package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonationList {

    public DTODonationList getDonationById(String id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTODonationList donation = null;

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM donations WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DTODonationList();
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

    public List<DTODonationList> getAllDonations() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DTODonationList> donations = new ArrayList<DTODonationList>();

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM donations";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTODonationList donation = new DTODonationList();
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