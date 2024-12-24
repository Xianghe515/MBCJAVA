package quizzz123;

import java.util.Scanner;

public class Q_16 {

	public static void main(String[] args) {
		// 1. Scanner를 이용하여 금액을 입력 받으세요.
//		 2. 음료수를 선택하면 금액에서 차감하세요. (반복문)
//		 3. 금액이 부족하다면 “금액이 부족합니다“ 를출력하세요.
//		 4. 4를 입력 받으면 반복문을종료하세요

		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액을 투입해주세요>");
		int a = sc.nextInt();
		
		while (true) {
		System.out.println("\n[남은 금액] : "+ a);
		System.out.println("[1]데미소다 : 400원, [2]밀키스 : 500원, [3]코카콜라 : 600, [4]잔돈 받기");
		System.out.print("[음료수 선택]>");
		int b = sc.nextInt();
			switch (b){
			case 1 -> {
				if(a >= 400) {
					System.out.println("[데미소다를 받았습니다.]");
					a-=400;
				}else System.out.println("[금액이 부족합니다.]");

				
			}
			
			case 2 -> {
				if(a >= 500) {
					System.out.println("[밀키스를 받았습니다.]");
					a-=500;
				}else System.out.println("[금액이 부족합니다.]");
				
			}
			case 3 -> {
				if(a >= 400) {
					System.out.println("[코카콜라를 받았습니다.]");
					a-=600;
				}else System.out.println("[금액이 부족합니다.]");
				
			}
			case 4 -> {
				System.out.println("[남은 금액] " + a +"[을 반환합니다.]");
				System.exit(0);
			}
			default -> {
				System.out.println("[잘못된 선택입니다.]");
			}
			}
		
		
		
		}
		
		
		
	}

}
