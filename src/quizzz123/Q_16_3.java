package quizzz123;

import java.util.Scanner;

public class Q_16_3 {

	public static void main(String[] args) {
		// 1. quiz16-2 에서 같은 카카오 친구가 있다면 입력 받을수없도록변경해보세요.
//		 2. 힌트: 저장하기 전, 입력 받은 name이 배열에 존재하는지 for문을 통해검색합니다.

		Scanner sc = new Scanner(System.in);
		String[] fr = new String[100];
		int i=0;
		
		while(true) {
			System.out.print("입력할 카카오친구>");
			String name = sc.next();
		
			if(name.equals("그만")) {
				break;
			}
			
			boolean bool = true;	// 배열에서 이름의 존재여부를 체크할 변수
			for(int j=0; j<fr.length; j++) {
				if(name.equals(fr[j])) {
					bool = false;
					break;
				}
			}
			
			if(bool) {
				fr[i] = name;
				i++;
				System.out.println(name + "입력 성공!");
				System.out.println("─────────────────────");
			}else {
				System.out.println("이미 입력된 친구입니다.");
				System.out.println("─────────────────────");
			}
			
		}
		System.out.println(i+"명의 카카오 친구가 입력 되었습니다.");
		sc.close();
	}
}