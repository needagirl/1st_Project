import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import libraryData.BookData;
import libraryData.BookVO;
import libraryData.CheckOutData;
import libraryData.CheckOutVO;

public class CheckOut {
	public CheckOut() {
	}
	public static void checkOutBook(String userNum) {
		Scanner scan = new Scanner(System.in);
		CheckOutData.BasicCheckOut();
		Collection<CheckOutVO> cc = CheckOutData.checkout.values();
		Iterator<CheckOutVO> bookValue =  cc.iterator();
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		int count = 1;
		
		while (bookValue.hasNext()) {
			CheckOutVO vo = bookValue.next();
			if(userNum==vo.getUserNum()&&vo.getReturnDate().equals("0")) {
				String bookNum = vo.getBookNum();
				Iterator<String> bookKey =  key.iterator();
				while (bookKey.hasNext()) {
					if(count%4==0) {
						System.out.print("\t다음으로 넘어가려면 아무키나 입력하세요 !!");
						String next = scan.nextLine();
						System.out.println("    =======================================================================================    ");
						count=1;
					}
					String treeKey = bookKey.next();
					BookVO bvo = BookData.bookData.get(treeKey);
					if(bookNum == treeKey) {
						String bookName = bvo.getBookName();
						vo.checkOutPrint(bookName);
						count++;
					}
				}
			}
		}
	}
	public static void checkOutBook() {
		Scanner scan = new Scanner(System.in);
		Collection<CheckOutVO> cc = CheckOutData.checkout.values();
		Iterator<CheckOutVO> bookValue =  cc.iterator();
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		int count = 1;
		
		while (bookValue.hasNext()) {
			CheckOutVO vo = bookValue.next();
			if(vo.getReturnDate().equals("0")) {
				String bookNum = vo.getBookNum();
				Iterator<String> bookKey = key.iterator();
				while (bookKey.hasNext()) {
					if(count%4==0) {
						System.out.print("\t다음으로 넘어가려면 아무키나 입력하세요 !!");
						String next = scan.nextLine();
						System.out.println("    =======================================================================================    ");
						count=1;
					}
					String treeKey = bookKey.next();
					BookVO bvo = BookData.bookData.get(treeKey);
					if(bookNum.equals(treeKey)) {
						String bookName = bvo.getBookName();
						vo.checkOutPrint(bookName);
						count++;
					}
				}
			}
		}
	}
	public static void returnBook(String userNum) {
		Scanner scan = new Scanner(System.in);
		CheckOutData.BasicCheckOut();
		Collection<CheckOutVO> cc = CheckOutData.checkout.values();
		Iterator<CheckOutVO> bookValue =  cc.iterator();
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		int count = 1;
		while (bookValue.hasNext()) {//대출도서 검색
			CheckOutVO vo = bookValue.next();//로그인한사람이랑 대출책의 등록자랑 같고 반납이 미반납인 책이라면
			if(userNum==vo.getUserNum()&&!(vo.getReturnDate().equals("0"))) {
				String bookNum = vo.getBookNum();
				Iterator<String> bookKey =  key.iterator();
				while (bookKey.hasNext()) {
					if(count%4==0) {
						System.out.print("\t다음으로 넘어가려면 아무키나 입력하세요 !!");
						String next = scan.nextLine();
						System.out.println("    =======================================================================================    ");
						count=1;
					}
					String treeKey = bookKey.next();
					BookVO bvo = BookData.bookData.get(treeKey);
					if(bookNum == treeKey) {
						String bookName = bvo.getBookName();
						vo.returnPrint(bookName);
						count++;
					}
				}
			}
		}
	}
	public static void returnBook() {
		Scanner scan = new Scanner(System.in);
		Collection<CheckOutVO> cc = CheckOutData.checkout.values();
		Iterator<CheckOutVO> bookValue =  cc.iterator();
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		int count = 1;
		while (bookValue.hasNext()) {//대출도서 검색
			CheckOutVO vo = bookValue.next();//로그인한사람이랑 대출책의 등록자랑 같고 반납이 미반납인 책이라면
			if(!(vo.getReturnDate().equals("0"))) {
				String bookNum = vo.getBookNum();
				Iterator<String> bookKey =  key.iterator();
				while (bookKey.hasNext()) {
					if(count%4==0) {
						System.out.print("\t다음으로 넘어가려면 아무키나 입력하세요 !!");
						String next = scan.nextLine();
						System.out.println("    =======================================================================================    ");
						count=1;
					}
					String treeKey = bookKey.next();
					BookVO bvo = BookData.bookData.get(treeKey);
					if(bookNum == treeKey) {
						String bookName = bvo.getBookName();
						vo.returnPrint(bookName);
						count++;
					}
				}
			}
		}
	}
	
	
}
