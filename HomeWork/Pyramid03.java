import java.util.Scanner;
class Pyramid03 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("임의의 홀수를 입력하세요(1~49)=");
		int odd = sc.nextInt();
		if(odd%2==0){
			odd++;
		}
		char ch = 'A';
		for (int i =1; i<=odd ;i+=2 ){
			//공백처리
			for (int j =1;j<=(odd-i)/2 ;j++ ){
				System.out.print(" ");
			}
			//1줄 문자 출력
			for (int k=1;k<=i ;k++ ){
				System.out.print(ch++);
				if (ch>'Z'){
					ch='A';
				}
			}
			System.out.println();
		}
		//-====================================================
		for (int i = odd-2 ;i>0 ;i-=2 ){
			//공백처리
			for (int j = 1; j<=(odd-i)/2;j++ ){
				System.out.print(" ");
			}
			//1줄문자
			for (int k =1;k<=i ;k++ ){
				System.out.print(ch++);
				if (ch>'Z'){
					ch='A';
				}
			}
			System.out.println();
		}

	}
}
