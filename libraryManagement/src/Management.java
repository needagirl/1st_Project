import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import libraryData.UserData;
import libraryData.UserVO;

public class Management {
	Scanner scan = new Scanner(System.in);
	String userId;
	boolean logResult = false;
	Login log = new Login();
	public Management() {

	}

	public void start() {
		MainPage.firstPage();
		this.userId = scan.nextLine();
		logResult = log.loginCheck(userId);
		if(logResult) {
			do {
				String pwd = inData("      \t\t\t\t   비밀번호 ");
				boolean pwdResult =log.pwdCheck(userId,pwd);
				if(pwdResult) {
					System.out.println("\t로그인 되었습니다. 도서관에 오신걸 환영합니다.");
					break;
				}
			}while(true);
		}else {
			menu:
			do {
				String select = inData("로그인(1) 회원가입(2) 아이디찾기(3) 비밀번호찾기(4) \n입력>>");
				if (select.equals("1")) {
					this.userId = inData("아이디(이메일)");
					logResult = log.loginCheck(userId);
					if(logResult) {
						do {
							String pwd = inData("비밀번호를 입력하세요");
							boolean pwdResult =log.pwdCheck(userId,pwd);
							if(pwdResult) {
								System.out.println("로그인 되었습니다.");
								break menu;
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
	}
	
	public void startLibrary() {
		MainPage.headPage(userId);
		MainPage.menuPage();
		System.out.print("메뉴를 선택하세요 >> ");
		String menu = scan.nextLine();
		if (menu.equals("1")) {
			do {
				String select = inData("메뉴화면(menu) 통합자료검색(1) 추천도서(2) 베스트셀러(3) ");
				if(select.equals("1")) {
					MainPage.headPage(userId);
				}else if(select.equals("2")) {
					MainPage.headPage(userId);
				}else if(select.equals("3")) {
					MainPage.headPage(userId);
				}else if(select.equals("0")) {
					
				}else if(select.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else if(select.equalsIgnoreCase("menu")) {
					break;
				}else {
					System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
				}
			}while(true);
		}else if (menu.equals("2")) {
			do {
				String select = inData("메뉴화면(menu) 대출도서조회(1) 나의대출이력(2) ");
				if(select.equals("1")) {
					MainPage.headPage(userId);
					
				}else if(select.equals("2")) {
					MainPage.headPage(userId);
				}else if(select.equals("0")) {
					
				}else if(select.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else if(select.equalsIgnoreCase("menu")) {
					break;
				}else {
					System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
				}
			}while(true);
		}else if (menu.equals("3")) {
			do {
				String select = inData("메뉴화면(menu) 이용시간(1) 휴관일(2) 오시는길(3) ");
				if(select.equals("1")) {
					MainPage.headPage(userId);
					MainPage.infoUse();
				}else if(select.equals("2")) {
					MainPage.headPage(userId);
					MainPage.infoHolyday();
				}else if(select.equals("3")) {
					MainPage.headPage(userId);
					MainPage.infoWay();
				}else if(select.equals("0")) {
					
				}else if(select.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else if(select.equalsIgnoreCase("menu")) {
					break;
				}else {
					System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
				}
			}while(true);
		}else if (menu.equals("4")) {
			do {
				String select = inData("메뉴화면(menu) 본인정보확인(1) 예약내역(2) ");
				if(select.equals("1")) {
					findMyInfo();
				}else if(select.equals("2")) {
					
				}else if(select.equals("0")) {
					
				}else if(select.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else if(select.equalsIgnoreCase("menu")) {
					break;
				}else {
					System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
				}
			}while(true);
		}else if (menu.equals("0")) {
			
		}else if (menu.equalsIgnoreCase("exit")) {
			System.exit(0);
		}else {
			System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
		}
	}
	
	public void findMyInfo() {
		SignIn signin = new SignIn();
		System.out.println("본인정보확인을 하겠습니다. 정보의 수정이 가능합니다.");
		System.out.println("다시 로그인이 필요한 서비스입니다. 계속하시겠습니까?");
		String select = inData("계속(y) 뒤로(back)");
		if(select.equals("y")) {
			this.userId = inData("아이디(이메일)");
			logResult = log.loginCheck(userId);
			if(logResult) {
				do {
					String pwd = inData("비밀번호를 입력하세요");
					boolean pwdResult =log.pwdCheck(userId,pwd);
					if(pwdResult) {
						System.out.println("로그인 되었습니다.");
						break;
					}
				}while(true);
			}
			do {
				UserVO vo = UserData.userData.get(userId);
				MainPage.headPage(userId);
				vo.userInfoPrint();
				String choice = inData("변경할 항목을 고르세요. 뒤로가기(back)");
				
				if(choice.equals("1")) {
					System.out.println("이름을 변경하겠습니다.");
					vo.setName(inData("이름"));
					
				}else if(choice.equals("2")) {
					System.out.println("생년월일을 변경하겠습니다.");
					do {
						String birth = inData("생년월일 8자리 입력");
						if (signin.trimCheck(birth)) continue;
						if (!signin.birthCheck(birth)) continue;
						if (signin.numCheck(birth) ) {
							vo.setBirth(birth);
							break;
						} else {
							System.out.println("생년월일 형식이 옳지 않습니다.");
						}
					} while (true);
					
				}else if(choice.equals("3")) {
					System.out.println("비밀번호를 변경하겠습니다.");
					do {
						System.out.println("비밀번호는 8자 이상 입력하세요. 대소문자, 숫자, 기호를 조합하세요.");
						String pwd = inData("비밀번호");
						if (!signin.pwdCheck(pwd)) continue;
						String repwd = inData("비밀번호 확인");
						if (pwd.equals(repwd)) {
							vo.setUserPwd(pwd);
							break;
						} else {
							System.out.println("비밀번호가 일치하지 않습니다.");
						}
					} while (true);
					
				}else if(choice.equals("4")) {
					System.out.println("휴대폰 번호를 변경하겠습니다.");
					do {
						String tel = inData("휴대폰 번호('-'구분없이 입력)");
						if (signin.trimCheck(tel))	continue;
						if (signin.numCheck(tel) && tel.length() == 11) {
							vo.setTel(tel);
							break;
						} else {
							System.out.println("휴대폰 번호 형식이 잘못되었습니다.");
						}
					} while (true);
					
				}else if(choice.equals("0")) {
				}else if(choice.equalsIgnoreCase("exit")) {
					System.exit(0);
				}else if(choice.equalsIgnoreCase("back")) {
					break;
				}else {
					System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
				}
			}while(true);
		}else if(select.equals("back")) {
		}else{
			System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
		}
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

	public void allUserList() {
		Collection<UserVO> list = UserData.userData.values();
		Iterator<UserVO> ii = list.iterator();
		while (ii.hasNext()) {
			UserVO vo = ii.next();
			vo.userPrint();
		}
	}

	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
}
