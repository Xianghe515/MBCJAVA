package quizzz123;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
//		 1. 메뉴를보여준후, Scanner로 해당 메뉴를 입력 받으세요.
//		 2. 없는메뉴라면“~은 메뉴에없습니다“ 를출력하세요.
//		 3. switch 구문을 이용하세요
		
		while (true) {
			System.out.print("구입할 메뉴는? \n [수박, 사과, 포도, 멜론, 귤] \n>");
			Scanner sc = new Scanner(System.in);
			String menu = sc.next();
			
			switch(menu) {
			case "수박" -> {System.out.println("수박의 가격은 2만 원입니다.");
			System.exit(0);}
			case "사과" -> {System.out.println("사과의 가격은 5천 원입니다."); 
			System.exit(0);}
			case "포도" -> {
				System.out.println("포도의 가격은 5천 원입니다.");
				System.exit(0);}
			case "멜론" -> {
				System.out.println("멜론의 가격은 9천 원입니다.");
				System.exit(0);}
			case "귤" -> {
				System.out.println("귤의 가격은 6천 원입니다.");
				System.exit(0);}
			default -> System.out.println(menu+"은(는) 메뉴에 없습니다. \n다시 선택해주세요");
		}
		}
}
}