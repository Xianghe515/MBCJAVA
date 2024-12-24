package quiz;

import java.util.Arrays;

public class ArrayQ2 {

	public static void main(String[] args) {
		// 1. 1000개 짜리 int형 배열을 생성한 후에 배열 요소에 모든 값을 1 ~ 100 사이의 무작위 숫자로 채워 출력
		int[] num = new int[1000];		// 1000개짜리 배열 생성
		
		for (int i = 0; i < num.length; i++) {				// num의 길이 만큼 반복
			num[i] = (int)(Math.random()*100)+1;			// 1~100 사이의 무작위 수 출력하여 num에 입력 
		}
		System.out.println(Arrays.toString(num));
		
		// 줄바꿈 출력
		for (int i=0; i < num.length; i++) {
			System.out.print(num[i]+" ");
			if (i % 10 == 0) {				// 열 번째마다
				System.out.println();		// 줄 바꿔주세요
			}
		}
		System.out.println("\n========================2번========================");
		
		// 2. 1000개의 랜덤 숫자들 중 각 숫자가 몇 번씩 나왔는지 세어 출력
		
		int[] cnt = new int[100];		//1~100 사이 숫자의 갯수를 저장할 공간을 선언
		
		// 1000개의 랜덤 값에서 1~100 숫자에 대한 개수 계산
		for (int j=1; j<=100; j++) {			// j는 1~100까지 숫자를 비교 계산하기 위한 값
			for (int i=0; i<num.length; i++) {	// 1000개의 저장 공간에서 검색
				if (j == num[i]) {				
					cnt[j-1]++;					// 개수 세기, cnt는 0번째부터 시작하고 j는 1부터 -> j-1
				}				
			}
		}		
		// 확인
		int check = 0;		
		for (int i=0; i<cnt.length;i++) {
			System.out.println(i+1 + "이 나온 횟수 : "+cnt[i]);
			check += cnt[i];		// 개수가 1000개인지 검증
		}
		System.out.println(check);
		
		
		
		
		
		
		
		
		
		
	}

}
