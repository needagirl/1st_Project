import java.util.Scanner;

class Grade02
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("국어=");
		int kor = sc.nextInt();
		System.out.print("영어=");
		int eng = sc.nextInt();
		System.out.print("수학=");
		int math = sc.nextInt();

		int sum = kor + eng + math;
		double aver = (double)sum/3;
		String grade = "F";
		
		switch((int)aver/10){
			case 9: case 10:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
		}
		System.out.printf("총점=%d\n평균=%.2f\n학점=%s\n",sum,aver,grade);
	}
}
/*

	국어, 영어, 수학 점수를 입력받아 총점, 평균, 학점을 출력하라..
	각 과목의 점수는 0~100점 사이의 값이다.
	평균은 실수를 구하라

	학점
	90~100  A
	80~89   B
	70~79	C
	60~60	D
	0~59	F

	실행을 하면
	국어=80
	영어=80
	수학=80
	=======================
	총점=240
	평균=80.0
	학점=B
	

*/