package com.donguri.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//db관련 작업 시 연결코드를 쓴 이후 작업 해옴.
//다 쓰면 닫음

//그것을 aop 하자 
public class DBManager {
	
	private static BasicDataSource dataSource;
	static {
		dataSource = new BasicDataSource();
<<<<<<< HEAD
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##cnh00");
		dataSource.setPassword("cnh00");
=======
		
		dataSource.setUrl("jdbc:oracle:thin:@LLWCNQBTJ1CUQ6X6_high?TNS_ADMIN=/Users/master/Downloads/Wallet_LLWCNQBTJ1CUQ6X6");//클라우드 지갑
		dataSource.setUsername("DONGURI");//DB 유저명
		dataSource.setPassword("Dongguri802!!");//DB 패스워드
>>>>>>> 021c94beb9c2f614a696280a1772a9c7cfe7c307
		dataSource.setMinIdle(10);
		dataSource.setMaxIdle(20);
		dataSource.setMaxOpenPreparedStatements(100);
	}
	
	// Connect
	public static Connection connect() throws SQLException {
		return dataSource.getConnection();
	}

	// Close
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {

		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}