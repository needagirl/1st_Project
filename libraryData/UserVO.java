package libraryData;

public class UserVO {
	// 회원번호, 아이디, 비밀번호,  이름, 휴대폰 번호, 생년월일
	private String userNum;
	private String userId;
	private String userPwd;
	private String name;
	private String tel;
	private String birth;

	public UserVO() {
	}

	public UserVO(String userNum, String userId, String userPwd, String name, String tel, String birth) {
		this.userNum = userNum;
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	
	public void userPrint(){
		System.out.printf("%5s %10s %20s %10s %10s %10s \n", userNum, userId, userPwd, name, tel, birth);
	}
	public void userInfoPrint() {
		String year = birth.substring(0,4);
		String month = birth.substring(4, 6);
		String day = birth.substring(6);
		String first = tel.substring(0,3);
		String mid = tel.substring(3,7);
		String last = tel.substring(7);
		
		System.out.println("                                       개 인 정 보 확 인                                         ");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		System.out.println("    ┌──────────────┬──────────────────────────────────────────────────────┐");
		System.out.printf("    │ 1. 이  름                      	%s\n",name);
		System.out.println("    ├──────────────┼──────────────────────────────────────────────────────┤");
		System.out.printf("    │ 2. 생년월일                    	%s년 %s월 %s일\n", year,month,day);
		System.out.println("    ├──────────────┼──────────────────────────────────────────────────────┤");
		System.out.printf("    │ 3. 비밀번호                    	%s\n", userPwd);
		System.out.println("    ├──────────────┼──────────────────────────────────────────────────────┤");
		System.out.printf("    │ 4. 휴대폰 번호                  	%s-%s-%s\n", first, mid, last);
		System.out.println("    └──────────────┴──────────────────────────────────────────────────────┘");
		System.out.println();  
	}
	
	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

}