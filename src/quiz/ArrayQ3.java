package quiz;

import java.util.Arrays;

public class ArrayQ3 {

	public static void main(String[] args) {
		// 다음 numArr의 값들의 총합과 평균을 구해서 출력
		int a = 0; 	// 개수
		int b = 0;	// 총합
		int[][] numArr = {
				{5, 5, 5, 5, 5}, 			// 1차원 배열의 0 인덱스
				{10, 10, 10, 10, 10},		// 1차원 배열의 1 인덱스
				{20, 20, 20},
				{30, 30, 30}
		};
		for (int i=0; i<numArr.length; i++) {				// 1차원 배열 개수만큼 반복
			a += numArr[i].length;
			for (int j=0; j<numArr[i].length; j++) {		// 2차원 배열 안에 있는 1차원 배열의 개수
				b += numArr[i][j];
			}
		}
		System.out.println("전체 합 : "+b);
		System.out.println("평균 : "+(double)b/a);
		System.out.println(a);
	}
}