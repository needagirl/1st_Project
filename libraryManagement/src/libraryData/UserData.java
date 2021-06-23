package libraryData;

import java.util.TreeMap;

public class UserData {
	public static TreeMap<String, UserVO> userData = new TreeMap<String, UserVO>();
	public UserData() {
	}

	public static void basicUser() {
		userData.put("admin", new UserVO("1","admin", "1234", "010-2343-3213","helloworld@gmail.com", "서울시 마포구 아현동"));
	}
}
