import java.util.Scanner;

public class ArrayScore {
	Scanner scan = new Scanner(System.in);

	public ArrayScore() throws Exception {
		start();
	}

	public void start() throws Exception {
		int stuNum = setStudentsNumber();
		int score[][] = new int[stuNum + 2][6];
		String name[] = new String[stuNum + 2];
		
		for (int i = 0; i < stuNum; i++) {
			name[i] = inputName();
			for (int j = 0; j < 3; j++) {
				score[i][j] = inputScore(j);
			}
		}
		
		// 총점&&평균
		name[stuNum] = "총점";
		name[stuNum + 1] = "평균";
		
		for (int i = 0; i < stuNum; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] += score[i][j];
				score[stuNum][j] += score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}
		
		for (int i = 0; i < 3; i++) {
			score[stuNum + 1][i] = score[stuNum][i]/stuNum;
		}
		// 석차
		for (int i = 0; i < stuNum; i++) {
			for (int j = 0; j < stuNum; j++) {
				if (score[i][3] < score[j][3]) {
					score[i][5]++;
				}
			}
			score[i][5]++;
		}
		// 정렬
		int temp;
		
		for (int i = 0; i < name.length-1; i++) {
			if(score[i][3]<score[i+1][3]) {
				for (int j = 0; j < 6; j++) {
					temp = score[i][j];
					score[i][j]= score[i+1][j];
					score [i+1][j] = temp;
				}
			}
		}
		
		// 출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public int setStudentsNumber() throws Exception {
		System.out.print("몇명의 점수를 입력하시겠습니까?");
		int stuNum = Integer.parseInt(scan.nextLine());
		return stuNum;
	}

	public String inputName() throws Exception {
		System.out.print("이름=");	
		return scan.nextLine();
	}

	public int inputScore(int j) throws Exception {
		switch (j) {
		case 0:	System.out.print("국어="); break;
		case 1:	System.out.print("영어="); break;
		case 2:	System.out.print("수학="); break;
		}
		return Integer.parseInt(scan.nextLine());
	}

	public static void main(String[] args) {
		do {
			try {
				new ArrayScore();
			}catch (Exception e) {
				e.getMessage();
			}
		} while (true);
	}

}
