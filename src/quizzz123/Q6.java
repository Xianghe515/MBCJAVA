package quizzz123;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
//		1. 양의정수를입력받아짝수라면“x 는짝수입니다”  , 홀수라면“x는홀수입니다” 를출력하세요.
//		 2. 0이라면 “0입니다“
//		 3. 음수라면“음수입니다“  를출력하세요.
		
		System.out.print("정수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		if (a==0) {
			System.out.println("0입니다");
		}else if (a<0) {
			System.out.println("음수입니다.");
		}else if (a%2==0) {
			System.out.println(a+"은(는) 짝수입니다.");
		}else {
			System.out.println(a+"은(는) 홀수입니다.");
		}
	}
}