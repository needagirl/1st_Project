import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import libraryData.BookData;
import libraryData.BookVO;
import libraryData.CheckOutVO;

public class Test {

	public Test() {
	}
	public static void findBook(String search) {
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		Iterator<String> ii = key.iterator();
		while(ii.hasNext()) {
			BookVO vo = BookData.bookData.get(ii.next());
			String textString = vo.getAll();
			if(textString.indexOf(search)!=-1) {
				vo.bookPrint(ii.next());
			}
		}
	}
//	public static void findBook(String search) {
//		CheckOutData.BasicCheckOut();
//		Collection<CheckOutVO> cc = CheckOutData.checkout.values();
//		
//		BookData.basicBook();
//		Collection<BookVO> vo = BookData.bookData.values();
//		Iterator<BookVO> book =  vo.iterator();
//		
//		while (book.hasNext()) {//가지고 있는 책중에서
//			BookVO dd = book.next();
//			String textString = dd.getAll();
//			Iterator<CheckOutVO> bookValue = cc.iterator();
//			if(textString.indexOf(search)!=-1) {//검색어랑 겹친다면
//				String bookNum = dd.getBookNum();//
//				while (bookValue.hasNext()) {//검색된책이랑 대출현황 모두랑 비교
					//만약 대출책번호중에 번호가 없는 책이 있다면
//					CheckOutVO bvo = bookValue.next();
//					if(bvo.getBookNum().indexOf(bookNum)==-1) {
//						dd.bookPrint();
//						bookValue.remove();
//					}
//					System.out.println(bvo);
//					if(bvo.getBookNum().indexOf(bookNum)!=-1) {
//						String returnDate = bvo.getReturnDate();
//						dd.bookPrint(returnDate);
//					}else {
//						dd.bookPrint();
//					}
//				}
//				
//			}
//		}
//	}
	
	public static void recomend() {
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		String[] best = new String[3];
		int borrowNum=0;
		Iterator<String> ii = key.iterator();
		while(ii.hasNext()) {
			String keyNum =ii.next();
			BookVO vo = BookData.bookData.get(keyNum);
			if(Integer.parseInt(vo.getBorrowNum())>=borrowNum) {
				best[0]=keyNum;
				borrowNum=Integer.parseInt(vo.getBorrowNum());
			}
		}
		Iterator<String> iii = key.iterator();
		while(iii.hasNext()) {
			String keyNum =iii.next();
			BookVO vo = BookData.bookData.get(keyNum);
			if(Integer.parseInt(vo.getBorrowNum())>=borrowNum) {
				if(best[0].equals(keyNum)) {
					break;
				}
				best[1]=keyNum;
				borrowNum=Integer.parseInt(vo.getBorrowNum());
			}
		}
		Iterator<String> iiii = key.iterator();
		while(iiii.hasNext()) {
			String keyNum =iiii.next();
			BookVO vo = BookData.bookData.get(keyNum);
			if(Integer.parseInt(vo.getBorrowNum())>=borrowNum) {
				if(best[0].equals(keyNum)||best[1].equals(keyNum)) {
					break;
				}
				best[2]=keyNum;
				borrowNum=Integer.parseInt(vo.getBorrowNum());
			}
		}
		for (int i = 0; i < best.length; i++) {
			System.out.println("\t\t\t\t\t      BEST"+(i+1));
			System.out.println("    ---------------------------------------------------------------------------------------    ");
			BookVO vo = BookData.bookData.get(best[i]);
			vo.recomendPrint(best[i]);
			
		}
		for (String a : best) {
		}
	}
	
//	public static void recoBook() {
//		BookData.basicBook();
//		Set<String> key = BookData.bookData.keySet();
//		String[] best = {"0","0","0"};
//		String result ="0";
//		String result2 ="0";
////		for (int i = 0; i < best.length; i++) {
//			int borrowNum=0;
//			Iterator<String> ii = key.iterator();
//			while(ii.hasNext()) {
//				String keyNum =ii.next();
//				BookVO vo = BookData.bookData.get(keyNum);
////				System.out.println(result);
//				if(Integer.parseInt(vo.getBorrowNum())>=borrowNum) {
////					System.out.println(keyNum.equals(result));
//					if(keyNum.equals(result)) {
//						borrowNum=Integer.parseInt(vo.getBorrowNum());
//						if(keyNum.equals(result)&&keyNum.equals(result2)) {
//							borrowNum=Integer.parseInt(vo.getBorrowNum());
//							ii.next();
//						}else {
//							borrowNum=Integer.parseInt(vo.getBorrowNum());
//							result= keyNum;
//							best[i] = keyNum;
//						ii.next();
//						}
//					}else {
//						borrowNum=Integer.parseInt(vo.getBorrowNum());
//						result= keyNum;
//						best[i] = keyNum;
//					}
//				}
//			}
////			result = best[i];
//		}
//		for (String string : best) {
//			System.out.println(a);
//		}
//		}
////		if(best[1].equals(best[0])) {
////		}
//	}
//	public String inData(String msg) {
//		System.out.print(msg + ">> ");
//		return scan.nextLine();
//	}
//	public void setCheckOut() {
//		
//		Calendar cal = Calendar.getInstance();
//		String key = Integer.toString(checkout.size()+1);
//		String userNum = inData("대출회원번호");
//		String bookNum = inData("도서등록번호");
//		String chOutDate = sdf.format(cal.getTime());
//		cal.add(Calendar.DATE, 14);
//		String bookBackDate = sdf.format(cal.getTime());
//		
//		checkout.put(key, new CheckOutVO(userNum,bookNum,chOutDate,bookBackDate,"0"));
//	}
	public static void main(String[] args) {
//		setCheckOut();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		String chOutDate = sdf.format(cal.getTime());
		System.out.println(chOutDate);
		cal.add(Calendar.DATE, 14);
		String bookBackDate = sdf.format(cal.getTime());
		System.out.println(bookBackDate);
	}

}
