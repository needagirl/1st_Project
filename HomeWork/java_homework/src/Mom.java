public class Mom {
	String name = "홍길동";
	int age = 30;
	int weight = 65;

	Mom(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
}

class Sun extends Mom {
//	int lenght;
	Sun(String name, int age, int weihgt) {
		super(name, age, weihgt);
		}
	public static void main(String[] args) {
		Sun s = new Sun("이순신", 25, 80);
		System.out.println("이름 = " + s.name + "\n나이 = " + s.age + "\n몸무게 = " + s.weight);
	}
}
//
//public class Mom_SonEx {
//
//
//}
