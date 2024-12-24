package quizzz123;

import java.util.Scanner;

public class Q_16_2 {

	public static void main(String[] args) {
		// 1. Scanner생성하세요.  (크기가 100인 배열 선언)
//		 2. While문(무한 루프) 에서 “카카오 친구들“ 을 배열 순서에 입력 받으세요.
//		 3. “그만” 을 입력 받으면 탈출 합니다.

		Scanner sc = new Scanner(System.in);
		String[] fr = new String[100];
		int i=0;
		
		while (true) {
			System.out.print("입력할 카카오 친구>");
			fr[i] = sc.next();
			
				if (fr[i].equals("그만")) {
					System.out.println(i + "명의 친구가 입력되었습니다.");
				break;
				}
				System.out.println(fr[i]+"입력 성공");
				System.out.println("──────────────────────────────────");
			i++;
		}
	}

}
