import java.util.Iterator;
import java.util.Scanner;

public class ArrayEx03_Money {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] num = new int[10];
		do {
			System.out.print("금액을 입력하세요.?");
			int input = sc.nextInt();
			for (int i = 0; i < money.length; i++) {
				num[i] = input / money[i];
				input -= money[i] * num[i];
				if (num[i] != 0) {
					System.out.print(money[i] + "원=" + num[i]);
					if (money[i] >= 1000) {
						System.out.println("장");
					} else {
						System.out.println("개");
					}
				}
			}
			System.out.println("다시하겠습니까(1.예, 2.아니오)?");
//			int end = sc.nextInt();
			if (sc.nextInt() == 2)
				break;
		} while (true);

	}

}
/*
 * 금액을 입력하세요/? 50000원= 10000원=
 */