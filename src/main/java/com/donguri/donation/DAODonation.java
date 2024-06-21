package com.donguri.donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.donguri.main.DBManager;

public class DAODonation {
    public static void daoDonation(HttpServletRequest request, HttpServletResponse response, String dNo, int amount) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM d_donation_list WHERE d_no = ?";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dNo);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                DTODonation donation = new DTODonation();
                donation.setD_no(rs.getInt("d_no"));
                donation.setU_id(rs.getString("u_id"));
                donation.setD_title(rs.getString("d_title"));
                donation.setD_content(rs.getString("d_content"));
                donation.setD_date(rs.getDate("d_date"));
                donation.setP_no(rs.getInt("p_no"));
                donation.setP_price(amount);
                donation.setP_date(rs.getDate("p_date"));

                request.setAttribute("donation", donation);
            } else {
                request.setAttribute("donation", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error accessing database", e);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
    }
}