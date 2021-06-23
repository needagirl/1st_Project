import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

public class Management {
	Scanner scan = new Scanner(System.in);

	public Management() {

	}

	public void start() {
		 
		first: do {
			String select = inData("1. 로그인  2. 회원가입");
			boolean logResult = false;
			if (select.equals("2")) {
				SignIn signin = new SignIn();
				signin.userInsert();
				continue first;
			} else if (select.equals("1")) {
				do {
					Login log = new Login();
					logResult = log.loginCheck();
					if (logResult == false) {
						System.out.print("처음화면(0) 다시시도(1) 아이디찾기(2) 비밀번호찾기(3)\n입력>>");
						String menuresult = scan.nextLine();
						if (menuresult.equals("0")) {
							continue first;
						} else if (menuresult.equals("1")) {
							
						} else if (menuresult.equals("2")) {
							findId();
							continue first;
						} else if (menuresult.equals("3")) {
							findPwd();
							continue first;
						}else {
							
						}
					}
				} while (!logResult);
				System.out.println("로그인 되었습니다.");
				break first;
			}else {
				System.out.println("잘못입력하셨습니다.");
				continue first;
			}
//			allUserList();
		} while (true);
		menu();
	}

	public void findId() {
		String email = inData("회원가입시 입력한 이메일을 입력하세요");
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		String id = "";
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			if(email.equals(vo.getEmail())) {
				System.out.println("가입하신 아이디는 "+vo.getUserId()+" 입니다.");
				id = vo.getUserId();
			}
		}
		if(id=="") {
			System.out.println("일치하는 아이디가 없습니다.");
		}
	}
	public void findPwd() {
		String userId = inData("회원가입시 입력한 아이디를 입력하세요");
		String email = inData("회원가입시 입력한 이메일을 입력하세요");
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		String pwd = "";
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			if(userId.equals(vo.getUserId())&&email.equals(vo.getEmail())) {
				System.out.println(userId+"의 비밀번호는 "+vo.getUserPwd()+"입니다.");
				pwd = vo.getUserPwd();
			}
		}
		if(pwd=="") {
			System.out.println("일치하는 아이디가 없습니다.");
		}
	}
	public void menu() {
		inData("1.자료검색 2.대출 3.이용안내 4.마이페이지");
	}
	public void allUserList() {
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			vo.userPrint();
		}
	}

	public String inData(String msg) {
		System.out.print(msg + "->");
		return scan.nextLine();
	}
}
