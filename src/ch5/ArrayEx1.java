package ch5;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 배열 : 같은 타입의 변수를 한번에 여러 개 선언하는 방법
		 * 배열 선언 방법
		 * 1. 타입명[] 변수명 = new 타입명[배열의 길이];
		 * 2. 타입명[] 변수명 = { 데이터들 };					//데이터는 ","로 구분
		 * 3. 타입명[] 변수명 = new 타입명[]{ 데이터들 };
		 */

		int[] numbers = new int[10];		// 정수형 변수 10개를 가진 배열
//		int는 0으로 초기화 됨('int (변수명)'= 0' 10개)
		boolean[] win = { true, false, true, false, false, true };
		String[] welcome = new String[] {"오늘 날씨는 괜찮네요", "오세요! 학원으로", "환영합니다"};
		
		// 배열값 사용하기
		// 변수명[인덱스*]로 접근			*인덱스 - 위치값을 의미함
		System.out.println(welcome[0]);
		System.out.println(welcome[1]);
		System.out.println(welcome[2]);
		
		// 배열값 사용하기
		// 변수명[인덱스*]로 접근			*인덱스 - 위치값을 의미함
		System.out.println(welcome[0]);
		System.out.println(welcome[1]);
		System.out.println(welcome[2]);
		
		// 배열의 길이 알아오기
		// 배열.length : 배열의 길이 값이 저장되어 있음
		System.out.println("win[]의 길이 : "+win.length);			// 길이 : 6
		System.out.println("welcome[]의 길이 : "+welcome.length);	// 길이 : 3		즉, {데이터}의 개수
		
		// 배열과 반복문
		for (int i = 0; i < win.length; i++) {
			if(win[i]) {
				System.out.println(i+1+"번째 전적 : 승리");
			}else {
				System.out.println(i+1+"번째 전적 : 패배");
			}
		}
		
		// 배열의 내용 출력
		System.out.println(win);
		System.out.println(numbers);
		System.out.println(welcome);						// 배열의 내용이 출력되지 않음
		// Arrays.toString()을 통해서 배열 내용을 출력
		System.out.println(Arrays.toString(win));
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(welcome));
		
		// 배열 선언 시 자동적으로 기본값으로 초기화 한다
		// (초기화 값이 없는 경우)
		// 초기화 기본값
		//	정수 : 0
		//	실수
		// 	boolean : false
		//	참조형(reference) : null
		String[] byeMessage = new String[10];
		System.out.println(Arrays.toString(byeMessage));	// 출력 결과 : null, null, null...
		
		// 배열의 얕은 복사(swallow copy)와 깊은 복사(deep copy)
		String[] byeMessage2 = new String[] {"good bye", "bye bye", "see you"};
		
		// 얕은 복사(swallow copy)		-> 참조 객체 주소를 복사
//		byeMessage = byeMessage2;
//		
//		System.out.println(byeMessage);
//		System.out.println(byeMessage2);
//		System.out.println(Arrays.toString(byeMessage));
//		
//		byeMessage2[1] = "bye bye bye는 조금...";
//		System.out.println(Arrays.toString(byeMessage));
//		System.out.println(Arrays.toString(byeMessage2));
		
		// 깊은 복사(deep copy)		-> 배열의 주소가 아닌 값 그 자체를 복사
		// 사용법 : System.arraycopy(src, srcPos, dest, destPos, length)
		// 	- src : 원본 배열의 이름
		//	- srcPos : 원본 배열에 복사를 시작할 위치
		// 	- dest : 복사 붙여넣기 할 배열의 이름
		//	- destPos : 붙여넣기 할 배열의 시작 위치를 지정
		//	- length : 복사할 개수
		System.arraycopy(byeMessage2, 1, byeMessage, 5, 2);
//		'byeMessage2의 1번부터 복사를 시작해서 byeMessage의 5번째부터 2개 붙여넣겠습니다.'
		System.out.println(Arrays.toString(byeMessage));
		System.out.println(Arrays.toString(byeMessage2));
//		[null, null, null, null, null, bye bye, see you, null, null, null]
//										  5		   6
//		[good bye, bye bye, see you]
//			0		  1		   2
		System.out.println("byeMessage의 0번째를 Good bye!로 바꾼다");
		byeMessage[0] = "Good bye!";
		System.out.println(Arrays.toString(byeMessage));
		System.out.println(Arrays.toString(byeMessage2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

