package test;

public class DefaultData {
	String name="홍길동";
	String tel="010-1234-5678";
	public DefaultData() {
		
	}
	public DefaultData(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public static void sum() {
		int tot = 0;
		for (int i = 0; i <=100; i++) {
			tot +=i;
		}
		System.out.println("tot="+tot);
	}
	public String getName() {
		return name;
	}
}
