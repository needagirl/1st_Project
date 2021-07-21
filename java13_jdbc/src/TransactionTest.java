import java.sql.SQLException;

public class TransactionTest extends DBConnection{

	public TransactionTest() {
		
		// a_bank : 5000 출금, b_bank : 5000 입금
		try {
			dbConn();
			//자동 commit 해제하기
			conn.setAutoCommit(false);//true : 자동커밋, false :자동커밋해제
			
			int abank = -5000, bbank = 5000;
			
			//출금
			sql = "insert into a_bank(num, money) values(a_number.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, abank);
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(Math.abs(abank)+"원이 출금되었습니다.");
			}else {
				System.out.println(Math.abs(abank)+"원 출금이 실패하였습니다.");
			}
//			if(result>0)throw new Exception();
			//입금
			sql = "insert into b_bank(num, money) values(b_number.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbank);
			int result2 = pstmt.executeUpdate();
			if(result2>0) {
				System.out.println(Math.abs(bbank)+"원이 입금되었습니다.");
			}else {
				System.out.println(Math.abs(bbank)+"원 입금이 실패하였습니다.");
			}
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new TransactionTest();
	}

}
