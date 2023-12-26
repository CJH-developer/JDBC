package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEx {

	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String uid = "hr";
	static String upw = "hr";
	public static void selectOne() throws ClassNotFoundException {
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID >= ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1. JDBC 드라이버 준비
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		// 2. conn 객체 생성
			conn = DriverManager.getConnection(url, uid, upw); 
			
			
		// 3. conn 으로부터 statement 객체 생성 = sql 상태 지정하기 위한 객체
			pstmt = conn.prepareStatement(sql);
		
		// 4. ?에 대한 값을 채운다.
			pstmt.setString(1, "120");
			
		// 5. 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int emp_id = rs.getInt("EMPLOYEE_ID");
				String first_name = rs.getString("FIRST_NAME");
				String phone_number = rs.getString("phone_number");
				String hire_date = rs.getString("hire_date");
				int salary = rs.getInt("salary");
				
				System.out.println(emp_id);
				System.out.println(first_name);
				System.out.println(phone_number);
				System.out.println(hire_date);
				System.out.println(salary);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				conn.close();
				pstmt.close();
				rs.close();
			}catch ( Exception e) {
				
			}
			
		}
		
	}
	
	public static void insertOne(int id, String name, String mId) throws ClassNotFoundException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DEPTS VALUES(?,?,?)";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mId);
			
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
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}

	public static void updateOne(int id, String name, String mId) {
		// MAIN에서 부서아이디, 부서명, 매니저 아이디를 받아서, 해당 부서의 매니저 아이디 수정
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE DEPTS SET DEPT_NO = ?, DEPT_NAME = ?, DEPT_DATE = ? WHERE DEPT_NO = 6";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mId);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("UPDATE 실패");
			}else {
				System.out.println("UPDATE 성공");
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	public static void deleteOne(int id) {
		// Main에서 employee_id를 받아서 emps테이블에서 해당 아이디 삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM EMPS WHERE EMPLOYEE_ID = ?";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("DELETE 성공");
			}else {
				System.out.println("DELETE 실패");
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
}

