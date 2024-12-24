package quizzz123;

import java.util.Scanner;

public class Q_12NOTYET {

	public static void main(String[] args) {
		// 1. 정수를입력받으세요.
//		 2. For문을 이용하여 입력받은수가소수인지판별하세요.
//		 3. 힌트) 소수는 나누어 떨어지는 수가 2개이다.
		System.out.println("정수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for (int i=1;i<=a;i++) {
			// a를 i로 나누었을 때 나머지가 0이 되는 경우가 2개 뿐일 때
			if (a%i != 0) System.out.println();
		}
		}
}