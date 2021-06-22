import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// 로또 번호 생성기
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("게임수=");
			int game = sc.nextInt();
			int lotto[] = new int[10];
			for (int i = 0; i < game; i++) {
				for (int j = 0; j < lotto.length; j++) {
					lotto[j] = ran.nextInt(45)+1;
				}
				int index = 0 ;
				int[] temp = new int[6];
				for (int overlap = 0; overlap < lotto.length; overlap++) {
					boolean k = false;
					for (int j = 0; j < temp.length; j++) {
						temp[j] = lotto[j];
						if (lotto[overlap] == temp[j]) {
							k = true;
						}
					} 
					if(!k){
						temp[index++] = lotto[overlap];
					}
				}
				System.out.println(Arrays.toString(lotto));
				System.out.println(Arrays.toString(temp));
				int temp2 = 0;
				for (int sort = 0; sort < temp.length - 1; sort++) {
					for (int l = 0; l < temp.length - 2 - sort; l++) {
						if (temp[l] > temp[l + 1]) {
							temp2 = temp[l];
							temp[l] = temp[l + 1];
							temp[l + 1] = temp2;
						}
					}
				}
//				for (int overlap = 0; overlap < lotto.length-1; overlap++) {
//					if (lotto[6] == lotto[overlap]) {
//						lotto[6] = ran.nextInt(45)+1;
//					}
//				}
				System.out.printf("%d게임 = ",i+1);
				for (int j = 0; j < temp.length-1; j++) {
					System.out.print(temp[j]+", ");
				}
				System.out.println("보너스"+temp[5]);
				
			}	
			System.out.print("계속하시겠습니까(1:예, 2:아니오)?");
			int end = sc.nextInt();
			if(end ==1) {
				continue;
			}else if(end ==2) {
				break;
			}
		}
	}
}
/*
 * 로또 번호는 1~45까지 번호 6개 보너스 1개
 * 
 * 실행 게임수 = 3(입력받기) 1게임 = 난수 6개 , 보너스 1개 2게임 = 난수 6개 , 보너스 1개 3게임 = 난수 6개 , 보너스
 * 1개 계속하시겠습니까(1:예, 2:아니오)?
 * 
 * 게임수 = 5 1게임 = 난수 6개 , 보너스 1개 2게임 = 난수 6개 , 보너스 1개 3게임 = 난수 6개 , 보너스 1개 4게임 =
 * 난수 6개 , 보너스 1개 5게임 = 난수 6개 , 보너스 1개 계속하시겠습니까(1:)?
 */// 크기 순서대로 정렬, 중복 없음