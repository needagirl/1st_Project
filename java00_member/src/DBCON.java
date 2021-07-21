import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {
	//드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@192.168.0.2:1521:XE";
	String name = "c##scott";
	String pwd = "tiger";
	
	
	public DBCON() {
	//DB연결
		
	}
	
	public void dbConn() {
		try {
			conn = DriverManager.getConnection(url,name,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
