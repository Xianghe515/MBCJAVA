package quiz;

import java.util.Scanner;

public class Calculator {
	
	// 필드(멤버 변수) -> 더하기, 빼기, 곱하기, 나누기, 종료

	
	// 메소드 생성
	
	// 더하기
	public void plus() {
		Scanner scanPlus = new Scanner(System.in);
		System.out.print(">");
		int num1 = scanPlus.nextInt();
		System.out.print(">");
		int num2 = scanPlus.nextInt();
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
	}
	
	public int plusMethod(int x, int y) {
		return x+y; 
	}
	// 빼기
	public void minus() {
		Scanner typeNum = new Scanner(System.in);
		System.out.print(">");
		int type1 = typeNum.nextInt();
		System.out.print(">");
		int type2 = typeNum.nextInt();
		System.out.println(type1+" - "+type2+" = "+(type1-type2));
	}
	// 곱하기
	public void multiplication() {
		Scanner typeNum = new Scanner(System.in);
		System.out.print(">");
		int type1 = typeNum.nextInt();
		System.out.print(">");
		int type2 = typeNum.nextInt();
		System.out.println(type1+" x "+type2+" = "+(type1*type2));
	}
	// 나누기
	public void division() {
		Scanner typeNum = new Scanner(System.in);
		System.out.print(">");
		int type1 = typeNum.nextInt();
		System.out.print(">");
		int type2 = typeNum.nextInt();
		// 0으로 나누었을 때 처리
		if (type2==0) {
			System.out.println("Error");
			return;
		}
		System.out.println(type1+" ÷ "+type2+" = "+(type1/type2));
		System.out.println("나머지 : "+(type1%type2));		// 나머지
	}
}