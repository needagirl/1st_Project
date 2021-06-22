import java.util.Scanner;

public class OOP_Ex01 {

	public OOP_Ex01() {
		int dan = danInput();
		String result = gugudan(dan);
		System.out.println(result);
		
		//System.out.println(gugudan(danInput()));
	}

	int danInput(){
		Scanner sc = new Scanner(System.in);

		System.out.print("단입력=");
		return sc.nextInt();
		}
	String gugudan(int dan) {
		String gugu = "";
		for (int i = 2; i < 9; i++) {
			gugu+=dan+"*"+i+"="+dan *i+"\n";
		}
		return gugu;
	}
	void start() {
		int dan = danInput();
		String result = gugudan(dan);
		System.out.println(result);
	}
	public static void main(String[] args) {
		OOP_Ex01 oop = new OOP_Ex01();
		//System.out.println(oop.gugudan(oop.danInput()));
		oop.start();
	}

}
/*콘솔에서 단을 입력받아 입력받은 구구단을 출력하라.
	단을 입력 //메소드 한개
	
	구구단을 출력 //메소드 한개
	
*/