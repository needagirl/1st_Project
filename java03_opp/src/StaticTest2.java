
public class StaticTest2 {
	//static
	//	멤버변수의 데이터형 왼쪽 public static int a=100
	//					   static int b = 200;
	//	메소드의 반황형 왼쪽에 표기한다.
	//		public static void method(){}
	// 		static void method(){}
	//
	//멤버영역에 실행표기 할 수 없다.
	//static{}에는 실행문을 표기 할 수 있다.
	//static{}과 생성자메소드는 static이 먼저 실행된다.
	static {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	public StaticTest2() {
		System.out.println("StaticTest2()메소드 실행됨.");
		
	}
	public static void main(String[] args) {
		new StaticTest2();
	}
}
