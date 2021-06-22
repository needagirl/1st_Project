
public class Sample {
	public static void main(String[] args) {
//		Ex o = new Ex();
		Test i = new Test();
		int n = 10;
		i.setX(n);
//		o.setY(i);
		System.out.println(i.getX());
	}

}
class Test{
	int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
}
//
//class Ex{
//	Test y = new Test();
//	public void setY(Test y) {
//		this.y = y;
//	}
//	public Test getY() {
//		return y;
//	}
//}