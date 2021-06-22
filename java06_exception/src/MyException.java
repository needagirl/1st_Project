// 1. 예외 클래스 생성시 반드시 Exception클래스를 상속받아 만든다.
public class MyException extends Exception{
		
	public MyException() {
		super("1~100사이의 값이여야 합니다.");
	}
	public MyException(String message) {
		super(message);
	}

}
