package quizzz123;

import java.util.Scanner;

public class Q_11 {

	public static void main(String[] args) {
		// 1. 양수를입력받으세요.
//		 2. 입력 받은 수 에 해당하는 구구단을 출력하세요.
		
		System.out.print("구구단 단수를 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println("랜덤 구구단 "+a+"단");
		System.out.println("--------------------------");
		for(int i=1;i<10;i++) {
			System.out.println(a +"X"+ i+ "="+ (a*i));
		}
		
		
	}

}
