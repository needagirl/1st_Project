import java.util.Random;
import java.util.Scanner;

public class ArraySelectionSort {

	public static void main(String[] args) {
		// 1~100 사이의 난수를 10개 이상 생성하여 배열대입 후 오름차순으로 정렬하여 출력하라
		// Selection Sort[선택 정렬] 이용해라
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("난수를 몇개 생성할까요(10개 이상)?");
			int num[] = new int[sc.nextInt()];
			for (int i = 0; i < num.length; i++) {
				num[i] = ran.nextInt(100) + 1;
				// 중복제거
				for (int j = 0; j < i; j++) {
					if (num[i] == num[j]) {
						i--;
					}
				}
			}
			//중간확인
			System.out.println("=====난수생성=====");
			for (int i : num) {
				System.out.print(i + ", ");
			}
			System.out.println();
			// 정렬
			System.out.println("==정렬하겠습니다.==");
			for (int i = 0; i < num.length; i++) {
				int temp = i;
				for (int j = i + 1; j < num.length; j++) {
					if (num[j] < num[temp]) {
						temp = j;
					}
				}
				int temp2 = num[temp];
				num[temp] = num[i];
				num[i] = temp2;
			}
			// 출력
			for (int i : num) {
				System.out.print(i + ", ");
			}
			System.out.println();
			// 종료
			System.out.print("계속하겠습니까?(1:예, 2:아니요)");
			if (sc.nextInt() == 2)
				break;
		} while (true);
	}
}
