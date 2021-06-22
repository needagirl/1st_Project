class WhileTest01 
{
	public static void main(String[] args) 
	{
		//1~5까지 출력
		int num = 1;
		while (num<=5){//조건식이 참일때 실행
			System.out.println(num);
			//값을 증가시키는 수식
			num++;
		}

		//5,4,3,2,1
		int num2 = 5;
		while (num2>0){
			num2--;
			System.out.println(num2+1);
			
		}
	}
}
/*
		while() : 반복문

		while(조건문){
			실행문;
			실행문;
			
		}

*/