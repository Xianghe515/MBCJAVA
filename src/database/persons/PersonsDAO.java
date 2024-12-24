package database.persons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonsDAO {
	// DB 연동 동작에 대해 DAO를 생성하여 작업 진행
	// DAO 데이터베이스와 접속하여 동작하는 기능을 구현한 클래스
	
	// DB 연결을 위한 정보
	private String url = "jdbc:mysql://192.168.0.133:3306/testdb?serverTimeZone=Asia/Seoul";
	private String user = "testuser2";
	private String password = "P@ssw0rd";
	
	// 데이터 접속을 위한 객체
	Connection conn = null;		// DB 연결 객체(연결 정보)
	Statement stmt = null;		// SQL 처리를 위한 객체
	// PreparedStatement 선언
	PreparedStatement pstmt = null;
	ResultSet rs = null;		// DB로부터 받은 레코드* 정보를 처리		*로우라고도 불림
	
	// 싱글톤 : 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴
	// 싱글톤1 - 자기 자신을 생성하는 객체 멤버 생성
	private static PersonsDAO instance = new PersonsDAO();
	
	// 생성자
	// 싱글톤2 - 외부에서 접근해서 생성하지 못하도록 ➜ private
	private PersonsDAO() {
		try {	
			// 1. Driver Loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 로드 실패");
			System.out.println(ce.getMessage());;
		} catch (SQLException sqle) {
			System.out.println("DB 연동 실패");
			System.out.println(sqle.getMessage());;
		}
	}
	
	//　메소드 영역
	// 싱글톤3 - instance에 대한 getter 생성(생성이 안 되어도 불러올 수 있어야함 - static 필요)
	public static PersonsDAO getInstance() {
		return instance;
	}
	
	// 데이터 입력 메소드 구현
	public int insert(PersonsVO vo) {
		int result = 0;
		
		// 구현
		try {
//			// 3. Statement 객체 생성
//			stmt = conn.createStatement();
//			// 4. SQL 작성
//				// 기본적인 방법
//			String sql = "INSERT INTO persons (firstname, lastname, age, city)"
//					+ "VALUES('"+vo.getFirstName()+"','"+vo.getLastName()+"',"
//					+ ","+vo.getAge()+", '"+vo.getCity()+"')";
//				// String.format()을 이용한 방법
//			String sql2 = String.format("INSERT INTO persons (firstname, lastname, age, city)"
//					+ "VALUES('%s', '%s', %d, '%s')",
//					vo.getFirstName(), vo.getLastName(), vo.getAge(), vo.getCity());
//			// 5. SQL 실행
//			result = stmt.executeUpdate(sql2);
			
			// PreparedStatement 사용
				// 1) SQL문 작성
			String sql = "INSERT INTO persons (lastname, firstname, age, city)"
					+ "VALUES (?,?,?,?)";
				// 2) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
				// 3) pstmt에 '?'에 들어갈 값을 지정(순서대로) - 첫 번째 '?'부터 1번
			pstmt.setString(1, vo.getLastName());		// 1번 '?' - lastname	
			pstmt.setString(2, vo.getFirstName());		// 2번 '?' - firstname
			pstmt.setInt(3, vo.getAge());				// 3번 '?' - age
			pstmt.setString(4, vo.getCity());			// 4번 '?' - city
				// 4) pstmt 실행
			result = pstmt.executeUpdate();
			

		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return result;
	}
	
	// 데이터 조회
	// 1) 전체 조회
	public List<PersonsVO> selectAll() {
		List<PersonsVO> list = new ArrayList<>();
		
		try {
//			// 3. stmt 객체 생성
//			stmt = conn.createStatement();
//			// 4. SQL 작성
//			String sql = "select * from persons";
//			// 5. SQL 실행 ➜ executeQuery()
//			rs = stmt.executeQuery(sql);
//			
			String sql = "select * from persons";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			while (rs.next()) {		// next() - 값이 있으면 true, 없으면 false
//				PersonsVO vo = new PersonsVO();
//				vo.setId(rs.getInt("id"));
//				vo.setLastName(rs.getString("lastname"));
//				vo.setFirstName(rs.getString("firstname"));
//				vo.setAge(rs.getInt("age"));
//				vo.setCity(rs.getString("city"));
				PersonsVO vo = new PersonsVO(
						rs.getInt("id"), 
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getInt("age"), 
						rs.getString("city")
				);
				
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 2) 부분 조회(firstname)
	public List<PersonsVO> selectOneName(String firstname) {
		List<PersonsVO> list = new ArrayList<>();
		try {
//			// 3. stmt 객체 생성
//			stmt = conn.createStatement();
//			// 4. SQL 작성
//			String sql = "select * from persons " 
//					+ "where firstname like '%"+firstname+"%'";
//			// 5. SQL 실행 ➜ executeQuery()
//			rs = stmt.executeQuery(sql);
			
			// PreparedStatement로 변경
			String sql = "select * from persons where firstname like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+firstname+"%");
			rs = pstmt.executeQuery();
			
			
			
			// ResultSet 처리
			while (rs.next()) {		// next() - 값이 있으면 true, 없으면 false
				PersonsVO vo = new PersonsVO(
						rs.getInt("id"), 
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getInt("age"), 
						rs.getString("city")
				);
				
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	// 2. 부분 조회(id)
	public PersonsVO selectOne(int id) {
		PersonsVO vo = null;
		try {
			// 3. stmt 객체 생성
			stmt = conn.createStatement();
			
			// 4. SQL 작성
			String sql = "select * from persons where id =" +id;
			
			// 5. SQL 실행 ➜ executeQuery()
			rs = stmt.executeQuery(sql);
			
			// ResultSet 처리
			if (rs.next()) {		// next() - 값이 있으면 true, 없으면 false
				vo = new PersonsVO(
						rs.getInt("id"), 
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getInt("age"), 
						rs.getString("city")
				);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	
	public int update(PersonsVO vo) {
		int result=0;
		try {
			// 3. statement 객체 생성
			stmt = conn.createStatement();

			// 4. SQL 작성
			String sql = String.format("UPDATE persons SET lastname='%s', firstname='%s', age=%d, city='%s' WHERE id=%d", 
					vo.getFirstName(), vo.getLastName(), vo.getAge(), vo.getCity(), vo.getId());
			
			// 5. SQL 실행
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int delete(int id) {
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM persons WHERE id="+id;
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
