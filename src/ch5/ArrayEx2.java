package ch5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayEx2 {

	public static void main(String[] args) {
		// 다차원 배열	- 하위 차원의 배열을 요소로 가짐
		// 1차원 배열 : 하나의 배열 값을 가지고 만들어진 배열
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};		// 각각을 배열의 요소라고 부름
		System.out.println("배열의 길이 : "+ numbers.length);		// 배열의 길이를 출력
		
		// 2차원 배열 : 배열의 요소를 'int[](배열)'로 가지고 있는 배열		* 이 요소는 1차원 배열
		int[][] arr2 = {
				{1, 2, 3},		// arr2[0]
				{4, 5, 6},		// arr2[1]
// arr2에서		 1	2  3 	번째
				{7, 8, 9},		// arr2[2]
				numbers			// arr2[3]				* 배열이 가진 요소의 개수는 다를 수 있음
		}; 
		System.out.println(arr2[0]);					// 내용이 아닌 주소가 나타남
		System.out.println(Arrays.toString(arr2[0]));
		System.out.println(Arrays.toString(arr2[1]));
		System.out.println(Arrays.toString(arr2[2]));
		System.out.println(Arrays.toString(arr2[3]));
		
		System.out.println("6 출력 : "+ arr2[1][2]);		// arr2의 두 번째 요소에서 세 번째를 출력
		
		System.out.println("arr2[1] 배열의 길이 : "+arr2[1].length);
		System.out.println("arr2[3] 배열의 길이 : "+arr2[3].length);
		System.out.println("arr2[3] 배열의 마지막 값 : "+arr2[3][arr2[3].length - 1]);
		// 0부터 시작. length는 1부터 -> 'length -1'로 마지막 값 불러낼 수 있음
		
		// 3차원 배열 : 'int[][]'을 요소로 가지고 있는 배열
//		int[][][] arr3 = {arr2, arr2, arr2, arr2};
		int[][][] arr3 = new int[4][][];	// 다차원 배열의 생성 시 첫 번째 []는 배열의 길이를 나타냄
//		{null, null, null, null}	* 이 요소는 2차원 배열
		arr3[0] = arr2;
		arr3[1] = arr2;
		arr3[2] = arr2;
		arr3[3] = arr2;			// numbers는 불가 - 1차원 배열이기 때문
		
		// 4차원 배열 : 'int[][][]'을 요소로 가지고 있는 배열
		int [][][][] arr4 = {arr3, arr3, arr3, arr3};
		
		// n차원 배열 : 배열의 요소로 (n-1)차원 배열을 가지고 있는 배열
		
		// n차원 배열의 모든 요소를 n중 반복문을 통해 탐색 가능
		// 2차원 배열의 요소 출력
		System.out.println("2차원 배열의 요소 출력");
		for (int i=0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {		// arr2[i].length 각 요소별 길이
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();	// 줄바꿈
		}
		
		System.out.println("3차원 배열의 요소 출력");
		for (int i=0; i < arr3.length; i++) {
			for (int j=0; j < arr3[i].length; j++) {
				for (int k=0; k < arr3[i][j].length; k++) {
					System.out.print(arr3[i][j][k]+ " ");
				}
				System.out.println();
			}
		}
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr3[0]));
		System.out.println(Arrays.toString(arr3[0][0]));
		
		// 향상된 for문
		// 배열과 Collection 같이 연속된 자료 타입을 출력하기 위한 for문
		// 카운트 변수와 증감식을 사용하지 않고, 항목의 개수만큼 반복한 후에 자동으로 for문을 빠져나감
		// for ( 타입 변수명 : 배열(앞에 타입 배열)) {
		//		반복 실행문
		// }
		// 배열에서 타입에 맞는 항목을 불러와서 변수에 저장하고, 반복 실행문을 동작
		System.out.println("=======향상된 for문 사용=======");
		for (int[] arr : arr2) {
//			System.out.println(Arrays.toString(arr));
			for (int num : arr) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
		for (int num : numbers) {
			System.out.print(num+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
