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
		
		dataSource.setUrl("jdbc:oracle:thin:@LLWCNQBTJ1CUQ6X6_high?TNS_ADMIN=/Users/master/Downloads/Wallet_LLWCNQBTJ1CUQ6X6");//클라우드 지갑
		dataSource.setUsername("DONGURI");//DB 유저명
		dataSource.setPassword("Dongguri802!!");//DB 패스워드
		dataSource.setMinIdle(10);
		dataSource.setMaxIdle(40);
		dataSource.setMaxOpenPreparedStatements(100);
	}
	
	//연결
	public static Connection connect() throws SQLException {
		return dataSource.getConnection();
	}
	
	//해제
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
