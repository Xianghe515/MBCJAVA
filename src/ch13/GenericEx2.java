package ch13;

public class GenericEx2 {
	
	// 선언부 타입이 여러 개인 경우
	
	public static void main(String[] args) {
		
		// getter, setter로
		// Product 객체 생성 - K를 Tv, M은 String
		Product<Tv, String> product1 = new Product<>();
		
		// setter 매개값 전달
		product1.setKind(new Tv());		// generic으로 지정된 값으로 처리
		product1.setModel("스마트 TV");
		// getter 리턴값은 Tv, String
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		// ─────────────────────────────────────────────
		
		// constuctor로
		Product<Car, String> product2 = new Product<>(new Car(), "SUV 자동차");
		
		// getter 리턴값은 Car, Stirng
		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println(car);
		System.out.println(carModel);
		
	}

}

class Product<K, M> {	// 관용적으로는 타입 지정 부분에 T를 씀
	// 필드
	private K kind;
	private M model;
	
	// 생성자
	public Product() {}		// 기본 생성자
	public Product(K kind, M model) {
		this.kind = kind;
		this.model = model;
	}
	
	// 메소드 getter, setter
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
}

class Car {}
class Tv {}