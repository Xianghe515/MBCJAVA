package quizzz123;

import java.util.Arrays;
import java.util.Scanner;

public class Q_16_4NOTYET {

	public static void main(String[] args) {
		//1. 배열을선언하고무지, 네오, 어피치, 라이언, 단무지 를 저장하세요.
//		 2. 검색할친구를입력받아, 검색할친구가있다면어디에있는지출력하세요.
//		 3. 검색한친구가없다면“~~는없습니다“ 를출력하세요.
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[] {"무지", "네오", "어피치", "라이언", "단무지"};
		System.out.println("현재 저장된 친구들"+Arrays.toString(arr));
		
		while(true) {
			System.out.print("검색할 카카오 친구 > ");
			String name = sc.next();
			
			if(name.equals("그만"))
				break;
			
			for (int i=0; i<arr.length; i++) {
				if(arr[i].equals(name)) {
					System.out.println(name+"은(는) ");
				}else
					System.out.println(name+"(이)라는 친구는 없습니다.");
				}
		}
			
			
	}
		
		
		
		
}
