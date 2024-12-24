package ch9;

// Local class : 클래스 내 메소드에서 생성되는 클래스


public class LocalClassEx1 {

	public static void main(String[] args) {
		// LocalA1 객체 생성
		LocalA1 localA1 = new LocalA1();
		
		// LocalA1에 있는 메소드 호출
		localA1.useLocalB1();
		
		// LocalA2에 있는 메소드 호출
		LocalA2 localA2 = new LocalA2();
		
		localA2.method1(0);

	}

}


class LocalA {
	// 필드
	
	// 생성자
	public LocalA() {				
		// 로컬 클래스 선언
		class LocalB {}			
		// 로컬 객체 생성
		LocalB b = new LocalB();
	}
	// 메소드
	void method() {
		// 로컬 클래스 선언
		class LocalB {}
		// 로컬 객체 생성
		LocalB b = new LocalB();
	}
	
}

class LocalA1 {
	// 필드
	// 생성자
	// 메소드
	void useLocalB1() {		// 로컬 클래스는 메소드 내에서 선언되어 사용
		// 로컬 클래스
		class LocalB1{
			// 필드
			int field1 = 1;
			static int field2 = 2;
			// 생성자
			LocalB1() {
				System.out.println("LocalB1 생성자 실행");
			}
			// 메소드
			void method1() {
				System.out.println("LocalB1 메소드1 실행");
			}
			
			static void method2() {
				System.out.println("LocalB2 메소드2 실행");
			}
			
		}
		
		LocalB1 localB1 = new LocalB1();
		System.out.println(localB1.field1);
		localB1.method1();
		System.out.println(localB1.field2);
		LocalB1.method2();
		
	}
	
}

class LocalA2 {
	public void method1(int arg) {		// final int arg
		// 로컬 변수
		int var1 = 1;					// final int var1 = 1;
		
		// 로컬 클래스
		class LocalB2 {
			// 메소드
			void method2() {
				// 로컬 변수 읽기
				System.out.println("arg : "+ arg);
				System.out.println("var : "+ var1);
				
				// 로컬 변수 수정
//				arg = 2;
//				var1 = 2;
			}
		}
		
		// 로컬 클래스 객체 생성
		LocalB2 localB2 = new LocalB2();
		// 로컬 클래스 객체 메소드 호출
		localB2.method2();
		
		// 변수 수정
//		arg = 3;
//		var1 = 3;
//		* 즉, 로컬 클래스 내 변수는 final 처리 -> 안정적	
	}
}





