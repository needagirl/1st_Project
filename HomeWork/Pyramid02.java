import java.util.Scanner;
class Pyramid02 
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
		int plus = 0;
		for (int i = 1;i<=odd ; i++){
			if (i<=odd/2+1){
				for (int j=1; j<=odd/2+1-i;j++){
				System.out.print("*");
				}
				for (int k=0;k<=i+(i-2) ;k++ ){
					System.out.printf("%c",ch++);
					plus +=1;
					if(ch>=91){
						ch = 'A';
					}
				}
			}else{
				for (int j=1;j<=i-odd/2 ;j++ ){
				System.out.print("*");
				}
				for (int l=1;l<=odd-2*(i-odd/2) ;l++ ){
					System.out.printf("%c",ch+plus);
					plus +=1;
					if(plus>=26){
					plus = 0;
					}
				}
			}

		System.out.println();	
		}
	}
}
