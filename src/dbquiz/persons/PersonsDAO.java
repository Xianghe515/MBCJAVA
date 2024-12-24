package dbquiz.persons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonsDAO {
	private String url = "jdbc:mysql://192.168.0.133:3306/testdb?serverTimeZone=Asia/Seoul";
	private String user = "testuser2";
	private String password = "P@ssw0rd";
	
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
}
