package ch6;

import java.util.Arrays;

public class MethodEx1 {
	// 메소드 : 클래스 행동 및 기능을 나타냄		* 다른 언어에서는 함수라고도 함
	// 									* JAVA에서는 클래스 내부에만 함수를 정의할 수 있기 때문에 메소드라는 용어 사용
	/*
	 * 특징
	 * 	- 어떤 단어(이름) 뒤에 ()가 붙음
	 * 	- 한번 만들어 두면 재사용 가능
	 * 	- 여러 기능을 묶어서 이름을 붙여 놓은 것을 의미
	 * 	- return을 통해 값을 반환할 수 있음
	 * 
	 * 		[접근 제한자][static][반환타입][메소드명](매개변수타입 매개변수명) {
	 * 			여러 기능 구현 코드들
	 * 		}
	 * 		접근 제한자 - public, default, protect, private...
	 * 		static - 생략 가능
	 * 		반환 타입 : 메소드가 모든 기능을 수행한 후 반환할값의 타입을 지정	(int, String... void*)	
	 * 										 *void : 공허, 허무 - 반환하지 않는다는 의미 ┘
	 * 		메소드명 : 메소드 호출을 위해 사용할 이름
	 * 		매개변수 : 메소드(함수) 호출 시 () 안에 함께 전달할 값을 받는 변수
	 * 		매개변수 타입 : 매개변수의 타입을 의미
	 * 
	 */
	
	// 로또 번호 생성하는 메소드	- 매개변수 X, 반환 타입 O
	static int[] getLottoNumber() {
		
		final int LOTTO_SIZE = 6;				// final : 상수 처리 - 한번 선언된 내용은 변경 불가
//		LOTTO_SIZE = 7;		* The final local variable LOTTO_SIZE cannot be assigned. 즉, 재정의할 수 없음
		int[] lotto = new int[LOTTO_SIZE];		// 6개의 int형 데이터를 가진 배열을 선언
		
		for (int i=0; i<LOTTO_SIZE; i++) {
			lotto[i] = (int)(Math.random()*45)+1;	// 1~45까지의 무작위 정수 생성하여 배열에 입력
			
			// 중복한 숫자가 나오는지 검증
			for (int j=0; j<i; j++) {
				if(lotto[j]==lotto[i]) {			
					i--;							// 중복이 있으면 저장공간 값을 줄여 다시 실행
					break;
					
				}
			}
		}
		// 함수의 실행 결과 반환
		return lotto;		
		
	}
	
	// 토끼 이모티콘 출력 내용을 createRabit() 메소드로 console하는 메소드 구현
	static void createRabit() {		// 반환값이 필요 없기 때문에 void
		System.out.println("=======================");
		System.out.println("\t /)/)");
		System.out.println("\t(   ..)");
		System.out.println("\t(   >♡");
		System.out.println("  Have a Good Time.");
		System.out.println("=======================");
	}
	
	// 메시지를 전달하면, 해당 메시지 "* * *" 값을 양쪽에 붙여주는 문자열을 만드는 메소드
	static String makeBanner(String msg) {			// 매개변수 O, 반환값 O
		return "* * *"+msg+"* * *";
	}
	
	
	
	
	// main method
	public static void main(String[] args) {
		// 중복 없이 6개의 숫자를 출력하는 함수
		System.out.println("=====로또 번호 출력=====");
		int[] lottoNum = getLottoNumber();				
		System.out.println(Arrays.toString(lottoNum));
		
		System.out.println();
		
		// 토끼 이모티콘 출력
		System.out.println("=====토끼 이모티콘=====");
		
		for (int i=0; i<10; i++) {	// 10번 반복
			createRabit();			// 메소드(함수) 호출
		}
		
		System.out.println("메시지 전달하면 \"* * *\" 값을 양쪽에 붙여줌");
		String result = makeBanner("알 림");
		System.out.println(result);
		System.out.println(makeBanner("오늘 할 일"));

	}

}
