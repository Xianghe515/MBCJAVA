package quizzz123;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
//		 1. 정수2개를입력받으세요.
//		 2. 두수를비교해서 “x 가큰수입니다“ 를출력 , 같은수라면“같은수입니다“ 를출력하세요. 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 두 개를 입력하세요.");
		System.out.print(">");
		int a = sc.nextInt(); 
		System.out.print(">");
		int b = sc.nextInt();
		
		if (a>b) System.out.println(a+ "가 큰 수입니다.");
		else if(a<b) System.out.println(b+"가 큰 수입니다.");
		else System.out.println("같은 수 입니다.");
		
	

	}

}
