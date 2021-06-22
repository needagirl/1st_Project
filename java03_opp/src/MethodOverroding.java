import java.util.Iterator;

public class MethodOverroding {

	public MethodOverroding() {

	}
	//오버 로딩
	// 같은 클래스에서 메소드명이 같은 매소드가 여러개 존재할 때 오버로딩이라고 한다.
	// 매소드명과 반환형은 같고 매개변수의 갯수가 데이터형은 달라야 한다.
	int totalResult() {
//		1~100까지의 합을 구한다.
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			result+=i;
		}
		return result;
	}
	//1~max까지의 합을 구한다.
	int totalResult(int max) {
		int result = 0;
		for (int i = 1; i <= max; i++) {
			result+=i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MethodOverroding mo = new MethodOverroding();
		
		int r = mo.totalResult();//1~100까지의 합
		int rr = mo.totalResult(200);//1~200까지의 합
		System.out.println("1~100까지의 합은"+r);
		System.out.println("1~200까지의 합은"+rr);
		
		System.out.println(100);
		System.out.println(10.36);
		System.out.println('A');
	}

}
