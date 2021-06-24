import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

public class Login {
	Scanner scan = new Scanner(System.in);
	public Login() {
	}
	
	public boolean loginCheck (String userId) {
		UserData.basicUser();
		boolean result = true;
		UserVO vo = UserData.userData.get(userId);
		try {
			String hasUserId = vo.getUserId();
		} catch (NullPointerException npe) {
			result = false;
			System.out.println("일치하는 아이디가 없습니다.");
		}
		return result;
	}
	public boolean pwdCheck(String userId, String userPwd) {
		UserData.basicUser();
		boolean result = true;
		UserVO vo = UserData.userData.get(userId);
		try {
			String hasUserPwd = vo.getUserPwd();
			if (userPwd.equals(hasUserPwd)) {
			}else {
				result = false;
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} catch (NullPointerException npe) {
			result = false;
			System.out.println("비밀번호가 틀렸습니다.");
		}
		return result;
	}
	public String inData(String msg) {
		System.out.print(msg + ">>");
		return scan.nextLine();
	}
}
