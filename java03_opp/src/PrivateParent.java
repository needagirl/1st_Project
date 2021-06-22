
public class PrivateParent {
	//private 접근 제한자는 다른 클래스에서 객체를 통해서 접근할 수 없다.
	//        상속불가
	private int num = 200;
	public void output () {
		System.out.println(num);
		getData();
	}
	public PrivateParent() {
	}
	
	//객체를 통해서 접근불가
	// 상속 안함.
	private void getData() {
		System.out.println("번호="+num);
	}

}
