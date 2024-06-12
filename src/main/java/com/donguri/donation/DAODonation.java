package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.donguri.main.DBManager;

public class DAODonation {

    public boolean saveDonation(int donationNo, String userId, String donationTitle, String donationContent, Date donationDate) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO donation_list (d_no, u_id, d_title, d_content, d_date) VALUES (?, ?, ?, ?, ?)";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, donationNo);
            pstmt.setString(2, userId);
            pstmt.setString(3, donationTitle);
            pstmt.setString(4, donationContent);
            pstmt.setDate(5, new java.sql.Date(donationDate.getTime()));
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }

    public List<DTODonation> getAllDonations() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM donation_list";
        List<DTODonation> donations = new ArrayList<>();

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int donationNo = rs.getInt("d_no");
                String userId = rs.getString("u_id");
                String donationTitle = rs.getString("d_title");
                String donationContent = rs.getString("d_content");
                Date donationDate = rs.getDate("d_date");
                donations.add(new DTODonation(donationNo, userId, donationTitle, donationContent, donationDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return donations;
    }
}