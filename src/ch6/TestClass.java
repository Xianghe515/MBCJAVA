package ch6;

import ch6.obj.Bread;

public class TestClass {

	public static void main(String[] args) {
		// 생성된 클래스 테스트
		
		// 객체(instance) 생성
		Bread bread = new Bread();
		bread.price = 1000;
		bread.name = "식빵";
		
		bread.info();

	}
	
	static int price = 1500;
	static String name = "피자빵";
	static void info() {
		System.out.println(price+"원");
		System.out.println(name);
	}
}
