import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import libraryData.BookData;
import libraryData.BookVO;

public class Search {

	public Search() {
	}
	
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
	public static void findBook(String search) {
		Scanner scan = new Scanner(System.in);
		BookData.basicBook();
		Set<String> key = BookData.bookData.keySet();
		Iterator<String> ii = key.iterator();
		int count = 1;
		
		while(ii.hasNext()) {
			if(count%3==0) {
				System.out.print("\t다음으로 넘어가려면 아무키나 입력하세요 !!");
				String next = scan.nextLine();
				System.out.println("    =======================================================================================    ");
				count=1;
			}
			String treekey =ii.next();
			BookVO vo = BookData.bookData.get(treekey);
			String textString = vo.getAll();
			if(textString.indexOf(search)!=-1) {
				vo.bookPrint(treekey);
				count++;
			}
		}
	}
	
	public static void head() {
		System.out.println("\n\n    ---------------------------------------------------------------------------------------    ");
	}
}
