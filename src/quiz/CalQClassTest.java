package quiz;

import java.util.Scanner;

public class CalQClassTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 1;
		CalQClass cal = new CalQClass();
		int x; int y;
		
		while (select != 0) {
		// 메뉴 선택에 따른 동작 구현
			// 메뉴
			System.out.println("[메뉴]");
			System.out.println("1. 더하기 \n2. 빼기 \n3. 곱하기 \n4. 나누기 \n0. 종료");
			System.out.print("[선택]>");
			select = sc.nextInt();
			System.out.println();
			sc.nextLine();
			
		switch (select) {
		case 1 ->  {
			System.out.println("[더하기]");
			System.out.print(">");
			x = sc.nextInt();
			System.out.print(">");
			y = sc.nextInt();
			System.out.println("[계산 결과] : "+cal.plus(x, y)+"\n"); 
		}
		case 2 ->  {
			System.out.println("[빼기]");
			System.out.print(">");
			x = sc.nextInt();
			System.out.print(">");
			y = sc.nextInt();
			System.out.println("[계산 결과] : "+cal.minus(x, y)+"\n");
		}
		case 3 ->  {
			System.out.println("[곱하기]");
			System.out.print(">");
			x = sc.nextInt();
			System.out.print(">");
			y = sc.nextInt();
			System.out.println("[계산 결과] : "+cal.multiplication(x, y)+"\n");
		}
		case 4 ->  {
			System.out.println("[나누기]");
			System.out.print(">");
			x = sc.nextInt();
			System.out.print(">");
			y = sc.nextInt();
			System.out.println("[계산 결과] : "+cal.division(x, y)+"\n");
		}
		case 0 ->  {
			System.out.println("[종료]");
		}
		default -> {
			System.out.println("[Error]"+"\n");
		}
		}
		
	}

}
}
