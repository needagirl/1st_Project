import java.util.Scanner;

	
public class Ex_01 {
	public Ex_01() {
	}
	public boolean birthCheck(String birth) {
		if (birth.length()==8) {
			String month = birth.substring(4, 6);
			String day = birth.substring(6);
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			if(monthInt<1||monthInt>12||dayInt<1||dayInt>31) {
				return false;
			}
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		Ex_01 ex = new Ex_01();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("생일 입력");
			String birth = scan.nextLine();
			System.out.println(ex.birthCheck(birth));
			
		}while(true);
			
	}

}
