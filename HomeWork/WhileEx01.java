import java.util.Scanner;
class WhileEx01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�=");
		int num = sc.nextInt();
		
		int sum = 0, sumOdd = 0, sumEven = 0, sumTriple = 0;
		int i = 1;
		while (i <=num){
			sum+=i;
			if (i%2!=0){
				sumOdd+=i;
			}else{
				sumEven+=i;
			}
			if(i%3==0){
				sumTriple+=i;
			}
			i++;
		}
		System.out.printf("1~%d������ ���� %d\n",num,sum);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n",num,sumOdd);
		System.out.printf("1~%d������ ¦���� ���� %d\n",num,sumEven);
		System.out.printf("1~%d������ 3�� ����� ���� %d\n",num,sumTriple);
	}
}

/*
	������ ��(����)�� �Է¹޾� �� �� ���� �հ�, ¦����, Ȧ����, 3�� ����� ���� ���Ͽ� ����϶�.
	�ݵ�� �ݺ����� while ���� Ȱ���϶�.

	����

�����Է�=15
1~15������ ���� _____
1~15������ Ȧ���� ���� _____
1~15������ ¦���� ���� _____
1~15������ 3�� ����� ���� _____


*/