import java.util.Calendar;
import java.util.Scanner;

public class Calendar_OOP {
	Calendar cal = Calendar.getInstance();
	int year, month;

	public Calendar_OOP() {
	}

	// 입력
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도=");
		year = sc.nextInt();
		System.out.print("월=");
		month = sc.nextInt();
	}
	// 셋팅
	void setCalendar() {
		cal.set(year, month - 1, 1);
	}
	//출력
	void output() {
		System.out.println("\t\t"+year+"년 "+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 1;i<dayOfWeek ;i++ ){
			System.out.print("\t");
		}
		for (int j = 1;j<=cal.getActualMaximum(Calendar.DATE) ;j++ ){
			System.out.print(j+"\t");
			if(dayOfWeek%7==0){
				System.out.println();
			}
			dayOfWeek++;
		}
		System.out.println();
	}
	
	//실행
	void start() {
		input();
		setCalendar();
		output();
	}

	public static void main(String[] args) {
		Calendar_OOP co = new Calendar_OOP();
		co.start();
	}

}
