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
		// 1명의 유저 정보를 저장할 VO객체를 만든다.
		UserData.basicUser();
		UserVO vo = new UserVO();
		String userNum = Integer.toString(UserData.userData.size()+1);
		vo.setUserNum(userNum);
		aa:
		do {
			String userId = inData("아이디");
			if(trimCheck(userId)) continue;
			Collection<UserVO> list = UserData.userData.values();
			Iterator<UserVO> ii = list.iterator();
			while (ii.hasNext()) {
				UserVO vo2 = ii.next();
				if(userId.equals(vo2.getUserId())) {
					System.out.println(vo2.getUserId()+"는 이미 가입된 아이디 입니다.");
					continue aa;
				}
			}
			vo.setUserId(userId);
			break;
		}while(true);
		
		do {
			String pwd = inData("비밀번호");
			String repwd = inData("비밀번호 재입력");
			if(trimCheck(pwd)) continue;
			if (pwd.equals(repwd)) {
				vo.setUserPwd(pwd);
				break;
			}else{
				System.out.println("비밀번호가 맞지 않습니다.");
			}
		}while(true);
		
		do {
			String tel = inData("연락처(예시:01012345678)숫자만입력");
			if(trimCheck(tel)) continue;
			if(telCheck(tel)&&tel.length()==11) {
				vo.setTel(tel);
				break;
			}else {
				System.out.println("연락처 형식이 잘못되었습니다.");
			}
		}while(true);
		
		do {
			String email = inData("이메일");
			if(trimCheck(email)) continue;
			if(emailCheck(email)) {
				vo.setEmail(email);
				break;
			}else {
				System.out.println("이메일 형식이 옳지 않습니다.");
			} 
		} while(true);
		
		do {
			String address = inData("주소");
			if(trimCheck(address)) continue;
			if(addressCheck(address)) {
				vo.setAddress(address);
				break;
			}else {
				System.out.println("주소 형식이 옳지 않습니다.");
			}
		}while(true);

		UserData.userData.put(vo.getUserId(), vo);
	}
	public boolean addressCheck(String address) {
		
		return false;
	}
	public boolean emailCheck(String email) {
		
		int atMark = email.indexOf("@");
		int point = email.indexOf(".");
		if(atMark==-1||point==-1||atMark>point||point-atMark<=2) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean telCheck(String tel) {
		return tel.matches("[+-]?\\d*(\\.\\d+)?");
	}
	
	public String inData(String msg) {
		System.out.print(msg + "->");
		return scan.nextLine();
	}
	
	public boolean trimCheck(String data) {
		data = data.trim();
		if(data.equals("")) {
			System.out.println("잘못된 형식입니다.");
			return true;
		}else {
			return false;
		}
	}
}
