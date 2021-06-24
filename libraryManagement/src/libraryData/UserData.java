package libraryData;

import java.util.TreeMap;

public class UserData {
	public static TreeMap<String, UserVO> userData = new TreeMap<String, UserVO>();
	public UserData() {
	}

	public static void basicUser() {
		userData.put("admin@gmail.com", new UserVO("1","admin@gmail.com", "1234", "관리자", "01023433213","19990909"));
	}
}
