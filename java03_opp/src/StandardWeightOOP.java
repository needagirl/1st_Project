import java.util.Scanner;

public class StandardWeightOOP {
	double data[] = new double[4];
	double sWeight;
	double swi;
	String swiRating = "";

	public StandardWeightOOP() {}

	// 입력
	void input() {
		Scanner sc = new Scanner(System.in);
		String[] sub = { "나이", "성별(1:남성, 2:여성)", "키", "현재체중" };
		for (int i = 0; i < data.length; i++) {
			System.out.print(sub[i] + "=");
			data[i] = sc.nextDouble();
		}
	}

	// 표준체중
	void standardWeight() {
		double idx = 0.90;
		if (data[0] <= 35 && data[1] == 2) {
			idx = 0.85;
		} else if (data[0] >= 36 && data[1] == 1) {
			idx = 0.95;
		}
		sWeight = (data[2] - 100) * idx;
	}

	// 표준체중 지수
	void swiRating() {
		swi = (data[3] / sWeight) * 100;
		if (swi <= 85) {swiRating = "마른형";
		} else if (swi <= 95) {	swiRating = "조금마른형";
		} else if (swi <= 115) {swiRating = "표준형";
		} else if (swi <= 125) {swiRating = "조금비만형";
		} else {swiRating = "비만형";
		}
	}

	// 출력
	void output() {
		System.out.printf("표준체중 = %d\n", (int) sWeight);
		System.out.printf("당신은 표준체중지수는 %4.2f으로 %s입니다.\n", swi, swiRating);
	}

	void start() {
		input();
		standardWeight();
		swiRating();
		output();
	}
	public static void main(String[] args) {
		StandardWeightOOP sw = new StandardWeightOOP();
		sw.start();
	}
}
