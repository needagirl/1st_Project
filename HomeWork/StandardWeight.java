//2021. 6. 4 ���ǹ� ���� �ۼ��� : �ڵ���

import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("���� = ");
		int age = sc.nextInt();
		System.out.print("����(1:����,2:����)=");
		int sex = sc.nextInt();
		System.out.print("Ű =");
		int height = sc.nextInt();
		System.out.print("����ü�� =");
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
			swiRating = "������";
		}else if(swi>85&&swi<=95){
			swiRating = "���ݸ�����";
		}else if(swi>95&&swi<=115){
			swiRating = "ǥ����";
		}else if(swi>115&&swi<=125){
			swiRating = "���� ����";
		}else{
			swiRating = "����";
		}

		System.out.printf("ǥ��ü�� = %d\n",(int)standardWeight);
		System.out.printf("����� ǥ��ü�������� %17.14f���� %s�Դϴ�.\n",swi,swiRating);
	}
}

/*

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