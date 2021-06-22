import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto_OOP_Exception {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	public Lotto_OOP_Exception() {
	}

	// 1게임 만들기 + 보너스 포함, 중복검사
	public int[] lottoCreate() {
		int lotto[] = new int[7];
		for (int i = 0; i < lotto.length; i++) {
			// 로또번호 생성
			lotto[i] = random.nextInt(45) + 1;
			// 중복검사 호출
			i = doubleCheck(lotto, i);
		}
		return lotto;
	}

	// 중복검사
	public int doubleCheck(int lotto[], int i) {
		for (int j = 0; j < i; j++) {
			if (lotto[i] == lotto[j]) {
				i--;
				break;
			}
		}
		return i;
	}

	// 출력
	public void lottoPrint(int cnt, int lotto[]) {
			System.out.print(cnt + "게임=");
			System.out.print(Arrays.toString(Arrays.copyOfRange(lotto, 0, 6)));// 번호
			System.out.println(" bonus=" + lotto[6]);
			
	}
	// 계속여부 확인하는 메소드
	public boolean yesNo() {
		do {
			System.out.print("계속하시겠습니까(y:예, n:아니오)?");
			String qa = scan.nextLine();
			// y: 계속(true), n:종료(false), 그외 다시
			if (qa.equalsIgnoreCase("y")) {
				return true;
			} else if (qa.equalsIgnoreCase("n")) {
				return false;
			}
		} while (true);
	}

	public void lottoStart() {
		do {
			try {
				System.out.print("게임수 =");
				int game = Integer.parseInt(scan.nextLine());
				for (int i = 1; i <= game; i++) {
					int lotto[] = lottoCreate();
					Arrays.sort(lotto, 0, 6);
					lottoPrint(i, lotto);
				}
			// 계속여부
			if(!yesNo()) break;
			}catch(NumberFormatException nfe) {
				System.out.println("*숫자를 입력해 주세요.*");
			}
		} while (true);
	}

	
}
