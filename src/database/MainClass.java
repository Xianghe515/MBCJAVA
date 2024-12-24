package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

	public static void main(String[] args) {
		// JDBC 연결
		// Connection 객체 선언
		Connection conn = null;
		
		try {
			// 1. Driver Loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DriverManger 통해서 Connection 객체 생성
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://192.168.0.133:3306/testdb?serverTimeZone=Asia/Seoul",
						"testuser2", 
						"P@ssw0rd"
				);
				System.out.println(conn);
				System.out.println("데이터 베이스 접속");
			}catch (SQLException sqle) {
				System.out.println("DB 연동 실패");				
				sqle.printStackTrace();
			}
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		
		}finally {
			try {
				if(conn != null) conn.close();
			}catch(Exception e) {
				
			}
		}
	}
}
