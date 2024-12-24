package quizzz123;

import java.util.Arrays;
import java.util.Scanner;

public class Q_16_1 {

	public static void main(String[] args) {
		// . Scanner생성하세요.  (크기가 100인 배열 선언)
//		 2. While문(무한 루프) 에서 먹고 싶은 음식을 입력 받아 배열에저장하세요.
//		 3. “그만” 을 입력 받으면 탈출 합니다.
//		 4. For문을 통해 배열에 저장되어 있는음식을모두출력하세요.

		Scanner sc = new Scanner(System.in);
		String[] a = new String[100];
		System.out.println("# 먹고 싶은 음식을 입력하세요.");
		System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");
		int i=0;
		while(true) {
			System.out.print("> ");
			a[i]=sc.next();
			
				if(a[i].equals("그만")) {
					System.out.println("입력 종료");
					break;
				}
			
			i++;
		}
		//a를 출력
// 내가 쓴 것	ㅄ	System.out.println(Arrays.toString(a));
		System.out.print("내가 먹고 싶은 음식들 : [");
		for (int j=0; j<i; j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println("]");
	}

}