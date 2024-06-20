package com.donguri.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBManager {
    private static BasicDataSource dataSource;
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(Common.dbUrl);
        dataSource.setUsername(Common.dbName);
        dataSource.setPassword(Common.dbPw);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(20);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    // Connect to the database
    public static Connection connect() throws SQLException {
        return dataSource.getConnection();
    }

    // Close database connections
    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}