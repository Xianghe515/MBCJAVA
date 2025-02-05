package ch8;

public class InterfacePolyEx2 {

	public static void main(String[] args) {
		// Driver 객체 생성
		Driver driver = new Driver();
		
		// Vehicle 구현 객체 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// 매개값으로구현 객체를 대입(다형성)
		driver.drive(bus);
		driver.drive(taxi);
		
	}

}

// interface
interface Vehicle {
	// 추상 메소드
	void run();
}

// Bus 클래스
class Bus implements Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
		
	}
}

// Taxi 클래스
class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
		
	}
}

// Driver 클래스
class Driver {
	void drive(Vehicle vehicle) {
		vehicle.run();
	}
}










