import java.util.Scanner;
class DoWhileEx 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		aaa:
		while(true){
			System.out.print("�ݾ��� �Է��ϼ���.?");
			int money = sc.nextInt();
			int a =50000;
			int i = 1;
			while(money>0){
				int result = money/a;
				if(result!=0){
					if(a>=1000){
						System.out.printf("%d��=%d��\n",a,result);
					}else{
						System.out.printf("%d��=%d��\n",a,result);
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
				System.out.print("�ٽ��ϰڽ��ϱ�(1.��, 2.�ƴϿ�)?");
				int end = sc.nextInt();
				System.out.println();
				if (end==2)	{
					break aaa;
				}else if(end==1){
					continue aaa;
				}else{
					System.out.print("�ٽ� �Է��� �ּ���\n");
				}
			}
		}
	}
}

/*
����
�ݾ��� �Է��ϼ���.?126300
50000=2��
10000=2��
5000=1��
1000=1��
100=3��
�ٽ��ϰڽ��ϱ�(1.��, 2.�ƴϿ�)?1

�ݾ��� �Է��ϼ���.?5435
5000��=1��
100��=4��
10��=3��
1��=5��

�ٽ��ϰڽ��ϱ�(1.��, 2.�ƴϿ�)?2
*/