import java.util.Scanner;
class IfTest
{
	public static void main(String[] args) 
	{
		// 어떤 수를 입력받아 짝수일때는 출력하고 짝수가 아니면 출력하지 않는다.
		Scanner sc = new Scanner(System.in);
		System.out.printf("0보다 큰 정수를 입력하세요 : ");
		int num = sc.nextInt(); 
		//if (num%2==0){ //짝수일때만
		//if (num/2 == num/2.0){
		if(num%3!=0){ // 3의 배수가 아닐때만 출력
			//System.out.printf("%d는 짝수입니다. \n",num);
			System.out.printf("%d는 3의 배수가 아닙니다.\n",num);
		}

		System.out.println("end");
	}
}
/*

	if문
	조건문은 반드시 논리형 결과여야 한다.

	if(조건문 or 수식 or 변수  or 상수){
		참일 때 실행할 실행문;
		실행문;
		실행문;
	}

*/