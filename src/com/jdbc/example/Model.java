package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Model {
	
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String uid = "hr";
		private String upw = "hr";
	
		public void selectOne() {
			
		}
		
		public void insertOne() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO DEPTS VALUES(?,?,?)";
			
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, 300);
				pstmt.setString(2, "704호");
				pstmt.setString(3, "100");
				
				int result = pstmt.executeUpdate();
				
				if(result == 1) {
					System.out.println("INSERT 성공");
				}else {
					System.out.println("INSERT 실패");
				}
				
			} catch ( Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
					conn.close();
					pstmt.close();
				}catch (Exception e){
					
				}
			}
		}
}
