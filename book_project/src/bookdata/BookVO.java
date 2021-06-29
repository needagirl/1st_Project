package bookdata;

public class BookVO {
	private String isbn; // key
	private String bookTitle; // ���� value
	private String writer;
	private String company;
	private String group;
	private int price;
	private int stock;
	
	public BookVO() {
		
	}
	
//	public BookVO(String isbn) {
//		this.isbn = isbn;
//	}
	
	public BookVO(String bookTitle, String writer, String company, String group, int price, int stock) {
		this.bookTitle = bookTitle;
		this.writer = writer;
		this.company = company;
		this.group = group;
		this.price = price;
		this.stock = stock;
		
	}
	
	// ��� Ÿ��Ʋ ���
//	public static void printTitle() {
//		System.out.println("---------------------------------------------------------------------");
//		System.out.print("\t������\t\t");
//		System.out.printf("%6s %12s %5s %6s %5s \n", "������", "���ǻ�", "�з�", "����", "���");
//		System.out.println("---------------------------------------------------------------------");
//	}
	
	// ��� Ÿ��Ʋ ���
	public static void printTitle() {
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.printf("  %-16s %-20s %-11s %-9s %-5s %-5s %-5s \n", "ISBN", "������", "������", "���ǻ�", "�з�", "����", "���");
		System.out.println("---------------------------------------------------------------------------------------------------");
	}
	
	
	// ��� - å 1�Ǵ� ���
	public void printList() {
		System.out.printf(" %10s \t ", isbn);
		// å ���� ���
		String bookTitlePT, writerPT, companyPT;
		if(bookTitle.length() >10) bookTitlePT = bookTitle.substring(0, 10).concat("...");
		else bookTitlePT = bookTitle;
		
		if(bookTitle.length()<=3) System.out.print(bookTitlePT+"\t\t\t");
		else if(bookTitle.length()>7) System.out.print(bookTitlePT+"\t");
		else System.out.print(bookTitlePT+"\t\t");
		
		// ������ ���
		if(writer.length() >7) writerPT = writer.substring(0, 7).concat("...");
		else writerPT = writer;
		if(writer.length()<=5) System.out.print(writerPT+"\t\t");
		else System.out.print(writerPT+"\t");
		
		// ���ǻ� ���
		if(company.length() >6) companyPT = company.substring(0, 6).concat("...");
		else companyPT = company;
		if(company.replace(" ","").length()<4) System.out.print(companyPT+"\t\t");
		else System.out.print(companyPT+"\t");
		
		System.out.printf("%-5s %-8s %-5s \n", group, price, stock);
		//System.out.printf("%5s %10s %10d %10d %10d \n", writer, company, group, price, stock);
	}
	
	// ISBN ���
//	public void printListAdmin() {
//		System.out.printf(" %10s \t ", isbn);
//		printList();
//	}
	
	// �� ���� ���
	public void printDetail() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("[���� �� ����]\n������: %s\n������: %s\n���ǻ�: %s\n�з�: %s\n����: %d��\n���: %d\nISBN: %s\n", bookTitle, writer, company, group, price, stock, isbn);
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	// �� ���� ��� - ������ (��ȣ �ű�)
	public void editDetail() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("[1.������] %s\n[2.������] %s\n[3.���ǻ�] %s\n[4.�С���] %s\n[5.������] %d��\n[6.�硡��] %d\n[7.ISBN] %s\n\n[8.�������]\n", bookTitle, writer, company, group, price, stock, isbn);
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	
	// getter // setter
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn (String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
