package libraryData;

public class UserVO {
	// 회원번호, 아이디, 패스워드, 휴대폰 번호, 이메일, 주소,
	private String userNum;
	private String userId;
	private String userPwd;
	private String tel;
	private String email;
	private String address;

	public UserVO() {
	}

	public UserVO(String userNum, String userId, String userPwd, String tel, String email, String address) {
		this.userNum = userNum;
		this.userId = userId;
		this.userPwd = userPwd;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}
	public void userPrint(){
		System.out.printf("%-5s %10s %20s %10s %10s\n", userNum, userId, userPwd, tel, email);
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
