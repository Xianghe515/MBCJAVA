package ch6;

import ch6.obj.Super;

public class ModifierEx {
/*														    ┌ 변함 없이 고유함, 변경이나 위조가 없음
 * 접근 제한자 : 중요한 필드나 메소드가 외부로 노출되지 않도록 해서 객체의 무결성*을 유지하기 위해서 접근제한을 둘 때 사용
 * 종류 - public, protected, private, (default : 생략하는 경우)
 * 	- public - 제한 대상(사용 가능한 것들) : 클래스, 필드, 생성자, 메소드
 * 			 - 제한 범위 : 없음	(모두 접근 가능)
 * 	- protected - 제한 대상 : 필드, 생성자, 메소드
 * 			    - 제한 범위 : 같은 패키지에 존재하거나, 자식 객체만 접근이 가능
 * 	- private - 제한 대상 : 필드, 생성자, 메소드
 * 			  - 제한 범위 : 같은 클래스인 경우에만 접근 가능(즉, 객체 내부에서만 접근 가능)
 * 	- default(아무것도 입력하지 않고 생략한 경우)
 * 		- 제한 대상 : 클래스, 필드, 생성자, 메소드
 * 		- 제한 범위 : 같은 패키지인 경우에만 접근이 가능함
 */
	public static void main(String[] args) {
		// 접근 제한자 테스트
		System.out.println(" ***** Super를 참조 *****");
		// Super 객체 생성
		Super sup = new Super();
		System.out.println("num1 = "+sup.num1);
//						  "\tnum2 = "+sup.num2			 num2 - protected : 같은 패키지 이거나 상속 관계일 때
		System.out.println("num3 = "+sup.getNum3());	// num3 - private : 클래스 내부에서만 접근 가능, 패키지 내 public 메소드를 사용
//						  "\tnum4 = "+sup.Num4			// num4 - default : 같은 패키지여야 접근 가능
			
		System.out.println("\n ***** Sub를 참조 *****");
		Sub sub = new Sub();
		sub.print();
	}

}
// 자식 클래스
class Sub extends Super {		// class (상속 받을 클래스) exteds (상속할 클래스)
	
	private int num5 = 50;
	
	// 생성자에 대한 접근 제한
	// public : 모든 패키지에서 생성자 호출 가능 (누구든 객체를 만들 수 있다)
	// protected : 같은 패키지 혹은 부모자식 관계에서 생성자 호출 가능
	// default : 같은 패키지에서 생성자 호출 가능
	// private : 같은 클래스에서 생성자 호출 가능
	
	// 기본생성자
	Sub() {}
	
	
	//상속 관계에서의 접근 제한자 확인
	public void print() {
		System.out.println("Super num1 = "+num1);		// num1 - public : 제한x
		System.out.println("Super num2 = "+num2);		// num2 - protected : 같은 패키지, 상속
		// 									└ 상속 관계
//		System.out.println("Super num3 = "+num3);		// num3 - private : 클래스 내부
//		System.out.println("Super num3 = "+num4);		// num4 - default : 같은 패키지
		System.out.println("Sub num5 = "+num5);			// num5 - private : 클래스 내부
		
		
	}
	
}