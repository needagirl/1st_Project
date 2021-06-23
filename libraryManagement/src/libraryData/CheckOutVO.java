package libraryData;

public class CheckOutVO {
	//회원번호, 도서명, 대출일, 반납예정일, 반납상태
	String userNum;
	String bookName;
	String chOutDate;
	String bookreturn;
	String bookcondi;
	
	public CheckOutVO() {
	}
	public CheckOutVO(String userNum, String bookName, String chOutDate, String bookreturn,	String bookcondi) {
		this.userNum = userNum;
		this.bookName = bookName;
		this.chOutDate = chOutDate;
		this.bookreturn = bookreturn;
		this.bookcondi = bookcondi;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getChOutDate() {
		return chOutDate;
	}
	public void setChOutDate(String chOutDate) {
		this.chOutDate = chOutDate;
	}
	public String getBookreturn() {
		return bookreturn;
	}
	public void setBookreturn(String bookreturn) {
		this.bookreturn = bookreturn;
	}
	public String getBookcondi() {
		return bookcondi;
	}
	public void setBookcondi(String bookcondi) {
		this.bookcondi = bookcondi;
	}

}
