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
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##cnh00");
		dataSource.setPassword("cnh00");
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