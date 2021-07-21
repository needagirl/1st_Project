import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest extends DBConnection{

	public DeleteTest() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 사원명= ");
			String name = scan.nextLine();
			
			dbConn();
			
			sql = "delete from emp where ename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(name+"의 정보가 삭제 되었습니다.");
			}else {
				System.out.println("대상이 없습니다.");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest();
	}

}
