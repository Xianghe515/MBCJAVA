package quiz;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class CalQClass {
	// 계산기 연산 클래스
	
	// 더하기, 빼기, 곱하기, 나누기 메소드
	
	public int plus (int x, int y) {
		return x+y;
	}
	public int minus (int x, int y) {
		return x-y;
	}
	public int multiplication (int x, int y) {
		return x*y;
	}
	public int division (int x, int y) {
		if (y == 0) {
			System.out.println("[Error]");
			return 0;
		}
		return x/y;
	}	
	Scanner sc = new Scanner(System.in);
//	// 두 정수를 입력받는 메소드
//	public int[] inputInt() {
//		int[] nums = new int[2];
//		System.out.print(">");
//		nums[1] = sc.nextInt();
//		System.out.print(">");
//		nums[2] = sc.nextInt();
//		return nums;			// 배열은 참조타입 -> 초기값 : null


}