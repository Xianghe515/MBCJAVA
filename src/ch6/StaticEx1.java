package ch6;

public class StaticEx1 {
	// static : 정적 멤버 변수(필드) 및 메소드
	// 정적 멤버 변수 -> 전역변수* 설정과 비슷함		
	// *전역변수 : 프로그램 전에 영향을 주는 변수 - 프로그램 시작과 동시에 선언되어 사용, 중간에 선언되어도 종료까지 사용됨
	// <-> 지역변수 : {}(블럭) 내에 선언되어지는 변수로, 블럭을 벗어나면 사라짐
	
	public static void main(String[] args) {
		// static 확인, Count 객체 생성
		Count c1 = new Count();		// 인스턴스 객체
		c1.a++;
		c1.b++;
		System.out.println("Non-static a : "+c1.a);		// 결과 : 0→ 1
		System.out.println("static b : "+c1.b);			// 결과 : 0→ 1
		
		Count c2 = new Count();		// 인스턴스 객체
		c2.a++;
		c2.b++;
		System.out.println("Non-static a : "+c2.a);		// 결과 : 1→ 1
		System.out.println("static b : "+c2.b);			// 결과 : 1→ 2	- 전역변수의 특징 이해 필요
//		시작과 동시에 만들어 놓음. 고정된(정적) 값으로 종료될 때까지 사용됨
		
		Count.b++;		//클래스 멤버로 접근
		System.out.println("c1.a : "+c1.a);				// 결과 : 1→ 1
		System.out.println("c2.a : "+c2.a);				// 결과 : 1→ 1
		System.out.println("Count.b : "+Count.b);		// 결과 : 2→ 3
		
		// static 메소드
		System.out.println("Count.doIt() : "+Count.doIt());		// 결과 : 1
		System.out.println("Count.doIt() : "+Count.doIt());		// 결과 : 1
		// return 값을 ++new Count().a;로 설정했기 때문에 계속해서 새롭게 만들어냄, 첫 번째와 두 번째의 주소가 다름
		// return 값이 ++b;라면? -> 값이 증가, 하나의 주소 안에서 값을 공유
	
	}

}

class Count {
	// 필드(멤버 변수)
	public int a = 0;			// 인스턴스 멤버 변수
	public static int b = 0;	// 클래스 멤버 변수(static 사용)
	
	// 메소드 doIt()
	public static int doIt() {
//		return ++a;		*Cannot make a static reference to the non-static field a
		return ++new Count().a;	// 인스턴스 생성 후 a라는 멤버 변수 참조
//		return ++b;		// static을 이용한 클래스 멤버 변수
	}
}