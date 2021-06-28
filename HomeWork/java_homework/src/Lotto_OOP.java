import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto_OOP {

	public Lotto_OOP() {

	}

	// 실행
	public void start() {
		do {
			int game = input();
			for (int i = 1; i <= game; i++) {
				int[] lotto = sort(random());
				System.out.print(i + "게임=");
				output(lotto);
			}
		} while (true);
	}

	// 입력
	public int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임수=");
		return sc.nextInt();
	}

	// 난수생성 & 중복검사
	public int[] random() {
		Random ran = new Random();
		int[] lotto = new int[7];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = ran.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
				}
			}
		}
		return lotto;
	}

	// 정렬
	public int[] sort(int[] lotto) {
		Arrays.sort(lotto, 0, 6);
		return lotto;
	}

	// 출력
	public void output(int[] lotto) {
		for (int i = 0; i < lotto.length - 1; i++) {
			System.out.print(lotto[i] + ", ");
		}
		System.out.println("bonus=" + lotto[6]);
	}

	public static void main(String[] args) {
		new Lotto_OOP().start();
	}

}
