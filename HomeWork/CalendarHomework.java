import java.util.Calendar;
import java.util.Scanner;
class CalendarHomework 
{
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("�⵵=");
			int year = sc.nextInt();
			System.out.print("��=");
			int month = sc.nextInt();

			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month-1);
			cal.set(Calendar.DATE, 1);
			//System.out.println(cal.getTime());
			System.out.print("\t\t"+year+"�� "+month+"��\n");
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");

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
