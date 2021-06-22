class Variable //클래스는 대문자로 시작하고 합성어 일때는 각 단어의 첫번째 문자를 대문자로 한다. 
				//256글자까지 가능하다.
{
	public static void main(String[] args) 
	{
		//변수란 : 값 또는 데이터를 보관하는 기능을 가짐
		//	국어 50점, 영어 80점, 수학 70점
		// 기본데이터 형 : 정수형 int, byte, short, long
		//			실수형 float(4byte), double(8byte)
		//			논리 boolean (1byte)
		//			문자 char(2byte)
		
		//			레퍼런스형

		//byte kor = 50; // 1byte
		int kor2 = 50; // 4byte 정수형 상수는 int형이다.
		int eng = 80;
		int math = 70;
		// 변수 생성 규칙
		//  첫번째 글자는 영문소문자로 시작 or _ or $ 로 가능  // 특수문자, 숫자로 시작 못함
		//  합성어 일때는 두번째 이후 단어는 대문자로 한다.
		//  명령어(예약어)를 변수로 사용할 수 없다.
		//		예제)
		//		name, _name, $name 가능
		//		9name, *name, if(예약어)
		
		// 계산
		//	연산자 : +, -, *, /, %(나머지)

		int sum = kor2 + eng + math; //200
		double aver = sum / 3.0; // 실수의 기본 데이터 타입은 double 31.4
		// 정수, 실수 = 정수
		// 정수, 실수 = 실수
		// 실수, 정수 = 실수
		// 실수, 실수 = 실수
		
		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + aver);

		boolean state = true; // true, false (1byte)
		System.out.println(state);
		
		char lastName = '홍';
		String firstName = "길동";
		System.out.println(lastName + firstName);
		
		// 형변환
		
		float data = (float)3532.4352;
		int data2 = (int)3532.4352;
		System.out.println(data);
		System.out.println(data2);
		// 큰 데이터형의 데이터를 작은 데이터혀으이 변수에 대입할 때는 형변환을 하면 된다.
		// 작은 데이터형의 데이터를 큰 데이터형의 변수 대입할 때는 형변환 하지 않아도 된다.
		double data3 = 1234567;
		System.out.println(data3);
	}
}
