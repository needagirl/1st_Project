import java.util.Scanner;
class DoWhileEx 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		aaa:
		while(true){
			System.out.print("금액을 입력하세요.?");
			int money = sc.nextInt();
			int a =50000;
			int i = 1;
			while(money>0){
				int result = money/a;
				if(result!=0){
					if(a>=1000){
						System.out.printf("%d원=%d장\n",a,result);
					}else{
						System.out.printf("%d원=%d개\n",a,result);
					}
					money -= result*a;
				}
				if(i%2==1){
					a/=5;
				}else{
					a/=2;
				}
				i++;
			}
			while(true){
				System.out.print("다시하겠습니까(1.예, 2.아니오)?");
				int end = sc.nextInt();
				System.out.println();
				if (end==2)	{
					break aaa;
				}else if(end==1){
					continue aaa;
				}else{
					System.out.print("다시 입력해 주세요\n");
				}
			}
		}
	}
}

/*
실행
금액을 입력하세요.?126300
50000=2장
10000=2장
5000=1장
1000=1장
100=3개
다시하겠습니까(1.예, 2.아니오)?1

금액을 입력하세요.?5435
5000원=1장
100원=4개
10원=3개
1원=5개

다시하겠습니까(1.예, 2.아니오)?2
*/