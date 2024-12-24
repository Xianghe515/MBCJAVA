package quizzz123;

import java.util.Scanner;

public class Q_15 {

	public static void main(String[] args) {
		// 1.  
//		두수의더하기를맞추는문제를지속적으로출제하는프로그램입니다.
//		 2.  2가지의 정수를 1~100사이의 난수를 발생 시켜지속적으로문제를출제한후정답이면
//		정답카운트를+1 씩, 틀리면오답카운트를+1 씩올려주는프로그램을만드세요.
//		또한이프로그램은0 을입력받으면반복을중단(탈출) 합니다.
//		 ex) 27 + 84 = 
		
		Scanner sc = new Scanner(System.in);
		int up=0; int down=0;
		
		while(true) {
		System.out.println("-------------------");
		int a = (int)(Math.random()*100)+1;
		int b = (int)(Math.random()*100)+1;
		
		System.out.println(a +" + "+ b+ " = "+ "?");
		System.out.println("]문제를 그만 푸시려면 0을 입력하세요.] \n>");
		int i = sc.nextInt();
			
			if (i==(a+b)) {
				System.out.println("정답입니다!!");
				up+=1;
			}else if (i==0) {
				break;
			}else {
				System.out.println("틀렸는뎁쇼?");
				down+=1;
			}
			
		}
		
		System.out.println("프로그램을 종료합니다. \n----------------------- ");
		System.out.println("정답 횟수: "+up+"회\n"+"틀린 횟수: "+down+"회");
}
}