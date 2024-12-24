package ch14;

import java.awt.Toolkit;

public class BeepPrintEx {

	public static void main(String[] args) {
//		// 스레드를 통해서 작업 진행
		
//		// Runnable()* 인터페이스를 이용해 익명객체를 생성자를 넘김		*구동과 관련된 인터페이스
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				for(int i=0;i<5;i++) {
//					toolkit.beep();
//					try {
//						Thread.sleep(500);		// 1000 = 1초
//					} catch (Exception e) {}
//				}
//			}
//		});
//		// 스레드 시작
//		thread.start();
		
//		//익명 객체를 직접 만듦
//		Thread thread2 = new Thread() {
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				for(int i=0;i<5;i++) {
//					toolkit.beep();
//					try {
//						Thread.sleep(500);		// 1000 = 1초
//					} catch (Exception e) {}
//				}
//			}
//		};
//		// 스레드 시작
//		thread2.start();
//		
		BeepWork beep = new BeepWork();
		beep.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}

class BeepWork extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);		// 1000 = 1초
			} catch (Exception e) {}
		}
	}
	
}



