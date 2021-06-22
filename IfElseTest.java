import java.util.Scanner;

class IfElseTest 
{
	public static void main(String[] args) 
	{
		//입력받은 임의의 값이 짝수면 100을 곱하여 출력
		//홀수면 200을 곱하여 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("양의 정수를 입력하세요 : ");
		int num = sc.nextInt();

		int result=0;
		if (num%2==1){
			result = num*200;
		}else{
			result = num*100;
		}
		System.out.printf("%d -> %d\n",num,result);
		/*if (num%2==0){
			System.out.printf("%d는 짝수네요! 100을 곱하여 %d를 출력합니다.\n",num,num*100);
		}else{
			System.out.printf("%d는 홀수네요! 200을 곱하여 %d를 출력합니다.\n",num,num*200);
		}
		*/
	}
}


/* 

	if~else문

	if(조건문){
		조건문이 참일때 실행;
	}else{
		조건문이 거짓일때 실행;
	}


*/