package ch15;

import java.util.ArrayList;
import java.util.Arrays;

public class ListEx1 {

	// Java Collection : 자바가 기본적으로 제공하고 있는 자료구조들
	
	// List : 1) 순서가 있고, 2) 중복이 허용되는 배열과같은 자료구조
	// └크기가 자동으로 조절되는 형태
	
	public static void main(String[] args) {
		// ArrayList의 기본 사용법
		ArrayList list = new ArrayList();
		
		// add() : 리스트에 요소(element, item)를 추가
		list.add(30);
		list.add("홍길동");
		list.add("010-1234-5678");
		list.add("A");
		
		// add(index, element) : 인덱스 위치에 요소 값을 추가
		list.add(2, "abc1234@naver.com");
		// 중복 저장 가능
		list.add("홍길동");
		list.add("홍길동");
		System.out.println(list);
		
		// set : 원하는 위치에 요소를 추가(덮어쓰기)
		list.set(2, "defg5678@naver.com");
		System.out.println(list);
//		add는 추가하면 데이터가 뒤로 밀림, set은 덮어씌워서 수정함
		
		// get : 원하는 인덱스의 데이터를 가져옴
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
		// size : 리스트의 길이 반환
		System.out.println("ArrayList의 크기 : " + list.size());
		
		// indexOf : 데이터를 전달하면 해당 데이터의 인덱스를 반환. 못찾는 경우 -1
		System.out.println(list.indexOf("홍길동00"));
		
		// remove(index) : index 위치의 데이터를 삭제하고, 그 값을 반환
		// remove(Object) : 해당 데이터를 삭제하고 결과를 반환(true 혹은 false)
		System.out.println(list.remove(list.indexOf("홍길동")));
		System.out.println(list.remove("홍길동"));	// true -> 삭제가 되었음
		System.out.println(list.remove("홍길동"));
		System.out.println(list.remove("홍길동"));	// false -> 삭제가 안 되었음	*현재 삭제될 값이 없음
		
		// contains : 값을 포함하는지 여부 반환(true 혹은 false)
		list.add("홍길동");
		System.out.println(list.contains("홍길동"));
		
		// toString : 리스트를 문자열 형태로 변환
		System.out.println(list.toString());
		
		// toArray : 리스트를 배열로 변환
		Object[] arr = list.toArray();
		System.out.println("배열로 변환한 내용 : "+Arrays.toString(arr));
		
		// clear : 리스트를 초기화
		list.clear();
		System.out.println(list);
		
		
		
		
		
		
		
		
		
		
		
	}

}
