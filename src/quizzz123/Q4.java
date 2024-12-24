package quizzz123;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
//		1. 키(double) 와 나이(int) 를 입력 받으세요.
//		 2. 키가140 이상이고, 나이가 8세 이상이라면 “놀이기구 탑승가능“  아니라면, “놀이기구 탑승불가“ 를출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("키와 나이를 입력하세요.");
		System.out.print("키 : ");
		double height = sc.nextDouble();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		
		if (height > 140 && age >8) {
			System.out.println("놀이기구 탑승 가능");
		}else {
			System.out.println("놀이기구 탑승 불가");
		}
			
		
	}
}
