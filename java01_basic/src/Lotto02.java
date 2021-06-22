import java.util.Random;
import java.util.Scanner;

public class Lotto02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		Random ran = new Random();
		
		do {
			//게임수
			System.out.print("게임수=");
			int cnt = sc.nextInt();
			//입력받은 게임 수 만큼 게임 만들기
			for (int game = 1; game <= cnt; game++) {
				int[] lotto = new int[7];
				for (int i = 0; i < lotto.length; i++) {
					lotto[i] = ran.nextInt(45)+1;
					//중복검사
					for (int j = 0; j < i; j++) {
						if(lotto[i]==lotto[j]) {
							i--;
						}
					}
				}
				//정렬
				for (int i = 0; i < lotto.length-2; i++) {
					for (int j = 0; j < lotto.length-2-i; j++) {
						if(lotto[j]>lotto[j+1]) {
							int temp = lotto[j];
							lotto[j] = lotto[j+1];
							lotto[j+1] = temp;
						}
					}
				}
				System.out.print(game+"게임=");
				for (int i = 0; i < lotto.length-1; i++) {
					System.out.print(lotto[i]+",");
				}
				System.out.println("보너스 = "+lotto[6]);
			}
			
			System.out.print("계속하시겠습니까[1:예, 2:아니오]?");
			int check = sc.nextInt();
			if(check==2) break;
		} while (true);
	}
}
