import java.util.Scanner;

class Grade01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է����ּ���. �� ������ 0~100�����Դϴ�.");
		System.out.print("����=");
		int kor = sc.nextInt();
		System.out.print("����=");
		int eng = sc.nextInt();
		System.out.print("����=");
		int math = sc.nextInt();

		int sum = kor + eng + math;
		double aver = (double)sum/3;
		String grade = "F";

		if(kor>100||eng>100||math>100||kor<0||eng<0||math<0){
			System.out.println("������ 0~100���̶�ϱ��!");
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
			System.out.println("����="+sum);
			System.out.printf("���=%6.3f\n",aver);
			System.out.printf("����=%s\n",grade);
		}
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