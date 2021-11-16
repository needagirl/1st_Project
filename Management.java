import java.util.Scanner;

import libraryData.CheckOutData;
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
			int count =0;
			do {
				String pwd = inData("\t\t\t                비밀번호 ");
				boolean pwdResult =log.pwdCheck(userId,pwd);
				if(pwdResult) {
					System.out.println("\n\t\t\t       로그인 되었습니다. 도서관에 오신걸 환영합니다.");
					break;
				}else {
					count++;
				}
				if(count==3) {
					System.out.println("비밀번호가 3회 틀렸습니다.");
					userId = log.loginMenu();
					break;
				}
			}while(true);
		}else {
			userId = log.loginMenu();
		}
	}
	
	public void startLibrary() {
		do {
			MainPage.headPage(userId);
			MainPage.menuPage();
			System.out.print("메뉴를 선택하세요 >> ");
			String menu = scan.nextLine();
			if (menu.equals("1")) {
				do {
					String select = inData("메뉴화면(menu) 통합자료검색(1) 추천도서(2) ");
					if(select.equals("1")) {
						MainPage.headPage(userId);
						String search = inData("\n\n    \t\t\t\t통합검색 ");
						Search.head();
						Search.findBook(search);
					}else if(select.equals("2")) {
						MainPage.headPage(userId);
						Search.recomend();
					}else if(select.equals("0")) {
						return;
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
					UserVO vo = UserData.userData.get(userId);
					String userNum = vo.getUserNum();
					if(select.equals("1")) {
						MainPage.headPage(userId);
						CheckOut.checkOutBook(userNum);
					}else if(select.equals("2")) {
						MainPage.headPage(userId);
						CheckOut.returnBook(userNum);
					}else if(select.equals("0")) {
						return;
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
						return;
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
					String select = inData("메뉴화면(menu) 본인정보확인(1) ");
					if(select.equals("1")) {
						findMyInfo();
					}else if(select.equals("0")) {
						return;
					}else if(select.equalsIgnoreCase("exit")) {
						System.exit(0);
					}else if(select.equalsIgnoreCase("menu")) {
						break;
					}else {
						System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
					}
				}while(true);
			}else if (menu.equals("0")) {
				return;
			}else if (menu.equalsIgnoreCase("exit")) {
				System.exit(0);
			}else if (menu.equals("99")) {
				if(userId.equals("admin@gmail.com")) {
					CheckOutData.BasicCheckOut();
					do {
						Manager ma = new Manager();
						ma.managerMenu();
						System.out.print("\t\t메뉴선택 >> ");
						String select = scan.nextLine();
						if(select.equals("1")) {
							ma.manageBook();
						}else if(select.equals("2")) {
							ma.manegeCheckout();
						}else if(select.equals("3")) {
							ma.manegeUser();
						}else if(select.equals("0")) {
							return;
						}else if(select.equalsIgnoreCase("exit")) {
							System.exit(0);
						}else {
							System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
						}
					}while(true);
				}else {
					System.out.println("적합한 사용자가 아닙니다.");
					break;
				}
			}else {
				System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
			}
		}while(true);
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

	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
}