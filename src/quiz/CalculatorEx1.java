package quiz;

import java.util.Scanner;

public class CalculatorEx1 {
	// 더하기
	public static void plus() {
		Scanner scanPlus = new Scanner(System.in);
		System.out.print(">");
		int num1 = scanPlus.nextInt();
		System.out.print(">");
		int num2 = scanPlus.nextInt();
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
	}
	// 빼기
	public static void minus() {
		Scanner typeNum = new Scanner(System.in);
		System.out.print(">");
		int type1 = typeNum.nextInt();
		System.out.print(">");
		int type2 = typeNum.nextInt();
		System.out.println(type1+" - "+type2+" = "+(type1-type2));
	}
	// 곱하기
	public static void multiplication() {
		Scanner typeNum = new Scanner(System.in);
		System.out.print(">");
		int type1 = typeNum.nextInt();
		System.out.print(">");
		int type2 = typeNum.nextInt();
		System.out.println(type1+" x "+type2+" = "+(type1*type2));
	}
	// 나누기
	public static void division() {
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
	
	public static void main(String[] args) {
		// 계산기 구현
		out : while (true){			// 계산기의 반복, out을 통해 0을 입력하면 탈출
			// 메뉴 구성
			System.out.println("[계산 프로그램]");
			System.out.println("1. 더하기 \n2. 빼기 \n3. 곱하기 \n4. 나누기 \n0. 종료");
			System.out.print(">");
			
			// 입력값 받기
			Scanner selectMenu = new Scanner(System.in);
			int menu = selectMenu.nextInt();
			
			switch(menu) {
				case 1 -> {
					System.out.println("[더하기 계산을 합니다.]");
					plus();
				}
				case 2 -> {
					System.out.println("[빼기 계산을 합니다.]");
					minus();
				}
				case 3 -> {		
					System.out.println("[곱하기 계산을 합니다.]");
					multiplication();
				}
				case 4 -> {
					System.out.println("[나누기 계산을 합니다.]");
					division();
				}
				case 0 -> {
					System.out.println("[계산기를 종료합니다.]");
					break out;
				}
				default -> System.out.println("[잘못된 메뉴 선택.]");
			}
		}
	}
}
		