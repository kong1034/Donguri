package com.donguri.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DBManager {
<<<<<<< HEAD
=======
	
	private static BasicDataSource dataSource;
	static {
		dataSource = new BasicDataSource();
		dataSource.setUrl("");
		dataSource.setUsername("");
		dataSource.setPassword("");
		dataSource.setMinIdle(10);
		dataSource.setMaxIdle(20);
		dataSource.setMaxOpenPreparedStatements(100);
	}
	
	// Connect
	public static Connection connect() throws SQLException {
		return dataSource.getConnection();
	}
>>>>>>> 9e4bf912f0b605052214d86e33c374a9f7ffa227

    private static BasicDataSource dataSource;

    @PostConstruct
    public void init() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@//adb.ap-osaka-1.oraclecloud.com:1522/your_db_name_high.adb.oraclecloud.com");
        dataSource.setUsername("DONGURI");
        dataSource.setPassword("Dongguri802!!");
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(20);
        dataSource.setMaxOpenPreparedStatements(100);
    }

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

    @PreDestroy
    public void closeDataSource() {
        try {
            if (dataSource != null) {
                dataSource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}