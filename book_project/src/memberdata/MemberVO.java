package memberdata;

public class MemberVO {
	private String grade;
	private String id;
	private String pw;
	private String name;
	private String birthday;
	private String gender;
	private String tel;
//	private String email;
	private String isbn;
	private String bookTitle;
	private int qnty;
	private String bookingCode;
	
	public MemberVO() {
		
	}
	
	
	// ȸ��
	public MemberVO(String pw, String name, String birthday, String gender, String tel, String grade) {
		this.pw = pw;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.tel = tel;
		this.grade = grade;
		//this.email = email;
	}
	
	// ����
	public MemberVO(String bookingCode, String isbn, String bookTitle, int qnty, String id, String name, String tel){
		this.bookingCode = bookingCode;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.qnty = qnty;
		this.id = id;
		this.name = name;
		this.tel = tel;
	}
	
	// ȸ�� ��� Ÿ��Ʋ ���
	public static void printMemberTitle() {
		System.out.println("----------------------------------------------------------");
		System.out.printf("%-11s%-9s %-12s %-6s \n", "���̵�", "ȸ����", "�޴�����ȣ", "����");
		System.out.println("----------------------------------------------------------");
	}
		
	// ȸ�� ��� ���
	public void printMemberList() {
		System.out.printf("%-12s %-8s %-15s %-7s \n", id, name, tel, grade);

	}
	
	// ȸ�� ���� �� ���
	public void printMyInfo() {
		System.out.println("------------------------------------------------------------------");
		System.out.printf("[ȸ������]%s\n[���̵�] %s\n[�̸�] %s\n[�������] %s\n[����] %s\n[�޴��ȣ] %s\n", grade, id, name, birthday, gender, tel);
		System.out.println("------------------------------------------------------------------");
	}
	
	// ���� ��� Ÿ��Ʋ ���
	public static void printBookingTitle() {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.printf("%-7s %-18s %-13s %-7s %-7s %-7s %-18s\n", "�����ȣ", "ISBN", "������", "����", "���̵�", "ȸ����", "�޴�����ȣ");
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	// ���� ��� ��� - ������ ver.
	public void printBookingList() {
		System.out.printf("%-7s %-15s %-15s %-6s %-10s %-6s %-18s\n", bookingCode, isbn, bookTitle, qnty, id, name, tel);
	}
	
	// ���� Ȯ�� ��� Ÿ��Ʋ
	public static void printBookingCheckTitle() {
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-7s %-15s %-15s %-6s\n", "�����ȣ", "ISBN", "������", "����");
		System.out.println("---------------------------------------------------------");
	}
	
	// ���� Ȯ�� ���
	public void printBookingCheck() {
		System.out.printf("[%s]\t %-15s %-15s %-6s\n", bookingCode, isbn, bookTitle, qnty);
	}
	
	
	// getter setter
	public String getGrade() {
		return grade;
	}
	
	
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


//	public String getEmail() {
//		return email;
//	}
//
//
//	public void setEmail(String email) {
//		this.email = email;
//	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQnty() {
		return qnty;
	}

	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
}
