import java.util.Calendar;
import java.util.Scanner;
class CalendarHomework 
{
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("년도=");
			int year = sc.nextInt();
			System.out.print("월=");
			int month = sc.nextInt();

			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month-1);
			cal.set(Calendar.DATE, 1);
			//System.out.println(cal.getTime());
			System.out.print("\t\t"+year+"년 "+month+"월\n");
			System.out.println("일\t월\t화\t수\t목\t금\t토");

			//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
			//System.out.println(cal.getActualMaximum(Calendar.DATE));
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
	}
}
