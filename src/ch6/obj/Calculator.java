package ch6.obj;

public class Calculator {
	
	
	// 필드 (멤버 변수)
	int firstNumber;
	int secondNumber;
	
	// 생성자 (객체 생성 시 멤버 변수의 초기화)
	public Calculator() {}	// 기본 생성자
	
	// 멤버 초기화 생성자
	public Calculator(int num1, int num2) {
		firstNumber = num1;
		secondNumber = num2;
	}
	
	// Overload : 매개 변수의 값을 가지고 메소드를 구분(타입, 개수, 순서)
	public Calculator(int[] nums) {
		this.firstNumber = nums[0];
		this.secondNumber = nums[1];
	}
	
	// 메소드 : 클래스에서 기능, 동작과 관련된 기능을 의미하는 함수
	
	// 계산기에서는 더하기, 빼기, 곱하기, 나누기를 통한 연산 작업을 구현
	// 더하기

	
	
	public int plus(int num1, int num2) {
		return (num1 + num2);
	}
	
	public int plus(int[] nums) {
		return nums[0] + nums[1];
	}
	
	// 빼기
	
	public int minus(int num1, int num2) {
		return (num1 - num2);
	}
	
	public int minus(int[] nums) {
		return nums[0] - nums[1];
	}
	
	// 곱하기
	public int multiplication(int num1, int num2) {
		return (num1 + num2);
	}
	
	public int multiplication(int[] nums) {
		return nums[0] * nums[1];
	}
	
	// 나누기
	public double division(int num1, int num2) {
		if (num2 == 0) {
			System.out.println("[Error]");
			return 0.0;
		}
		return (num1 + num2);
	}
	
	public double division(int[] nums) {
		if (nums[1] == 0) {
			System.out.println("[Error]");
			return 0.0;
		}
		return nums[0] / nums[1];
	}
	
	
	
	
	
	// 필드값 출력하는 메소드
	public void numsInfo() {	// console 화면에 필드값 출력
		System.out.println("firstNumber의 값 : "+firstNumber);
		System.out.println("secondNumber의 값 : "+secondNumber);
	}
}
