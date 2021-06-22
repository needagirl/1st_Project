import java.util.Scanner;

class Grade01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력해주세요. 각 점수는 0~100사이입니다.");
		System.out.print("국어=");
		int kor = sc.nextInt();
		System.out.print("영어=");
		int eng = sc.nextInt();
		System.out.print("수학=");
		int math = sc.nextInt();

		int sum = kor + eng + math;
		double aver = (double)sum/3;
		String grade = "F";

		if(kor>100||eng>100||math>100||kor<0||eng<0||math<0){
			System.out.println("점수는 0~100사이라니깐요!");
		}else{
			if (aver>=90){
				grade = "A";
			}else if(aver>=80){
				grade = "B";
			}else if(aver>=70){
				grade = "C";
			}else if(aver>=60){
				grade = "D";
			}
			System.out.println("=================");
			System.out.println("총점="+sum);
			System.out.printf("평균=%6.3f\n",aver);
			System.out.printf("학점=%s\n",grade);
		}
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