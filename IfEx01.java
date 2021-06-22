import java.util.Scanner;

class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("첫번째 수를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.printf("두번째 수를 입력해주세요 : ");
		int num2 = sc.nextInt();

		if (num>0&&num2>0){
			System.out.printf("%d, %d 두 수 모두 양수네요 사칙연산을 출력합니다.\n", num, num2);
			System.out.printf("+는 %d,-는 %d,*는 %d, /는 %d입니다.\n", num+num2, num-num2, num*num2, num/num2);
		}else{
			System.out.printf("데이터를 잘못입력하였습니다.\n");		
		}


	}
}
/*

	두 수를 입력받아 입력받은 모든 수가 양수일때는 사칙연산을 한 결과를 출력하고
	두 수 모두 양수가 아닐때는 "데이터를 잘못 입력하였습니다."라는 메세지를 출력하라.

*/