class ForTestBreak 
{	
	public static void main(String[] args) 
	{
		//�ݺ��� ����
		//break : �ݺ����� ����
		// continue : �ݺ����� �ѹ� �ǳʶٱ�

		// 1+2+3+4+5......
		// ���� 2021�� ���ʷ� �ʰ��ϴ� ��� ������ ���ؾ� �ϴ��� ���϶�.
		int result = 0;
		for (int i = 1; ;i++){
			result +=i;
			if (result>=2021){
				System.out.print("1~"+i+"������ ���� "+result+"\n");
				break;
			}
		}
		System.out.println("The End.....");
	}
}
