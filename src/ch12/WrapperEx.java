package ch12;

public class WrapperEx {



	public static void main(String[] args) {
		// boxing
		Integer obj = 100;	// int 값
//		System.out.println("value : "+obj.toString());
		System.out.println("value : "+obj.intValue()+100);
		
		// unboxing
		int value = obj;
		System.out.println("value : "+ value);
		
		// 연산 시 자동으로 unboxing
		int result = obj + 100;
		System.out.println("result : "+obj+100);
		
		// 문자열 값을 int 값으로 변환
		int test = Integer.parseInt("1000");
		System.out.println(test+100);	// 결과값 : 1100, 문자열이라면 1000100
		
		// 값 비교
		// -128~127 초과값인 경우, 값의 범위가 1byte 크기를 넘는 경우
		Integer obj1 =300;
		Integer obj2 = 300;
		System.out.println("== : "+(obj==obj2));	// 결과 : false, 객체이기 떄문
		System.out.println("equals : " + obj1.equals(obj2));
		
		// -128~127 범위 내의 값인 경우
		Integer obj3 = 30;
		Integer obj4 = 30;
		System.out.println("== : "+(obj3==obj4));	// 결과 : true
		System.out.println("equals : " + obj3.equals(obj4));
		
		// 객체를 비교할 때 equals()를 이용하여 비교하는 것이 좋음
	}

}
