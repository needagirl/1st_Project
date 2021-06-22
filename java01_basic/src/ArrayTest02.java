
public class ArrayTest02 {

	public static void main(String[] args) {
		// 2차원 : 행과 열을 가진다.

		// 배열의 선언
		int data[][] = new int[5][5];// int 25개를 저장 가능한 변수가 생성됨

		data[0][3] = 100;
		data[1][2] = 85;
		data[1][4] = 84;
		data[3][3] = 77;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) { // data[i].length -> i행의 칸수
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
		// 2차원 배열의 초기값을 설정하기
		String[][] jusorok = { { "홍길동", "010-3340-3258", "asdkjl312@naver.com" },
								{ "이순신", "010-2423-2141", "asdfas@gmail.com" }, 
								{ "박휘순", "010-5352-2345", "ckdje@nate.com" } };
		for (int i = 0; i < jusorok.length; i++) {
			for (int j = 0; j < jusorok[i].length; j++) {
				System.out.print(jusorok[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
