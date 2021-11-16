package libraryData;

import java.util.Scanner;
import java.util.TreeMap;

public class BookData {
	Scanner scan = new Scanner(System.in);
	public static TreeMap<String, BookVO> bookData = new TreeMap<String, BookVO>();
	public BookData() {
	}
	// 등록번호, 도서명, 저자, 출판사, 출판년도, 청구기호, 대여상태
	public static void basicBook() {
		bookData.put("G001", new BookVO("고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ","대출중","1"));
		bookData.put("G002", new BookVO("나는 대충 살기 위해 열심히 산다", "최이슬", "창작시대","2021", "818-최68ㄴ","대출중","2"));
		bookData.put("G003", new BookVO("고양이 해결사 깜냥", "홍민정", "창비","2020", "C813.8-홍38ㄱ","대출중","2"));
		bookData.put("G004", new BookVO("로드워크", "스티븐 킹", "황금가지","2021", "843.6-킹57ㄹ","대출중","1"));
		bookData.put("G005", new BookVO("나 푸른 강물로 가리", "정영남", "지구문학","2006", "811.6-정646나","대출가능","1"));
		bookData.put("G006", new BookVO("두 개의 달", "전성현", "문학과지성사","2018", "아808.9-문78ㅁ-v.153","대출가능","1"));
		bookData.put("G007", new BookVO("라 트라비아타", "쥬셉페 베르디", "예림","2013", "674.22-베297라","대출가능","1"));
		bookData.put("G008", new BookVO("말", "장폴 사르트르", "민음삼","2013", "808-세14ㅁ-v.189","대출가능","1"));
		bookData.put("G009", new BookVO("향수", "파트리크 쥐스킨트", "열린책들","2013", "808-열298ㅇ-v.82","대출중","2"));
		bookData.put("G010", new BookVO("개미:1", "베르나르 베르베르", "열린책들","2004", "863-베297개-v.1","대출중","1"));
		bookData.put("G011", new BookVO("개미:2", "베르나르 베르베르", "열린책들","2004", "863-베297개-v.2","대출중","1"));
		bookData.put("G012", new BookVO("개미:3", "베르나르 베르베르", "열린책들","2004", "863-베297개-v.3","대출가능","0"));
		bookData.put("G013", new BookVO("개미:4", "베르나르 베르베르", "열린책들","2004", "863-베297개-v.4","대출가능","0"));
		bookData.put("G014", new BookVO("개미:5", "베르나르 베르베르", "열린책들","2004", "863-베297개-v.5","대출가능","0"));
	}
	
	public void insertBook() {
		String key = inData("등록번호");
		String bookName = inData("책이름");
		String bookAuthor = inData("작가");
		String publisher = inData("출판사");
		String pubYear = inData("출판년도");
		String bookcall = inData("청구기호");
		bookData.put(key, new BookVO(bookName,bookAuthor,publisher,pubYear,bookcall,"대출가능","0"));
	}
	public void deleteBook() {
		String key = inData("삭제할 도서의 등록번호를 입력하세요");
		bookData.remove(key);
	}
	
	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
}
