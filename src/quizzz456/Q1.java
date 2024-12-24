package quizzz456;

public class Q1 {

	public static void main(String[] args) {
		
		Bread.info(500, "피자빵");
		Bread.info(1500, "딸기케잌");

	}

}

class Bread {
	int price;
	String name;
	
	
	public Bread(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}


	static void info(int price, String name) {
		System.out.println(price+"원");
		System.out.println(name);
	}
	
	
}