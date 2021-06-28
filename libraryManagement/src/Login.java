import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

public class Login {
	Scanner scan = new Scanner(System.in);
	public Login() {
	}
	public String loginMenu(){
		menu:
		do {
			System.out.println("    =======================================================================================    ");
			System.out.println("\t\t  로그인(1)  \t회원가입(2)\t아이디찾기(3)\t비밀번호찾기(4) ");
			System.out.println("    =======================================================================================    ");
			String select = inData("\t메뉴를 선택하세요 ");
			if (select.equals("1")) {
				String userId = inData("아이디(이메일)");
				boolean logResult = loginCheck(userId);
				if(logResult) {
					int count =0;
					do {
						String pwd = inData("비밀번호를 입력하세요");
						boolean pwdResult =pwdCheck(userId,pwd);
						if(pwdResult) {
							System.out.println("로그인 되었습니다.");
							return userId;
						}else {
							count++;
						}
						if(count==3) {
							System.out.println("비밀번호가 3회 틀렸습니다.");
							continue menu;
						}
					}while(true);
				}
			}else if (select.equals("2")) {
				SignIn signin = new SignIn();
				signin.userInsert();
			}else if (select.equals("3")) {
				findId();
			} else if (select.equals("4")) {
				findPwd();
			}else {
				System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
			}
		}while(true);
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
	
	public void findId() {
		String tel = inData("회원가입시 입력한 전화번호를 입력하세요('-'구분없이)");
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		String id = "";
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			if(tel.equals(vo.getTel())) {
				System.out.println("가입하신 아이디는 "+vo.getUserId()+" 입니다.");
				id = vo.getUserId();
			}
		}
		if(id=="") {
			System.out.println("일치하는 아이디가 없습니다.");
		}
	}
	
	public void findPwd() {
		String userId = inData("회원가입시 입력한 아이디를 입력하세요(이메일)");
		String tel = inData("회원가입시 입력한 전화번호를 입력하세요('-'구분없이 입력)");
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		String pwd = "";
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			if(userId.equals(vo.getUserId())&&tel.equals(vo.getTel())) {
				System.out.println(userId+"의 비밀번호는 "+vo.getUserPwd()+"입니다.");
				pwd = vo.getUserPwd();
			}
		}
		if(pwd=="") {
			System.out.println("일치하는 아이디가 없습니다.");
		}
	}
}