package ch14;

public class JoinEx {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
//		// sumThread가 계산을 하기도 전에 main()이 끝나버림
//		try {
//			Thread.sleep(1);		// main()에서 sleep()을 구동하여 잠시 기다려줌
//		} catch (InterruptedException e) {}
		
		try {
			// join() 메소드를 호출한 스레드는 처리가 끝날 때까지 일시 정지	
			// 		*여기서 join()을 호출한 스레드는? ➜ main()
			// main 스레드가 실행 대기 상태가 되려면, join() 메소드를 가진 스레드가 종료되어야 함
			// 		*join() 메소드를 가진 스레드는? sumThread
			sumThread.join();
		} catch (InterruptedException e) {}
		
		System.out.println("1~100 합 : "+sumThread.getSum());
	}

}

class SumThread extends Thread {
	// 필드
	private long sum;	// 총합

	// 생성자 생략(기본 생성자)
	
	// getter setter
	public long getSum() {return sum;}

	public void setSum(long sum) {this.sum = sum;}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
	}
}