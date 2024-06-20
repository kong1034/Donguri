package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.donguri.main.DBManager;

public class DAOPayment {

    // Retrieve a payment by its ID
    public DTOPayment getPaymentById(int p_no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DTOPayment payment = null;

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM d_payment WHERE p_no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, p_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                payment = new DTOPayment();
                payment.setPNo(rs.getInt("p_no"));
                payment.setDNo(rs.getInt("d_no"));
                payment.setUId(rs.getString("u_id"));
                payment.setPPrice(rs.getInt("p_price"));
                payment.setPDate(rs.getDate("p_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return payment;
    }

    // Retrieve all payments
    public List<DTOPayment> getAllPayments() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DTOPayment> payments = new ArrayList<DTOPayment>();

        try {
            con = DBManager.connect();
            String sql = "SELECT * FROM d_payment";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                DTOPayment payment = new DTOPayment();
                payment.setPNo(rs.getInt("p_no"));
                payment.setDNo(rs.getInt("d_no"));
                payment.setUId(rs.getString("u_id"));
                payment.setPPrice(rs.getInt("p_price"));
                payment.setPDate(rs.getDate("p_date"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return payments;
    }
}