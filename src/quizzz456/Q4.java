package quizzz456;

public class Q4 {

	public static void main(String[] args) {

		Account myAcc = new Account("홍길동", 1234, 3600);
		
		myAcc.deposit(0);
		myAcc.withDraw(3700);
		
		int bal = myAcc.getbalance();
		System.out.println(myAcc.name + "님의 계좌 잔액은: "+bal+"원입니다.");

	}

}

class Account {
	String name;
	int password;
	int balance;
	
	public Account(String name, int password, int balance) {
		super();
		this.name = name;
		this.password = password;
		this.balance = balance;
	}
	
	void deposit(int money) {
		balance+=money;
		
	}
	
	void withDraw(int money) {
		if(balance>=money) {
			balance-=money;
		}else {
			System.out.println("잔액 부족");
		}
		
	}
	
	int getbalance() {
		
		return balance;
	}
	
	
}