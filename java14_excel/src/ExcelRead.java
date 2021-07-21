import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead {

	public ExcelRead() {
		
	}
	public void start() {
		try {
			File file = new File("C://testFile", "member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			//byteCode인 InputStream을 엑셀파일로 변환하는 클래스
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			//1. workbook 객체 얻어오기
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			// 시트의 수 구하기
			int sheetCnt = workbook.getNumberOfSheets();
			System.out.println("sheets = "+sheetCnt);
			
			// 2. sheet 객체 얻어오기
			HSSFSheet sheet0 = workbook.getSheetAt(0);
			HSSFSheet sheet1 = workbook.getSheet("회원목록");
			
			//행의 수 구하기
			int rowCnt = sheet1.getPhysicalNumberOfRows();
			System.out.println("rowCnt = "+rowCnt);
			
			//제목
			System.out.println("번호\t이름\t연락처\t\t나이\t등록일");
			
			//3. row 객체 얻어오기
			for (int rowIdx = 1; rowIdx < rowCnt; rowIdx++) {
				HSSFRow row = sheet1.getRow(rowIdx);
				// 셀 수 구하기
				int cellCnt = row.getPhysicalNumberOfCells();
//				System.out.println("셀의 수 = "+cellCnt);
				for (int cellIdx = 0; cellIdx < cellCnt; cellIdx++) {
					HSSFCell cell = row.getCell(cellIdx);
					if(cellIdx==0||cellIdx==3) {
						int data = (int)cell.getNumericCellValue();
						System.out.print(data+"\t");
					}else if(cellIdx==1||cellIdx==2) {
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}else if(cellIdx==4) {
						Date data = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						String dateStr = format.format(data);
						System.out.println(dateStr+"\t");
						
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ExcelRead().start();
	}

}
