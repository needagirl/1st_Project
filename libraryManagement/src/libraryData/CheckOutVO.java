package libraryData;

import java.util.Collection;
import java.util.Iterator;

public class CheckOutVO {
	//회원번호, 등록번호, 대출일, 반납예정일, 반납일,
	String userNum;
	String bookNum;
	String chOutDate;
	String bookBackDate;
	String returnDate = "0";
	
	public CheckOutVO() {
	}
	public CheckOutVO(String userNum, String bookNum, String chOutDate, String bookBackDate,String returnDate) {
		this.userNum = userNum;
		this.bookNum = bookNum;
		this.chOutDate = chOutDate;
		this.bookBackDate = bookBackDate;
		this.returnDate = returnDate;
	}
	
	public void printBack(String bookNum) {
		String year = chOutDate.substring(0,4);
		String month = chOutDate.substring(4, 6);
		String day = chOutDate.substring(6);
		String yearBack = returnDate.substring(0,4);
		String monthBack = returnDate.substring(4, 6);
		String dayBack = returnDate.substring(6);
		
		System.out.printf("\n     %s : %s\t  %s : %s년 %s월 %s일\t%s : %s년 %s월 %s일\n\t\t\t\t\t%s\n","등록번호",bookNum,"대출일", year, month, day, "반납일", yearBack,monthBack,dayBack,"반납되었습니다.");
		System.out.println("    ---------------------------------------------------------------------------------------    ");	
	}
	public void checkOutPrint(String bookName) {
		String year = chOutDate.substring(0,4);
		String month = chOutDate.substring(4, 6);
		String day = chOutDate.substring(6);
		String yearBack = bookBackDate.substring(0,4);
		String monthBack = bookBackDate.substring(4, 6);
		String dayBack = bookBackDate.substring(6);
		
		System.out.printf("\n     %s : %s\t%s : %s \n\n     %s : %s년 %s월 %s일\t%s : %s년 %s월 %s일\n\n","등록번호",bookNum, "도서명", bookName, "대출일", year, month, day, "반납예정일", yearBack,monthBack,dayBack);
		System.out.println("    ---------------------------------------------------------------------------------------    ");	
	}
	public void returnPrint(String bookName) {
		String year = chOutDate.substring(0,4);
		String month = chOutDate.substring(4, 6);
		String day = chOutDate.substring(6);
		String yearBack = bookBackDate.substring(0,4);
		String monthBack = bookBackDate.substring(4, 6);
		String dayBack = bookBackDate.substring(6);
		String yearReturn = returnDate.substring(0,4);
		String monthReturn = returnDate.substring(4, 6);
		String dayReturn = returnDate.substring(6);
		
		System.out.printf("\n     %s : %s\t%s : %s \n\n     %s : %s년 %s월 %s일\t%s : %s년 %s월 %s일\t %s : %s년%s월%s일\n\n","등록번호",bookNum, "도서명", bookName, "대출일", year, month, day, "반납예정일", yearBack,monthBack,dayBack, "반납일" ,yearReturn, monthReturn, dayReturn);
		System.out.println("    ---------------------------------------------------------------------------------------    ");	
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getChOutDate() {
		return chOutDate;
	}
	public void setChOutDate(String chOutDate) {
		this.chOutDate = chOutDate;
	}
	public String getBookBackDate() {
		return bookBackDate;
	}
	public void setBookBackDate(String bookBackDate) {
		this.bookBackDate = bookBackDate;
	}
	
}
