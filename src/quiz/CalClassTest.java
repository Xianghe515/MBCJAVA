package quiz;

import java.util.Scanner;

import ch6.obj.Calculator;

public class CalClassTest {
	
	static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {

		int select = 1;
		
		int[] nums = new int[2];
		
		// Calculator 객체 테스트
//		Calculator cal1 = new Calculator();							// cal1.firstNumber = 0, cal2.secondNumber = 0
//		Calculator cal2 = new Calculator(new int[] {100, 200});		// cal2.firstNumber = 100, cal2.secondNumber = 200
//		Calculator cal3 = new Calculator(1000, 2000);				// cal3.firstNumber = 1000, cal2.secondNumber = 2000


		
		// 반복의 시작
		while (select != 0) {
			// 메뉴 구성
			System.out.println("[계산 프로그램]");
			System.out.println("1. 더하기 \n2. 빼기 \n3. 곱하기 \n4. 나누기 \n0. 종료");
			System.out.print(">>");
			select = sc.nextInt();
			sc.nextLine();			
			Calculator result = new Calculator();
			
			//계산
			switch(select){
			case 1 -> {
				System.out.println("[더하기]");
				// 사용자한테 정수를 입력받도록
				nums = inputInt();
				System.out.println("[결과] : "+result.plus(nums[0], nums[1]));
			}
			case 2 -> {
				System.out.println("[빼기]");
				nums = inputInt();
				System.out.println(result.minus(nums[0], nums[1]));
			}
			case 3 -> {
				System.out.println("[곱하기]");
				nums = inputInt();
				System.out.println(result.multiplication(nums[0], nums[1]));
			}
			case 4 -> {
				System.out.println("[나누기]");
				nums = inputInt();
				System.out.println(result.division(nums[0], nums[1]));
			}
			case 0 -> {
				System.out.println("[종료]");
			}
			default -> {
				System.out.println("[Error]");
			}
		}
	}
		

		
		//반복의 끝
		
		
		
	}
	// 두 정수를 입력받는 메소드
	public static int[] inputInt() {
		int[] nums = new int[2];
		System.out.print(">");
		nums[0] = sc.nextInt();
		System.out.print(">");
		nums[1] = sc.nextInt();
		sc.nextLine();
		return nums;			// 배열은 참조타입 -> 초기값 : null

}
}
