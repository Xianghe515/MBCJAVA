package ch14;

public class YieldEx {

	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("WorkThreadA");
		WorkThread workThreadB = new WorkThread("WorkThreadB");

		workThreadA.start();
		workThreadB.start();
		
		while(true) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {}
			workThreadA.work = false;
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {}
			workThreadA.work = true;
		}
	}

}

class WorkThread extends Thread {
	// 필드
	public boolean work = true;

	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				try {
					Thread.sleep(300);
					System.out.println(getName()+": 작업 처리");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Thread.yield();		// 양보(실행 ➜ 실행 대기 상태로 전환)
			}
		}
	}
}