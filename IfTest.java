import java.util.Scanner;
class IfTest
{
	public static void main(String[] args) 
	{
		// � ���� �Է¹޾� ¦���϶��� ����ϰ� ¦���� �ƴϸ� ������� �ʴ´�.
		Scanner sc = new Scanner(System.in);
		System.out.printf("0���� ū ������ �Է��ϼ��� : ");
		int num = sc.nextInt(); 
		//if (num%2==0){ //¦���϶���
		//if (num/2 == num/2.0){
		if(num%3!=0){ // 3�� ����� �ƴҶ��� ���
			//System.out.printf("%d�� ¦���Դϴ�. \n",num);
			System.out.printf("%d�� 3�� ����� �ƴմϴ�.\n",num);
		}

		System.out.println("end");
	}
}
/*

	if��
	���ǹ��� �ݵ�� ���� ������� �Ѵ�.

	if(���ǹ� or ���� or ����  or ���){
		���� �� ������ ���๮;
		���๮;
		���๮;
	}

*/