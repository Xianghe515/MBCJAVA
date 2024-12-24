package ch7.obj;

public class InterFacePolyEx1 {

	public static void main(String[] args) {
		// 자동차 객체 생성
		Car myCar = new Car();
		
		// run 메소드 실행
		myCar.run();
		
		// 타이어 교체(다형성)
		myCar.tire1 = new KumhoTire();
		myCar.tire2 = new KumhoTire();
		
		// run 메소드 실행
		myCar.run();

	}

}



interface Tire {
	// 추상 메소드
	void roll();
}

class HankookTire implements Tire {
	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");
		
	}
}

class KumhoTire implements Tire {
	@Override
	public void roll() {
		System.out.println("금호 타이어가 굴러갑니다.");
		
	}
}

class Car {
	// 필드
	Tire tire1 = new HankookTire();
	Tire tire2 = new KumhoTire();
	
	// 메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
}






