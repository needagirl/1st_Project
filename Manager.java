import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import libraryData.BookData;
import libraryData.CheckOutData;
import libraryData.UserData;
import libraryData.UserVO;

public class Manager {
	Scanner scan = new Scanner(System.in);
	BookData bookDB = new BookData();
	UserData userDB = new UserData();
	CheckOutData checkDB = new CheckOutData();
	CheckOut checkOut = new CheckOut();
	public Manager() {
	}
	
	public void managerMenu() {
		
		System.out.println("\n");
		System.out.println("                                       관리자 모드입니다.");
		System.out.println("\n");
		System.out.println("                  ┏━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━┓     ");
		System.out.println("                                                                       ");
		System.out.println("                     1. 도서관리            2. 대출관리           3. 사용자관리       ");
		System.out.println("                                                                       ");
		System.out.println("                  ┗━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━┛     ");
		System.out.println("\n\n");                                                                                           
	
	}
	public void bookInsert() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           도서추가");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		
	}
	public void bookDelete() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           도서삭제");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	
	public void chPrint() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                         대출도서조회");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		CheckOut.checkOutBook();
	}
	public void chRePrint() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                         반납도서조회");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		CheckOut.returnBook();
	}
	public void chInsert() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           도서대출");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		checkDB.setCheckOut();
	
	}
	public void chReturn() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           도서반납");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		checkDB.returnBook();
	}
	public void userPrint() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           사용자조회");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		Set<String> key = userDB.userData.keySet();
		Iterator<String> ii = key.iterator();
		while(ii.hasNext()) {
			UserVO vo = userDB.userData.get(ii.next());
			vo.userPrint();
		}
	}
	public void userDelete() {
		System.out.println("\n    ---------------------------------------------------------------------------------------    ");
		System.out.println("                                           사용자삭제");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	
	public void manageBook() {
		System.out.println("\t도서관리  \t 조회(1)  \t 추가(2) \t삭제(3)    \t뒤로(0)");
		System.out.print("\t\t메뉴선택 >> ");
		String select = scan.nextLine();
		if(select.equals("1")) {
			System.out.println("\n    ---------------------------------------------------------------------------------------    ");
			System.out.println("                                           도서조회");
			System.out.println("    ---------------------------------------------------------------------------------------    ");
			String search = inData("\n\n    \t\t\t\t통합검색 ");
			Search.findBook(search);
		}else if(select.equals("2")) {
			bookInsert();
			bookDB.insertBook();
		}else if(select.equals("3")) {
			bookDelete();
			bookDB.deleteBook();
		}else if(select.equals("0")) {
			return;
		}else if(select.equalsIgnoreCase("exit")) {
			System.exit(0);
		}else {
			System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
		}
	}
	
	public void manegeCheckout() {
		System.out.println("\t 대출관리  \t대출도서조회(1)\t반납도서조회(2)   \t 대출(3)  \t반납(4)  \t뒤로(0)");
		System.out.print("\t\t메뉴선택 >> ");
		String select = scan.nextLine();
		if(select.equals("1")) {
			chPrint();
		}else if(select.equals("2")) {
			chRePrint();
		}else if(select.equals("3")) {
			chInsert();
		}else if(select.equals("4")) {
			chReturn();
		}else if(select.equals("0")) {
			return;
		}else if(select.equalsIgnoreCase("exit")) {
			System.exit(0);
		}else {
			System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
		}
	}
	
	public void manegeUser() {
		System.out.println("\t 사용자관리   \t조회(1)  \t삭제(2)  \t뒤로(0)");
		System.out.print("\t\t메뉴선택 >> ");
		String select = scan.nextLine();
		if(select.equals("1")) {
			userPrint();
			
		}else if(select.equals("2")) {
			userDelete();
			userDB.deleteUser();
		}else if(select.equals("0")) {
			return;
		}else if(select.equalsIgnoreCase("exit")) {
			System.exit(0);
		}else {
			System.out.println("입력이 옳지 않습니다. 다시 한 번 확인해주세요.");
		}
	}
	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
	
}


