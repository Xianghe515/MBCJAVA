package ch6;

public class FinalEx {
// final을 사용하면 변수를 상수화 처리 (변수에 변경이 일어나지 않는다 -> 상수화)
	public static void main(String[] args) {
		// final 테스트
		Person hong = new Person("11111-11111", "홍길동");
		// nation, ssn -> final로 설정되어 있음
		hong.name = "홍두께";
//		hong.nation = "율도국";	
//		hong.ssn = "00001111";		// nation과 ssn은 final로 선언 -> 변경 불가
		System.out.println("["+hong.name+", "+hong.nation+", "+hong.ssn+"]");
	}

}

class Person {
	// final 테스트를 위한 클래스
	// final 초기화 방법 1. 필드 선언 시 초기화, 2. 생성자를 이용한 초기화
	// 필드(멤버 변수)
	final String nation = "한국";		// 필드 선언 시 초기화
	final String ssn;		// *The blank final field ssn may not have been initialized	
	String name;

	public Person(String ssn, String name) {		// -> 2. 생성자를 만들어 초기화 시킴
		this.ssn = ssn;
		this.name = name;
	}
}