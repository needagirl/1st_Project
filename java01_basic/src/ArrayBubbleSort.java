import java.util.Arrays;
import java.util.Random;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// 1~100������ ������ 10�� �����Ͽ� �迭 ���� �� ������������ �����Ͽ� ���
		int[] num = new int[10];
		Random ran = new Random();
		// ���� ����
		for (int i = 0; i < num.length; i++) {// i = 0,1,2,3,4,5,6,...9
			int random = ran.nextInt(100) + 1;
			num[i] = random;
		}
		// ���� �� ����Ÿ
		System.out.println("���� �� ����Ÿ");
		System.out.println(Arrays.toString(num));
		int temp = 0;
		for (int j = 0; j < num.length - 1; j++) {
			for (int i = 0; i < num.length - 1 - j; i++) {
				if (num[i] > num[i + 1]) {
					temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(num));
	}

}
