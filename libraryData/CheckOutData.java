package libraryData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class CheckOutData {
	Scanner scan = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public static TreeMap<String, CheckOutVO> checkout = new TreeMap<String, CheckOutVO>();
	public CheckOutData() {
	}
	//회원번호, 도서등록번호, 대출일, 반납예정일, 반납일
	public static void BasicCheckOut() {
		checkout.put("1", new CheckOutVO("1","G001","20210620","20210704","0"));
		checkout.put("2", new CheckOutVO("1","G002", "20210620", "20210704","20210625"));
		checkout.put("3", new CheckOutVO("1","G003", "20210620", "20210704","20210625"));
		checkout.put("4", new CheckOutVO("1","G004","20210620","20210704","0"));
		checkout.put("5", new CheckOutVO("1","G005","20210620","20210704","20210620"));
		checkout.put("6", new CheckOutVO("1","G006","20210622","20210705","20210622"));
		checkout.put("7", new CheckOutVO("1","G007","20210622","20210705","20210622"));
		checkout.put("8", new CheckOutVO("1","G008","20210622","20210706","20210622"));
		checkout.put("9", new CheckOutVO("1","G009","20210622","20210706","20210622"));
		checkout.put("10", new CheckOutVO("2","G010","20210625","20210709","0"));
		checkout.put("11", new CheckOutVO("2","G011","20210625","20210709","0"));
		checkout.put("12", new CheckOutVO("2","G002","20210625","20210709","0"));
		checkout.put("13", new CheckOutVO("2","G003","20210625","20210709","0"));
		checkout.put("14", new CheckOutVO("2","G009","20210626","20210710","0"));
	}
	public void setCheckOut() {
		Calendar cal = Calendar.getInstance();
		String bookNum = inData("도서등록번호");
		String userNum = inData("대출회원번호");
		String key = Integer.toString(checkout.size()+1);
		String chOutDate = sdf.format(cal.getTime());
		cal.add(Calendar.DATE, 14);
		String bookBackDate = sdf.format(cal.getTime());
		checkout.put(key, new CheckOutVO(userNum,bookNum,chOutDate,bookBackDate,"0"));
		
		String year = chOutDate.substring(0,4);
		String month = chOutDate.substring(4, 6);
		String day = chOutDate.substring(6);
				
		System.out.printf("\n     %s : %s\t  %s : %s년 %s월 %s일\n\t\t\t\t\t%s\n","등록번호",bookNum,"대출일", year, month, day, "대출 되었습니다.");
		System.out.println("    ---------------------------------------------------------------------------------------    ");
		
	}
	public void returnBook() {
		Calendar cal = Calendar.getInstance();
		String search = inData("\t반납할 도서번호를 입력하세요");
		Collection<CheckOutVO> values = checkout.values();
		Iterator<CheckOutVO> ii = values.iterator();
		while(ii.hasNext()) {
			CheckOutVO vo = ii.next();
			String bookNum = vo.getBookNum();
			if(search.equals(bookNum)&&vo.getReturnDate().equals("0")) {
				vo.setReturnDate(sdf.format(cal.getTime()));
				vo.printBack(bookNum);
			}
		}
	}
	
	public String inData(String msg) {
		System.out.print(msg + ">> ");
		return scan.nextLine();
	}
}