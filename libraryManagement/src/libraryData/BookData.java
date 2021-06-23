package libraryData;

import java.util.TreeMap;

public class BookData {
	public static TreeMap<String, BookVO> bookData = new TreeMap<String, BookVO>();
	public BookData() {
	}
	public static void basicBook() {
		bookData.put("천미진", new BookVO("1","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("최이슬", new BookVO("2","나는 대충 살기 위해 열심히 산다", "최이슬", "창작시대","2021", "818-최68ㄴ"));
		bookData.put("홍민정", new BookVO("3","고양이 해결사 깜냥", "홍민정", "창비","2020", "C813.8-홍38ㄱ"));
		bookData.put("스티븐 킹", new BookVO("4","로드워크", "스티븐 킹", "황금가지","2021", "843.6-킹57ㄹ"));
		bookData.put("천미진1", new BookVO("5","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("천미진2", new BookVO("6","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("천미진3", new BookVO("7","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("천미진4", new BookVO("8","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("천미진5", new BookVO("9","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
		bookData.put("천미진6", new BookVO("10","고양이는 다 된다", "천미진", "키즈엠","2019", "C813.8-천38ㄱ"));
	}
}
