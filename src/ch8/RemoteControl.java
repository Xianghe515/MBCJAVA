package ch8;

/*
 * 리모콘 인터페이스 생성
 * 
 * public interface 인터페이스 이름 {
 * 		상수
 * 		추상 메소드...
 * }
 * 
 * 인터페이스
 * 	- abstract class와 유사하나 여러 개 상속 받을 수 있음(추상 클래스의 단점을 보완)
 * 	- 인터페이스에 포함된 메소드들은 모두 abstract 메소드, 기본값이 abstract(즉, 생략 가능)
 * 	- abstract class와 다르게 인스턴스 변수와 인스턴스 메소드를 만들 수 없음
 * 	- static 변수와 static 메소드는 사용 가능(자동으로 final이 됨)
 */


public interface RemoteControl {
	
	// 상수 필드 : 인터페이스 내에 필드 설정 -> 상수값이 됨
	int MAX_VOLUME = 10;	// public static final이 생략되어있음
	int MIN_VOLUME = 0;
	
	// 추상 메소드 -> 구현 측에서 반드시 재정의해서 사용
	// 1. 반환 타입, 2. 매개변수 타입과 개수를 지정, 3. 메소드 이름
	void turnOn();		// 추상 메소드임(abstract가 생략되어 있음)
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드 -> {}를 사용하여 코드 실행부분이 존재
	// 키워드로 default 사용, 상수 필드를 읽거나 추상 메소드를 호출하는 코드 작성 가능
	// mute 버튼 - 눌렀다 뗐다 -> boolean
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("음소거");
			setVolume(MIN_VOLUME);	// 위에 있는 추상 메소드 호출
		}else {
			System.out.println("음소거 해제");
		}
	}
	
	// static 메소드
	// 형식 : [public | private] static 리턴타입 메소드명(매개변수, ...) {...}
	// 선언 시 public 생략했다면, 자동으로 컴파일 과정 중에 public 붙게 됨
	// 실행부 작성 시에 상수 필드를 제외한 abstract 메소드, default 메소드, private 메소드 등을 호출할 수 없다.
	
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
