import java.util.Scanner;

class IfElseTest 
{
	public static void main(String[] args) 
	{
		//�Է¹��� ������ ���� ¦���� 100�� ���Ͽ� ���
		//Ȧ���� 200�� ���Ͽ� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("���� ������ �Է��ϼ��� : ");
		int num = sc.nextInt();

		int result=0;
		if (num%2==1){
			result = num*200;
		}else{
			result = num*100;
		}
		System.out.printf("%d -> %d\n",num,result);
		/*if (num%2==0){
			System.out.printf("%d�� ¦���׿�! 100�� ���Ͽ� %d�� ����մϴ�.\n",num,num*100);
		}else{
			System.out.printf("%d�� Ȧ���׿�! 200�� ���Ͽ� %d�� ����մϴ�.\n",num,num*200);
		}
		*/
	}
}


/* 

	if~else��

	if(���ǹ�){
		���ǹ��� ���϶� ����;
	}else{
		���ǹ��� �����϶� ����;
	}


*/