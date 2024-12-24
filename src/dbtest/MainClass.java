package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://192.168.0.133:3306/exam?serverTimeZone=Asia/Seoul", 
						"dbtest", 
						"dbtest"
				);
//				System.out.println(conn);
				System.out.println("DB 접속");
			} catch (SQLException sqle) {
				System.out.println("DB 연동 실패");
				sqle.printStackTrace();
			}
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
