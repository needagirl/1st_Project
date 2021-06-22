class ForTestContinue 
{
	public static void main(String[] args) 
	{
		for (int i = 1;i<10 ;i++ ){

			if (i%2==0){
				continue;
			}
			System.out.println(i);
		}
	}
}

//짝수를 넣을경우 홀수로 변경 if문으로 확인
//다이아몬드 안에 가장 긴 숫자
//z인경우 a로 시작
// 삼각형 2개로 나눠도 가능