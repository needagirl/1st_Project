import java.util.Scanner;

class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("ù��° ���� �Է����ּ��� : ");
		int num = sc.nextInt();
		System.out.printf("�ι�° ���� �Է����ּ��� : ");
		int num2 = sc.nextInt();

		if (num>0&&num2>0){
			System.out.printf("%d, %d �� �� ��� ����׿� ��Ģ������ ����մϴ�.\n", num, num2);
			System.out.printf("+�� %d,-�� %d,*�� %d, /�� %d�Դϴ�.\n", num+num2, num-num2, num*num2, num/num2);
		}else{
			System.out.printf("�����͸� �߸��Է��Ͽ����ϴ�.\n");		
		}


	}
}
/*

	�� ���� �Է¹޾� �Է¹��� ��� ���� ����϶��� ��Ģ������ �� ����� ����ϰ�
	�� �� ��� ����� �ƴҶ��� "�����͸� �߸� �Է��Ͽ����ϴ�."��� �޼����� ����϶�.

*/