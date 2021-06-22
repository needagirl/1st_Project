import java.util.Scanner;
class Pyramid 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("임의의 홀수입력(1~49)=");
		int odd = sc.nextInt();
		if (odd%2==0){
			odd+=1;
		}
		char ch = 'A';
		for (int i = 1;i<=odd/2+1 ;i++ ){
			for (int j=1; j<=odd/2+1-i;j++ ){
				System.out.print(" ");
			}
			for (int k=0;k<=i+(i-2) ;k++ ){
				System.out.printf("%c",ch++);
				if(ch>=91){
					ch = 'A';
				}
			}
			System.out.println();
		}
		for (int i = 1;i<=odd/2+1 ;i++ ){
			for (int j=1; j<=i;j++ ){
				System.out.print(" ");
			}
			for (int l=1;l<=odd-(i+i) ;l++ ){
				System.out.printf("%c",ch++);
				if(ch>=91){
					ch = 'A';
				}
			}
			System.out.println();
		}
		
	}
}
