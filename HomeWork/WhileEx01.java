import java.util.Scanner;
class WhileEx01 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력=");
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
		System.out.printf("1~%d까지의 합은 %d\n",num,sum);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n",num,sumOdd);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n",num,sumEven);
		System.out.printf("1~%d까지의 3의 배수의 합은 %d\n",num,sumTriple);
	}
}

/*
	임의의 수(정수)를 입력받아 그 수 까지 합과, 짝수합, 홀수합, 3의 배수의 합을 구하여 출력하라.
	반드시 반복문은 while 문을 활용하라.

	실행

정수입력=15
1~15까지의 합은 _____
1~15까지의 홀수의 합은 _____
1~15까지의 짝수의 합은 _____
1~15까지의 3의 배수의 합은 _____


*/