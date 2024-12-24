package ch8;

// 다중 인터페이스
public class SmartTv implements Searchable, RemoteControl {

	// Searchable 인터페이스의 추상 메소드
	@Override
	public void search(String url) {
		System.out.println(url+"을 검색합니다.");
		
	}

	// RemotControl 인터페이스의 추상 메소드
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
