package ch8;


// 리모콘 인터페이스의 구현체 클래스
public class Television implements RemoteControl {	// implements 키워드를 사용하여 구현 인터페이스를 지정
	
	// 필드
	private int volume;
	
	// 뮤트 시 저장될 volume값
	private int memoryVolume;
	
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
	
	// setVolume 추상 메소드 오버로드
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {		
			this.volume = RemoteControl.MAX_VOLUME;			// 맥스보다 볼륨이 커지지 않도록 설정
		}else if (volume <RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;		
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : "+ this.volume);
	}
	
	// default 메소드 재정의
	
	@Override
		public void setMute(boolean mute) {
			// 인터페이스에 있는 default 메소드 재정의
			if (mute) {
				this.memoryVolume = this.volume;
				System.out.println("음소거");
				setVolume(RemoteControl.MIN_VOLUME);
			}else {
				System.out.println("음소거 해제");
				setVolume(this.memoryVolume);
			}
		}
	
	
	
	
	
	
	
}