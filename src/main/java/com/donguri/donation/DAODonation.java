package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.donguri.main.DBManager;
import java.math.BigDecimal;

public class DAODonation {

    // Save donation details in the database
    public boolean saveDonation(String orderId, BigDecimal amount, String currency) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO donations (order_id, amount, currency) VALUES (?, ?, ?)";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, orderId);
            pstmt.setBigDecimal(2, amount);
            pstmt.setString(3, currency);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }

    // Get donation details from the database
    public DTODonation getDonation(String orderId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM donations WHERE order_id = ?";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, orderId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                BigDecimal amount = rs.getBigDecimal("amount");
                String currency = rs.getString("currency");
                return new DTODonation(orderId, amount, currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return null;
    }
}