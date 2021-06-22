//2021. 6. 4 ���ǹ� ���� �ۼ��� : �ڵ���

import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 = ");
		int age = sc.nextInt();
		System.out.print("성별(1:남성,2:여성=");
		int sex = sc.nextInt();
		System.out.print("키=");
		int height = sc.nextInt();
		System.out.print("현재체중 =");
		int weight = sc.nextInt();

		double standardWeight = 0;
		if (age<=35){
			if (sex==1){
				standardWeight = (height - 100)*0.90;
			}else if(sex==2){
				standardWeight = (height - 100)*0.85;	
			}
		}else{
			if (sex==1){
				standardWeight = (height - 100)*0.95;
			}else if(sex==2){
				standardWeight = (height - 100)*0.90;
			}
		}

		double swi = (weight/standardWeight)*100; // swi�� ǥ��ü������

		String swiRating = ""; 

		if (swi<=85){
			swiRating = "마른형";
		}else if(swi>85&&swi<=95){
			swiRating = "조금마른형";
		}else if(swi>95&&swi<=115){
			swiRating = "표준형";
		}else if(swi>115&&swi<=125){
			swiRating = "조금비만형";
		}else{
			swiRating = "비만형";
		}

		System.out.printf("표준체중 = %d\n",(int)standardWeight);
		System.out.printf("당신은 표준체중지수는 %17.14f으로 %s입니다.\n",swi,swiRating);
	}
}
/*
입력
표준체중
표중체중 평가기준
출력
	ǥ��ü�� ����
	35�� ����
		���� : (Ű - 100)*0.90
		���� : (Ű - 100)*0.85
	36�� �̻�
		���� : (Ű - 100)*0.95
		���� : (Ű - 100)*0.90

	ǥ��ü�� ���� = (����ü��/ǥ��ü��)*100

		ǥ��ü������ �򰡱���
			������:85����
			���ݸ����� : 86~95
			ǥ���� : 96~115
			���� ���� : 116~125
			���� : 126�̻�
======================================
������
���� = �Է�
����(1:����,2:����)=�Է�
Ű = �Է�
����ü�� =�Է�
ǥ��ü�� = ���
����� ǥ��ü�������� %f���� %s�Դϴ�.
*/