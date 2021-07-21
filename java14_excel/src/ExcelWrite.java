import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
	POI다운로드 
	jakarta.apache.org에서 POI
	
	poi-bin-5.0.0-20210120.zip 다운
	
	압축을 푼 후
	poi-5.0.0.jar, commons-math3-3.6.1.jar build path를 설정한다.
*/
public class ExcelWrite {

	public ExcelWrite() {
	}
	//엑셀로 저장하기
	public void start() {
		//1. workbook 객체를 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		//2. sheet 객체를 생성
		HSSFSheet sheet1 = workbook.createSheet();
		HSSFSheet sheet2 = workbook.createSheet("회원목록");//시트명을 회원목록으로 만들어짐
		
		//3. row 객체를 생성
		HSSFRow row = sheet2.createRow(0);
		
		//4. cell 객체를 생성하고 값을 셋팅
		row.createCell(0).setCellValue("번호");
		row.createCell(1).setCellValue("이름");
		row.createCell(2).setCellValue("연락처");
		row.createCell(3).setCellValue("나이");
		row.createCell(4).setCellValue("등록일");
		
		// 행생성 셀을 생성하여 값 대입
		HSSFRow row1 = sheet2.createRow(1);
		row1.createCell(0).setCellValue(100);
		row1.createCell(1).setCellValue("홍길동");
		row1.createCell(2).setCellValue("010-2323-4352");
		row1.createCell(3).setCellValue(25);
		row1.createCell(4).setCellValue(Calendar.getInstance());
		HSSFRow row2 = sheet2.createRow(2);
		row2.createCell(0).setCellValue(101);
		row2.createCell(1).setCellValue("강감찬");
		row2.createCell(2).setCellValue("010-2232-5312");
		row2.createCell(3).setCellValue(30);
		row2.createCell(4).setCellValue(Calendar.getInstance());
		HSSFRow row3 = sheet2.createRow(3);
		row3.createCell(0).setCellValue(102);
		row3.createCell(1).setCellValue("이순신");
		row3.createCell(2).setCellValue("010-2432-5552");
		row3.createCell(3).setCellValue(20);
		row3.createCell(4).setCellValue(Calendar.getInstance());
		
		//5. 파일로 쓰기
		File f = new File("C://testFile","member.xls");
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
			//workbook의 write메소드를 호출하면 파일로 저장된다.
			workbook.write(fos);
			fos.close();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("엑셀로 쓰기 완료...");
		
	}
	public static void main(String[] args) {
		new ExcelWrite().start();
	}

}
