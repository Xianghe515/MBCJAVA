package ch14;


public class SynchronizedEx {

	public static void main(String[] args) {
		
		// Calculator 객체 생성
		Calculator calculator = new Calculator();
		
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
		

	}

}

class Calculator {
	// 필드
	private int memory;
	
	// getter
	public int getMemory() {
		return memory;
	}
	
	// setter
	public void setMemory1(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+": "+this.memory);
	}
	public void setMemory2(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName()+": "+this.memory);
	}
	

class User1Thread extends Thread {
	// 필드
	private Calculator calculator;
	
	// 생성자
	public User1Thread() {
		setName("User1Thread");
	}
	
	// setter 메소드
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory1(100);
		
	}
	
}
class User2Thread extends Thread {
	// 필드
	private Calculator calculator;
	
	// 생성자
	public User2Thread() {
		setName("User2Thread");
	}
	
	// setter 메소드
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory2(50);
		
	}
	
}
	
	
	






















}