import test.DefaultData;

public class ModifierTest {

	public ModifierTest() {
//		Lotto_OOP_Pro lotto = new Lotto_OOP_Pro();
//		lotto.lottoStart();

		DefaultData dd = new DefaultData();
		//객체명.멤버변수
//		System.out.println("이름="+dd.name);
		System.out.println("이름="+dd.getName());
//		System.out.println("tel="+dd.tel);
		
		DefaultData dd2 = new DefaultData("이순신","010-8888-8888");
		dd2.sum();
		DefaultData.sum();
//		DefaultData.getName();
	}
	
	public static void main(String[] args) {
		// 접근제한자
		// 클래스 : public, default(생략)
		// 생성자메소드, 메소드, 멤버변수 : public, protexted, default, private
		new ModifierTest();
	}

}
