package libraryData;

public class BookVO {
	// 등록번호, 도서명, 저자, 출판사, 출판년도, 청구기호,
	String bookNum;
	String bookName;
	String bookAuthor;
	String publisher;
	String pubYear;
	String bookcall;

	public BookVO() {
	}

	public BookVO(String bookNum, String bookName, String bookAuthor, String publisher, String pubYear,	String bookcall) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.bookcall = bookcall;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
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
