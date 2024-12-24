package ch14;

public class InterruptEx {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		thread.interrupt();		// interrupt : 일시 정지 상태의 스레드에게 InterruptedException 발생 시킴
	}

}

class PrintThread2 extends Thread {
	@Override
	public void run() {
		// 방법1
//		try {
//			while(true) {
//				System.out.println("실행 중...");
//				Thread.sleep(100);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("InterruptedException 발생");
//		}
		// 방법2
		while(true) {
			System.out.println("실행 중...");
			if(Thread.interrupted()) {
				break;
			}
		}
		
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
		
	}
}