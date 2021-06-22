import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		
		// stack은 먼저 입력된 정보가 나중에 출력된다.(FILO:First in Last out)
		//queue : First in First out
		//push() : 입력,	 pop() : 출력
		stack.push("홍길동");
		stack.push("이산");
		stack.push("이태백");
		stack.push("장만덕");
		
		// empty() : stack객체가 있으면 false, 객체가 없을 때 true
		while(!stack.empty()) {
			String name = stack.pop();
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new StackTest();
	}

}
