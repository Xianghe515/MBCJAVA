package ch14;

public class DaemonThreadEx {
	
	// 데몬 스레드는 혼자서 작동할 수 없는 보조 스레드
	// 주 스레드가 정지하면 함께 정지함
	
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);		// setDaemon : 데몬 스레드로 설정 	*데몬 스레드는 주 스레드가 아님, 현재 주 스레드는 메인 스레드
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("메인 스레드 종료");
		// 메인 스레드가 종료되면 데몬 스레드도 함께 종료하며 출력되던 "저장 완료" 멈춤
	}

}

class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("저장 완료");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}