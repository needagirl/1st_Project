package libraryData;

public class BookVO {
	String bookName;
	String bookAuthor;
	String publisher;
	String pubYear;
	String bookcall;
	String borrow;
	String borrowNum;

	public BookVO() {
	}


	public BookVO(String bookName, String bookAuthor, String publisher, String pubYear,	String bookcall, String borrow, String borrowNum) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.bookcall = bookcall;
		this.borrow =borrow;
		this.borrowNum = borrowNum;
	}

	public void bookPrint(String key) {// 대여상태 반납예정일
		System.out.printf("\n     %s : %s\t%s : %s \n\n     %s : %s \t%s : %s\t\t%s\n\n     %s : %s\t%s : %s \n\n","등록번호",key, "도서명", bookName, "저자",bookAuthor, "출판사",publisher, borrow,"출판년도",pubYear,"청구기호", bookcall);
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	public void rebookPrint(String key) {
		System.out.printf("\n     %s : %s\t%s : %s \n\n     %s : %s \t%s : %s\t\t%s\n\n     %s : %s\t%s : %s \n\n","등록번호",key, "도서명", bookName, "저자",bookAuthor, "출판사",publisher, borrow,"출판년도",pubYear,"청구기호", bookcall);
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	public void recomendPrint(String key) {
		System.out.printf("\n     %s : %s\t%s : %s\t   %s : %s \n\n","등록번호",key, "도서명", bookName, "저자",bookAuthor);
		System.out.println("    ---------------------------------------------------------------------------------------    ");
	}
	public String getAll() {
		String all = bookName+bookAuthor+publisher+pubYear+bookcall;
		return all;
	} 
	public String getBorrowNum() {
		return borrowNum;
	}
	
	public void setBorrowNum(String borrowNum) {
		this.borrowNum = borrowNum;
	}
	
	public String getBorrow() {
		return borrow;
	}
	
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubYear() {
		return pubYear;
	}

	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

	public String getBookcall() {
		return bookcall;
	}

	public void setBookcall(String bookcall) {
		this.bookcall = bookcall;
	}
	
}
