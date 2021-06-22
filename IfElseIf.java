import java.util.Scanner;

class IfElseIf 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		/*
			 급여를 입력받아 급여가 10000~20000이면 보너스 20%
							20000~30000이면	15%
							30000~40000이면	10%
							40000~50000이면	5%
							그외 보너스 없음
		*/
		//1.급여입력
		System.out.print("급여를 입력해주세요. : ");
		int sal = sc.nextInt();
		int bonus = 0;
		//2.조건분류

		if (sal>=10000&&sal<=20000){
			bonus = (int)(sal * 0.2);
		}else if(sal>20000&&sal<=30000){
			bonus = (int)(sal * 0.15);
		}else if(sal>30000&&sal<=40000){
			bonus = (int)(sal * 0.1);
		}else if(sal>40000&&sal<=50000){
			bonus = (int)(sal * 0.05);
		}
		System.out.printf("급여 = %d, 보너스 = %d\n", sal, bonus);

	}
}


/*
	if~elseif문

	if(조건식){
		실행문;
		실행문;
	}elseif(조건식){
		실행문;
		실행문;
	}elseif(조건식){
		실행문;
		실행문;
	}else{
		실행문;
	}
*/