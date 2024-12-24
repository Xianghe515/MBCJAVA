package quiz;

import java.util.Arrays;

public class ArrayQ1 {

	public static void main(String[] args) {
		// 배열의 선언
		int[] lotto = new int[6];		// 정수 타입, 길이가 6인 배열의 선언
		// 검증 - 중복 없는 로또 번호 6개 뽑기
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int)(Math.random()*45)+1;	// 1~45 무작위 정수 출력
	
			for (int j = 0; j < i; j++) {			// 검색 알고리즘
				if (lotto[j] == lotto[i]) {
					i++;
					break;	
			}	
		}
		System.out.println(i+1 + "번째 번호"+Arrays.toString(lotto));
								
	}
	      
		int[] lotto2 = new int[6];
	      
	      int count = 0;
	      boolean testCheck = true;
	      while (count < 6) {
	         int lottoNum = (int)(Math.random() * 45) + 1;     // 생성
	         for (int i = 0; i < count; i ++) {                // 검증
	            if (lotto2[i] == lottoNum) {
	               testCheck = false;
	               break;
	            }
	         }
	         if (testCheck) {                        // 대입
	            lotto2[count] = lottoNum;
	            count++;
	         }
	         testCheck = true;                        // 검증 초기화
	      }
	      System.out.println("while을 사용한 경우"+Arrays.toString(lotto));
	}
}