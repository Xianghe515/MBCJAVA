package ch12;

public class StringBuilderEx {

	public static void main(String[] args) {
		// StringBuilder는 String 클래스의 단점을 보완하기 위해서 사용하는 클래스
		StringBuilder data = new StringBuilder();
		System.out.println(data);
		data.append("DEF");	 // StringBuilder 객체 값을 더하기(문자열 맨 뒤에 추가됨)
		System.out.println(data);
		data.insert(0, "ABC");	// insert(index, 문자열) -> 인덱스 위치에 문자열을 추가
		System.out.println(data);
		data.delete(3, 4);	// delete(시작 index, 끝 index) -> 시작 인덱스부터 끝 인덱스 전까지 삭제
		System.out.println(data);
		
		String dataStr = data.toString();
		
		System.out.println(data);
		System.out.println("String 객체 출력 : "+dataStr);
		
		// String과 StringBuilder의 차이
		long start, end;
		start = System.nanoTime();
		
		String str = "A";
		for(int i=0; i<300000; i++) {
			str = str +"A";
		}
		
		end = System.nanoTime();
		System.out.println("String : "+(end-start)+"나노 초");	// 약 3.5초 이후 출력, 한 번 실행 해서 값이 바뀔 때마다 새로 만듦, 메모리 소모가 큼
		
		// StringBuilder를 사용한 경우
		start = System.nanoTime();
		
		StringBuilder sb = new StringBuilder("A");
		for(int i=0; i<300000; i++) {
			sb.append("A");
		}
		
		end = System.nanoTime();
		System.out.println("StringBuilder : \t"+(end-start)+"나노 초");	// 6508900나노 초
		
		// deleteCharAt(index) : 특정 인덱스 값만 삭제(글자 하나 삭제)
		// replace(start, end, "문자열) - 시작에서 끝 이전까지 문자열 교체
		// reverse() 반전
		
		
		
		
		
	}

}
