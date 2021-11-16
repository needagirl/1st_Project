import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

public class SignIn {
	Scanner scan = new Scanner(System.in);

	public SignIn() {
	}

	public void userInsert() {
		// 회원번호, 아이디, 비밀번호, 이름, 휴대폰 번호, 생년월일
		System.out.println("================회원가입=================");
		UserData.basicUser();
		UserVO vo = new UserVO();

		// 회원번호
		String userNum = Integer.toString(UserData.userData.size() + 1);
		vo.setUserNum(userNum);

		// 아이디
		aa: do {
			String userId = inData("아이디(이메일)");
			if(!emailCheck(userId)) continue;
			Collection<UserVO> list = UserData.userData.values();
			Iterator<UserVO> ii = list.iterator();
			while (ii.hasNext()) {
				UserVO vo2 = ii.next();
				if (userId.equals(vo2.getUserId())) {
					System.out.println(vo2.getUserId() + "는 이미 가입된 아이디 입니다.");
					continue aa;
				}
			}
			vo.setUserId(userId);
			break;
		} while (true);
		
		//비밀번호
		do {
			System.out.println("비밀번호는 8자 이상 입력하세요. 대소문자, 숫자, 기호를 조합하세요.");
			String pwd = inData("비밀번호");
			if (!pwdCheck(pwd)) continue;
			String repwd = inData("비밀번호 확인");
			if (pwd.equals(repwd)) {
				vo.setUserPwd(pwd);
				break;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		} while (true);

		//휴대폰 번호
		do {
			String tel = inData("휴대폰 번호('-'구분없이 입력)");
			if (trimCheck(tel))	continue;
			if (numCheck(tel) && tel.length() == 11) {
				vo.setTel(tel);
				break;
			} else {
				System.out.println("휴대폰 번호 형식이 잘못되었습니다.");
			}
		} while (true);

		//이름
		do {
			String name = inData("이름(실명)");
			if (trimCheck(name)) continue;
			vo.setName(name);
			break;
		} while (true);
		
		//생년월일
		do {
			String birth = inData("생년월일 8자리 입력");
			if (trimCheck(birth)) continue;
			if (!birthCheck(birth)) continue;
			if (numCheck(birth) ) {
				vo.setBirth(birth);
				break;
			} else {
				System.out.println("생년월일 형식이 옳지 않습니다.");
			}
		} while (true);

		UserData.userData.put(vo.getUserId(), vo);
		System.out.println("----------회원가입이 완료되었습니다.----------");
	}
	
	public boolean pwdCheck(String pwd) {
		String regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
		if(pwd.matches(regexp)) {
			return true;
		} else {
			System.out.println("비밀번호 형식이 옳지 않습니다.");
			return false;
		}
	}
	
	
	public boolean birthCheck(String birth) {
		if (birth.length()==8) {
			String month = birth.substring(4, 6);
			String day = birth.substring(6);
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			if(monthInt<1||monthInt>12||dayInt<1||dayInt>31) {
				System.out.println("생년월일 형식이 옳지 않습니다.");
				return false;
			}else {
				return true;
			}
		}else {
			System.out.println("생년월일 형식이 옳지 않습니다.");
			return false;
		}
	}

	public boolean emailCheck(String userId) {
		int atMark = userId.indexOf("@");
		int point = userId.indexOf(".");
		if (atMark == -1 || point == -1 || atMark > point || point - atMark <= 2) {
			System.out.println("이메일 형식이 옳지 않습니다.");
			return false;
		} else {
			return true;
		}
	}

	public boolean numCheck(String num) {
		return num.matches("[+-]?\\d*(\\.\\d+)?");
	}

	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}

	public boolean trimCheck(String data) {
		data = data.trim();
		if (data.equals("")) {
			System.out.println("형식이 옳지 않습니다.");
			return true;
		} else {
			return false;
		}
	}
}