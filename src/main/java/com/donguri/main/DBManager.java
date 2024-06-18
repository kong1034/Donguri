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
		dataSource.setUrl(Common.db_url);
		dataSource.setUsername(Common.db_name);
		dataSource.setPassword(Common.db_pw);
		dataSource.setMinIdle(10);
		dataSource.setMaxIdle(20);
		dataSource.setMaxOpenPreparedStatements(100);
	}
	
	// Connect
	public static Connection connect() throws SQLException {
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
}