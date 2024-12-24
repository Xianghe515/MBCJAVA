package ch9;

public class AccessAuthEx {

	public static void main(String[] args) {
		// AccessB 테스트
		// 객체 생성
		AccessA accessA = new AccessA();
		AccessA.AccessB accessB1 = accessA.new AccessB();
		
		AccessA.AccessB accessB2 = new AccessA().new AccessB();		
		accessB2.method();

		// AccessC 테스트
		AccessA.AccessC accessC = new AccessA.AccessC();
		accessC.method();
	}

}

class AccessA {
	// AccessA 인스턴스 필드와 메소드
	int field1;
	void method1() {}
	
	// 정적 필드, 정적 메소드
	static int field2;
	static void method2() {}
	
	// 인스턴스 멤버 클래스
	class AccessB {
		void method() {
			// AccessA 인스턴스 필드와 메소드 사용
			field1 = 10;
			method1();
			// AccessA의 정적 필드와 메소드 사용
			field2 = 10;
			method2();
		}
	}
	
	// 정적 멤버 클래스
	static class AccessC {
		void method() {
			// AccessA 인스턴스 필드와 메소드 사용
//			field1 = 10;		
//			method1();			// 컴파일 에러
			// AccessA의 정적 필드와 메소드 사용
			field2 = 10;
			method2();			// static은 static 끼리만
		}
	}
	
	
}