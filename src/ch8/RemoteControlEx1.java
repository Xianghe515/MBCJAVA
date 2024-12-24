package ch8;

public class RemoteControlEx1 {

	public static void main(String[] args) {
		// 인터페이스 기능 테스트
		RemoteControl rc;
		
		// 상수 테스트
		System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		// rc 변수에 Television 객체를 대입
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		// default 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		// rc 변수에 Audio 객체를 대입
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		// default 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
				
		// 정적 메소드 호출
		RemoteControl.changeBattery();
		
	}

}
