package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonationList {

    // Retrieve a donation by its ID
    public DTODonationList getDonationById(int dNo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTODonationList donation = null;

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM d_donation_list WHERE d_no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, dNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                donation = new DTODonationList();
                donation.setDNo(rs.getInt("d_no"));
                donation.setUId(rs.getString("u_id"));
                donation.setDTitle(rs.getString("d_title"));
                donation.setDContent(rs.getString("d_content"));
                donation.setDDate(rs.getDate("d_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return donation;
    }

    // Retrieve all donations
    public List<DTODonationList> getAllDonations() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DTODonationList> donations = new ArrayList<>();

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM d_donation_list";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTODonationList donation = new DTODonationList();
                donation.setDNo(rs.getInt("d_no"));
                donation.setUId(rs.getString("u_id"));
                donation.setDTitle(rs.getString("d_title"));
                donation.setDContent(rs.getString("d_content"));
                donation.setDDate(rs.getDate("d_date"));
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