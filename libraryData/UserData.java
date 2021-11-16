package libraryData;

import java.util.Scanner;
import java.util.TreeMap;

public class UserData {
	Scanner scan = new Scanner(System.in);
	public static TreeMap<String, UserVO> userData = new TreeMap<String, UserVO>();
	public UserData() {
	}

	public static void basicUser() {
		userData.put("admin@gmail.com", new UserVO("1","admin@gmail.com", "1234", "관리자", "01023433213","19990909"));
		userData.put("first@gmail.com", new UserVO("2","first@gmail.com", "12345@aA", "김처음", "01023454321","20001111"));
	}
	public void deleteUser() {
		String key = inData("삭제할 사용자의 아이디를 입력하세요");
		userData.remove(key);
	}
	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
}