import java.util.Scanner;

class Grade02
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("����=");
		int kor = sc.nextInt();
		System.out.print("����=");
		int eng = sc.nextInt();
		System.out.print("����=");
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
		System.out.printf("����=%d\n���=%.2f\n����=%s\n",sum,aver,grade);
	}
}
/*

	����, ����, ���� ������ �Է¹޾� ����, ���, ������ ����϶�..
	�� ������ ������ 0~100�� ������ ���̴�.
	����� �Ǽ��� ���϶�

	����
	90~100  A
	80~89   B
	70~79	C
	60~60	D
	0~59	F

	������ �ϸ�
	����=80
	����=80
	����=80
	=======================
	����=240
	���=80.0
	����=B
	

*/