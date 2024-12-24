package quizzz123;

import java.util.Scanner;

public class Q_15_1 {

	public static void main(String[] args) {
		// 1. 15번 문제가– 문제도 나올 수있도록변경해보세요.
		
		Scanner sc = new Scanner(System.in);
		int up=0; int down=0;
		
		while(true) {
		System.out.println("-------------------");
		int a = (int)(Math.random()*100)+1;
		int b = (int)(Math.random()*100)+1;
		
		int q = (int)(Math.random()*2);	// 	0이면 양수 문제로, 1이면 음수 문제로
		int correct;
		
		if(q==0) {		// 양수 문제
			System.out.println(a +" + "+ b+ " = "+ "?");
			correct = a+b;
			System.out.println("]문제를 그만 푸시려면 0을 입력하세요.] \n>");
			int i = sc.nextInt();
			if (i==correct) {
				System.out.println("정답입니다!!");
				up+=1;
			}else if (i==0) {
				break;
			}else {
				System.out.println("틀렸는뎁쇼?");
				down+=1;
			}
			
		}else {			// 음수 문제
			System.out.println(a +" - "+ b+ " = "+ "?");
			correct = a-b;
			System.out.println("]문제를 그만 푸시려면 0을 입력하세요.] \n>");
			int i = sc.nextInt();
			if (i==correct) {
				System.out.println("정답입니다!!");
				up+=1;
			}else if (i==0) {
				break;
			}else {
				System.out.println("틀렸는뎁쇼?");
				down+=1;
			}	
		}
		}
		System.out.println("프로그램을 종료합니다. \n----------------------- ");
		System.out.println("정답 횟수: "+up+"회\n"+"틀린 횟수: "+down+"회");
		
		
	}
}