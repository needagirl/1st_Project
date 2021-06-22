
public class Car extends Object{
	int speed =0;
	final int SPEED_MAX = 180;
	final int SPEED_MIN = 0;
	String carName = "그렌져";
	
	public Car() {
		System.out.println("Car()생성자메소드 실행");
	}
	public Car(String carName) {
		this.carName = carName;
		System.out.println("Car(String carName)생성자메소드 실행");
	}
	
	public void speedUp() {
		speed +=1;
		if(speed>=SPEED_MAX) speed=SPEED_MAX;
		System.out.println("car.speedUp->speed="+speed);
	}
	public void speedDown() {
		speed-=1;
		if(speed<=SPEED_MIN) speed = SPEED_MIN;
		System.out.println("speedDown->speed="+speed);
	}
}
