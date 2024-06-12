package com.donguri.donation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAOPayment {

    public List<DTOPayment> getAllPayments() {
        List<DTOPayment> payments = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.connect();
            String sql = "SELECT * FROM d_payment";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTOPayment payment = new DTOPayment();
                payment.setP_no(rs.getInt("p_no"));
                payment.setD_no(rs.getInt("d_no"));
                payment.setU_id(rs.getString("u_id"));
                payment.setP_price(rs.getDouble("p_price"));
                payment.setP_date(rs.getDate("p_date"));
                payments.add(payment);
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
        return payments;
    }
}