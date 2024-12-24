package quizzz123;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		// 1. 수를 입력 받아(Scanner) 짝수, 홀수를 구분하여 출력 하세요.
//		 2. 3항 연산자를 이용하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int a = sc.nextInt();
		
		String B = (a%2==0)?"짝수":"홀수";
		
		System.out.println("입력 받은 수는 : " + B);
	}

}
