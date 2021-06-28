
public class SubTest extends SuperTest{
	public int a = 8;
//	public SubTest(int a) {super(a);}
	public SubTest() {
//		this(10);
	}
	public void print() {
		this.a+=5;
		System.out.print("b ");
	}
	public static void main(String[] args) {
		SuperTest ob = new SubTest();
		ob.print();
		System.out.print(ob.a);
	}
}
