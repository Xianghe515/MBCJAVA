package dbtest.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.persons.PersonsVO;

public class MembersDAO {
	// DB 연결 정보
	private String url = "jdbc:mysql://192.168.0.133:3306/exam?serverTimeZone=Asia/Seoul";
	private String user = "dbtest";
	private String password = "dbtest";
	
	// 데이터 접속 객체 생성
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤
	private static MembersDAO instance = new MembersDAO();
	
	// 생성자
	private MembersDAO() {
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
	
	// 메소드
	public static MembersDAO getInstance() {
		return instance;
	}
	
	// insert
	public int insert(MembersVO vo) {
		int result = 0;
		
		try {
			String sql = "INSERT INTO Members (userId, userPw, name, age, phone)"
					+"VALUES(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("Error");
			System.out.println(sqle.getMessage());
		}
		return result;
	}
	
	// select
		// 전체 출력
	public List<MembersVO> selectAll() {
		List<MembersVO> list = new ArrayList<MembersVO>();
		try {
			String sql = "SELECT * FROM Members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			private int id;
//			private String userId;
//			private String userPw;
//			private String name;
//			private int age;
//			private String phone;
//			private String createDate;
			while (rs.next()) {
				MembersVO vo = new MembersVO(
					rs.getInt("id"),
					rs.getString("userId"),
					rs.getString("userPw"),
					rs.getString("name"),
					rs.getInt("age"),
					rs.getString("phone"),
					rs.getString("createDate")
				);
				list.add(vo);
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return list;
	}
		// userId로 검색
	public MembersVO selectOne(int id) {
		MembersVO vo = null;
		try {
			String sql = "SELECT * FROM Members WHERE id="+id;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MembersVO(
					rs.getInt("id"),
					rs.getString("userId"),
					rs.getString("userPw"),
					rs.getString("name"),
					rs.getInt("age"),
					rs.getString("phone"),
					rs.getString("createDate")
				);
			}else {
				System.out.println("존재하지 않는 ID");
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return vo;
	}
		// name으로 검색
	public MembersVO selectOneName(String name) {
		MembersVO vo = null;
		String result = "존재하지 않는 이름";
		try {
			String sql = "SELECT * FROM Members WHERE name LIKE "+"'"+name+"'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MembersVO(
					rs.getInt("id"),
					rs.getString("userId"),
					rs.getString("userPw"),
					rs.getString("name"),
					rs.getInt("age"),
					rs.getString("phone"),
					rs.getString("createDate")
				);
			}else System.out.println("존재하지 않는 이름");
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
			return vo;
	}
	
	// update
	public int update(MembersVO vo, int id) {
		int result=0;
		try {
			String sql = "UPDATE Members SET userId=?, userPw=?, name=?, age=?, phone=? WHERE id="+id;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getPhone());

			result = pstmt.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return result;
	}

	// delete
	public int delete(int id) {
		int result = 0;
		try {
			String sql = "DELETE FROM Members WHERE id="+id;
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return result;
	}
	
	
	
	
}
