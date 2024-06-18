package com.donguri.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBManager {

    private static BasicDataSource dataSource;

    static {
        try {
            // Load the JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:oracle:thin:@//adb.ap-osaka-1.oraclecloud.com:1522/your_actual_db_name_high.adb.oraclecloud.com"); // Replace with actual database name
            dataSource.setUsername("DONGURI");
            dataSource.setPassword("Dongguri802!!");
            dataSource.setMinIdle(10);
            dataSource.setMaxIdle(20);
            dataSource.setMaxOpenPreparedStatements(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource is not initialized.");
        }
        return dataSource.getConnection();
    }

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeDataSource() {
        try {
            if (dataSource != null) {
                dataSource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}