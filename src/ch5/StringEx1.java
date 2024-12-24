package ch5;

import java.util.Arrays;

public class StringEx1 {

	public static void main(String[] args) {
		// String : 문자열 생성
		String f;	// String 타입의 변수 f를 선언
		f = "黙れ"; 	// f 변수에 문자열을 대입
		String hobby = "여행";	// String 타입 변수 hobby에 선언 후 문자열 대입
		// f, hobby 라는 스택 안에 黙れ와 여행이라는 각각의 힙 메모리가 들어 있고 각각의 힙 메모리는 주소를 가지고 있음
		String test = hobby;
		System.out.println(test == hobby);				// 결과 : true
		String hobby2 = "여행";
		// 문자열 리터럴이 동일할 경우 String 객체를 공유
		System.out.println(hobby == hobby2);			// 결과 : true
		
		String hobby3 = new String("여행");	// hobby는 문자열 값 그 자체를 사용했다면, hobby2는 새로운 객체를 생성
		System.out.println(test == hobby3);				// 결과 : false
		// 문자열의 출력 결과 그 자체를 정확하게 비교하기 위해 equals()를 사용
		System.out.println(test.equals(hobby3));		// 결과 : true
		
		// 1. 변수명.charAt(index값) : 문자열 추출 
		String str = "농구하고 싶다!";
		//			  0 12 345 67
		System.out.println("2번 인덱스 값을 추출 : "+ str.charAt(2));	// 결과 : '구'
		
		// 2. 변수명.length() : 문자열에서 문자의 개수를 알고 싶은 경우
		System.out.println("문자열의 길이 : "+ str.length()); 			// 결과 : 8
		
		// 3. 변수명.indexOf() : 원하는 문자의 인덱스 값을 반환
		String str2 = "死ね、お前";
		int siNe = str2.indexOf("死ね");
		System.out.println("死ね는 str2의 몇 번째 인덱스 위치인가? : "+ siNe);
		int a = str.indexOf("싶다");
		
		// 4. 변수명.substring() : 문자열을 원하는 만큼 자름
		// 	- 변수명.substring(시작 index값) -> 해당 인덱스 이후 값을 잘라줌
		System.out.println(str.substring(3));		// 결과 : 고 싶다!
		System.out.println(str.substring(5));		// 결과 : 싶다!
		System.out.println(str.substring(6));		// 결과 : 다!
		// 	- 변수명.substring(시작 index, 끝 index) -> 해당 인덱스 범위에 있는 글자를 잘라줌
		System.out.println(str.substring(1, 8));	// 결과 : 구하고 싶다!
		
		// 5. 변수명.split() : 문자열을 원하는 기준(문자/문자열)으로 자름			*substring - 인덱스 값을 기준으로 자름
		str = "apple/banana/kiwi/lemon/orange";				// 원래 하나의 문자열이었지만
		String[] fruit = str.split("/");					// '/'를 기준으로 잘라 배열에 집어넣음
		System.out.println(Arrays.toString(fruit));
		// split()의 괄호 안에는 반드시 기준 문자 혹은 문자열 코드가 있어야함
		
		// 6. 변수명.contains() : 해당 문자가 문자열에 포함되어 있는지 여부를 확인	-> 포함되면 true, 그렇지 않으면 false
		if (str.contains("apple")) {
			System.out.println("과일에 사과가 있습니다");
		}else {
			System.out.println("과일에 사과가 없습니다");
		}
		
		// 7. 변수명.equals() : 문자열이 같은지 여부 확인
		
		// 8. 변수명.replace() : 원하는 문자를 치환
		//	- 사용법 : 변수명.replace(oldStr*, newStr**)		*바꾸기 위해 찾는 문자열	**바꿀 문자열
		str = "abcde@naver.com";
		str = str.replace("naver", "gmail");		// str의 naver를 gmail로 변경
		System.out.println(str);
		
		// 9. 변수명.lastIndexOf() : 해당 문자를 뒤에서부터 찾아 위치를 반환		*indexOf는 처음부터 찾음
		str = "abcd dcba";
		//	   012345678
		System.out.println("indexOf(\"d\") : " + str.indexOf('d')); 				// 앞에서부터 0123
		System.out.println("lastIndexOf(\"d\") : " + str.lastIndexOf('d'));			// 뒤에서부터 8765
		// 두 번째 d를 indexOf를 통해 확인하고 싶을 때
		System.out.println("indexOf(\"d\")의 두 번째 위치 : " + str.indexOf('d', 4)); 	// 4번 index부터 찾음
		// 인덱스 값이 -1인 경우 = 찾고자 하는 내용이 없음
		System.out.println("indexOf(\"d\")의 두 번째 위치 : " + str.indexOf('d', 6));	// 결과 : -1
		
		// indexOf()를 사용하여 모든 내용을 검색하는 방법
		str = "apple/kiwi/apple/orange/lemon";
		int idx = 0;
		idx = str.indexOf("apple");
		System.out.println("첫 번째 apple의 인덱스 값 : "+idx);		// 결과 : 0
		idx = str.indexOf("apple", idx+1);
		System.out.println("두 번째 apple의 인덱스 값 : "+idx);		// 결과 : 11
		idx = str.indexOf("apple", idx+1);
		System.out.println("세 번째 apple의 인덱스 값 : "+idx);		// 결과 : -1
		
		// 10. toUpperCase, toLowerCase : 영문자를 대문자 혹은 소문자로 변환
		// 변수명.toUpperCase() : 소문자 -> 대문자
		// 변수명.toLowerCase() : 대문자 -> 소문자
		String email = "abcd1234@NaVeR.CoM";
		str = "naver.com";
		System.out.println(email.contains(str));		// 결과 : false, 대문자와 소문자가 다르기 때문
		
		email = email.toLowerCase();
		System.out.println(email);						// abcd1234@NaVeR.CoM -> abcd1234@naver.com
		System.out.println(email.contains(str));		// 결과 : true
		
		// 11. trim : 문자열 바깥쪽 공백 제거
		String id_1 = "    abc   123 ";
		String id_2 = " abc   123    ";
		
		System.out.println("before1 : "+id_1);
		System.out.println("before2 : "+id_2);
		System.out.println("equals : "+ id_1.equals(id_2));		//공백도 문자열이기 때문에 false
		
		id_1 = id_1.trim();
		id_2 = id_2.trim();
		System.out.println("after1 : "+id_1);
		System.out.println("after2 : "+id_2);
		
		// 12. format : 서식 문자열을 이용하여 문자열을 만들어 반환
		str = String.format("현재 시각 : %d:%d:%d", 17,17,59);
		System.out.println(str);
		
		// 13. endsWith : 지정한 문자로 끝나는지 검사
		str = "오늘 할 일.html";
		
		if (str.endsWith(".txt")) {
			System.out.println("확장자가 올바른 텍스트 파일입니다.");
		}else if (str.endsWith(".html") || str.endsWith(".htm")){
			System.out.println("확장자가 웹페이지 파일입니다.");
		}else {
			System.out.println("텍스트 또는 웹페이지 파일이 아닙니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
