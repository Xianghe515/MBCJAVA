package ch6;

public class ClassEx1 {

	public static void main(String[] args) {
		/*
		 * 객체 지향 프로그래밍(OOP, Object Oriented Programming)
		 * 객체(Object) : 사물, 추상적인 것들을 포함한 세상에 존재하는 모든 것들
		 * 	- 세상에 존재하는 모든 것들은 변수(필드, 속성)과 메소드(기능, 동작)으로 표현이 가능함
		 * 	- 메소드는 객체의 행동 및 기능을 나타내고, 변수는 상태(설정값)를 나타냄
		 * 클래스(Class) : 객체를 프로그래밍 언어로 표현한 것, 객체의 설계도
		 * 	- 인스턴스 : 클래스를 통해 만드는 하나의 실제 객체
		 * 	- 클래스의 메소드는 객체의 행동, 클래스의 변수는 객체의 현재 상태를 나타냄
		 * 	- 클래스는 참조형 변수 타입
		 * 
		 * 메소드
		 * 	- 타입
		 * 		1. 매개값이 있고, 반환값이 있는 경우
		 *  	2. 매개값이 있고, 반환값이 없는 경우
		 *  	3. 매개값이 없고, 반환값이 있는 경우
		 *  	4. 매개값이 없고, 반환값이 없는 경우
		 *  - 구조
		 *  	[접근제한자][반환 타입][메소드명](매개 변수들...) {
		 *  		메소드 동작 코드...
		 * 		 }
		 * 		- 반환값은 return 키워드를 사용하고 반환값을 지정
		 * 
		 * 
		 * JAVA 클래스의 규칙들
		 * 	- public class
		 * 		- 파일 이름과 같아야 함
		 * 		- 한 파일 내에서 한 개만 존재할 수 있음
		 * 		- 같은 패키지 내에서는 같은 이름의 클래스 사용 불가
		 * 		- 다른 패키지에서 import 할 때는 public class에만 접근할 수 있음
		 * 		- 파일의 이름이기 때문에 그 소스 파일 전체의 주제를 알 수 있는 이름을 부여하는 것이 좋음
		 * 		- 클래스의 이름은 대문자로 시작하는 것이 좋음
		 */

		// 학생이라는 인스턴스 객체 생성
		Student s1 = new Student();				// new - 객체 생성 연산자
		Student s2 = new Student();
//				└ 인스턴스 변수
		
		// 클래스 타입의 배열도 생성 가능		* 초기화값 - int=0, double=0.0, boolean=false, 참조타입=null
		Student[] kids = new Student[100];		// kids라는 배열은 Student 인스턴스 100개짜리 배열
		
		for (int i=0;i<kids.length;i++) {
			kids[i] = new Student();							// 객체 생성 후 배열에 저장
			kids[i].name = "default name "+(i+1);				// 생성 객체 속성값 정의
			System.out.println(i+1+"번째 학생의 이름 : "+kids[i].name);
		}
		// 값 꺼내기
		Student s50 = kids[50];
		s50.name = "51번째 학생의 이름입니다";
		System.out.println(s50.name);
		
		for (int i=0; i<kids.length; i++) {
			System.out.println(i+1 + "번째 학생의 이름 : " + kids[i].name);
		}
		
		s1.kor = 100;
		s1.math = 70;
		s1.eng = 90;
		s1.his = 95;
		s1.name = "홍길동";
		
		System.out.println(s1);				// 결과 : ch6.Student@2f8f5f62	- 참조 타입임을 알 수 있음
		System.out.println(s1.kor);			// 결과 : 100
		System.out.println(s1.his);			// 결과 : 95
		System.out.println(s1.getTotal());	// 결과 : 355
		System.out.println(s1.getName());	// 결과 : 홍길동
	}
}

// Student 클래스 정의
class Student {		// 학생이라는 클래스 선언
	
	// 필드(= 멤버변수 = 속성...)
	public String name;		// 이름
	public int age;			// 나이
			// 과목
	public int kor;			// 국어
	public int eng;			// 영어
	public int pro;			// 프로그램
	public int his;			// 역사
	public int math;		// 수학
			// 과목별 점수 총점
//	[접근제한자][반환 타입][메소드명](매개 변수들...) {
	public    int     getTotal () {				// 메소드
		return eng+his+kor+math+pro;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	
	
	
	
	
	
	
	
}


















