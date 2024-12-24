package ch6;

public class StaticEx2 {
	/*
	 * static initializer(정적 블록) - 정적 필드(멤버 변수)를 선언할 때 복잡한 초기화 작업이 필요한 경우 사용
	 * syntax>
	 * static {
	 * 		...
	 * }
	 *  - 생성자가 실행되기 전에 실행
	 *  - static 변수 초기화에 사용
	 *  - 객체를 여러 개 생성해도 한번만 실행(생성자와 다름)	*즉, 생성자가 만들어지는 것과 관계 없이 독립적으로 실행
	 *  - 정적 블럭이 클래스에서 여러 개 선언되어 있다면, 선언된 순서대로 실행
	 */
	
	public static void main(String[] args) {
		// StaticBlock 테스트 진행
//		System.out.println(StaticBlock.a);
//		System.out.println(StaticBlock.b);
		
		// static 블럭의 실행 확인
		StaticBlock s1 = new StaticBlock();		// 객체 생성
		System.out.println(s1);
		System.out.println(++StaticBlock.a);	// 결과 : 11
		System.out.println(++StaticBlock.b);	// 결과 : 21
		
		StaticBlock s2 = new StaticBlock();		// 객체 생성
		System.out.println(s2);
		System.out.println(++StaticBlock.a);	// 결과 : 12
		System.out.println(++StaticBlock.b); 	// 결과 : 22
		
	}

}

class StaticBlock {
	static int a;	// static 멤버 변수(클래스 멤버 변수)
	static int b;
	
	// 정적 블럭 사용
	static {
		a = 10;
		System.out.println("static block으로 static 변수(a)를 초기화");
	}
	static {
		b = a+10;
		System.out.println("static block으로 static 변수(b)를 초기화");
	}
	
	// 생성자
	public StaticBlock() {
		System.out.println("생성자가 호출되었습니다.");
	}
}