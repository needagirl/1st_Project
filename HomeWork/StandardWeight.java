//2021. 6. 4 조건문 과제 작성자 : 박동현

import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 = ");
		int age = sc.nextInt();
		System.out.print("성별(1:남성,2:여성)=");
		int sex = sc.nextInt();
		System.out.print("키 =");
		int height = sc.nextInt();
		System.out.print("현재체중 =");
		int weight = sc.nextInt();

		double standardWeight = 0;
		if (age<=35){
			if (sex==1){
				standardWeight = (height - 100)*0.90;
			}else if(sex==2){
				standardWeight = (height - 100)*0.85;	
			}
		}else{
			if (sex==1){
				standardWeight = (height - 100)*0.95;
			}else if(sex==2){
				standardWeight = (height - 100)*0.90;
			}
		}

		double swi = (weight/standardWeight)*100; // swi는 표준체중지수

		String swiRating = ""; 

		if (swi<=85){
			swiRating = "마른형";
		}else if(swi>85&&swi<=95){
			swiRating = "조금마른형";
		}else if(swi>95&&swi<=115){
			swiRating = "표준형";
		}else if(swi>115&&swi<=125){
			swiRating = "조금 비만형";
		}else{
			swiRating = "비만형";
		}

		System.out.printf("표준체중 = %d\n",(int)standardWeight);
		System.out.printf("당신의 표준체중지수는 %17.14f으로 %s입니다.\n",swi,swiRating);
	}
}

/*

	표준체중 기준
	35세 이하
		남성 : (키 - 100)*0.90
		여성 : (키 - 100)*0.85
	36세 이상
		남성 : (키 - 100)*0.95
		여성 : (키 - 100)*0.90

	표준체중 지수 = (현재체중/표준체중)*100

		표준체중지수 평가기준
			마른형:85이하
			조금마른형 : 86~95
			표준형 : 96~115
			조금 비만형 : 116~125
			비만형 : 126이상
======================================
실행결과
나이 = 입력
성별(1:남성,2:여성)=입력
키 = 입력
현재체중 =입력
표준체중 = 계산
당신의 표준체중지수는 %f으로 %s입니다.
*/