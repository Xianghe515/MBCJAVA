package ch6;

public class ConstructorEx1 {
	/*
	 * Constructor(생성자) -> new를 통해 클래스의 인스턴스를 생성할 때 호출되는 것
	 * 클래스의 이름과 같은 이름을 지닌 메소드
	 * 클래스에 생성자를 정의하지 않으면 기본 생성자를 호출
	 * 기본 생성자는 "클래스명()"인 생성자
	 * 다른 생성자가 정의되어 있다면 정의된 생성자를 반드시 사용
	 * 일반 메소드는 반환값이 있을 수 있으나, 생성자는 반환값을 따로 지정할 필요 없음
	 */
	
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.brand);
		System.out.println(car1.wheel);
		System.out.println(car1.name);
		
		// 필드 초기화 생성자를 통한 인스턴스 생성
		Car car2 = new Car("미쉐린", 6, "BMW", "티코");
		System.out.println(car2.wheel);
		System.out.println(car2.brand);
		
		// 생성자 오버로딩 테스트
		Car car3 = new Car("niro", "KIA", "금호");
		System.out.println(car1.numOfWheel);		// 결과 = 0
		System.out.println(car1.wheel);
		System.out.println(car1.name);
	}

}

// Car 클래스
class Car {
	
	// 필드
	String wheel;			// 타이어 이름
	int numOfWheel;			// 타이어 개수
	String brand;			// 차 브랜드
	String name;			// 차 이름
	
	// 생성자 - 새로운 인스턴스를 생성할 때 가장 먼저 호출되기 때문에 값을 초기화하는 용도로 많이 사용됨
	public Car() {			// 기본 생성자 : 매개값을 받지 않는 인스턴스 생성자
		// Car() 인스턴스 생성 시 동작을 구현
		wheel = "금호";
		numOfWheel = 4;
		brand = "KIA";
		name = "K5";
	}
	
	// 필드(멤버 변수) 초기화 생성자
	Car(String wheel, int numOfWheel, String brand, String name) {
		// this : 현재 생성된 인스턴스 - 클래스의 변수(필드)와 매개변수의 이름이 같은 경우 클래스의 변수를 지칭하기 위해 사용
		this.wheel = wheel;
		this.numOfWheel = numOfWheel;
		this.brand = brand;
		this.name = name;
	}
	
	// 생성자 오버로딩*			*동일한 이름의 생성자 혹은 메소드의 매개변수를 달리하여 생성자 혹은 메소드를 여러 개 선언
	// 동일한 이름의 구동을 다양한 매개변수를 통해 구현하기 위해 사용
	// 매개변수의 타입, 개수, 선언된 순서가 같은 경우 -> 같은 생성자로 구분
	// └> 타입, 개수, 순서가 달라야 다른 오버로딩으로 인식
	Car(String name, String brand) {
		// this() 현재 인스턴스의 생성자를 가리킵니다.
		this("금호", 4, brand, name);
		

	}
	Car(String name, String brand, String wheel){
		this.name = name;
		this.brand = brand;
		this.wheel = wheel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 메소드
	void go() {
		System.out.println(name + "앞으로 이동합니다.");
	}
	void stop() {
		System.out.println(name + "정지");
	}
	
}