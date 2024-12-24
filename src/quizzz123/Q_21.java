package quizzz123;

public class Q_21 {

	public static void main(String[] args) {
		// sumNum은 매개변수 2개를 받습니다.
		// 두 매개변수 사이에 속한 모든 정수의 합을 구하는 sumNum을 완성하세요
		// 두 매개변수의 크기는 정해지지 않았습니다.
		
		System.out.println("7~9의 사이의 수의 합: "+sumNum(7, 9));
		System.out.println("9~7의 사이의 수의 합: "+sumNum(9, 7));
		System.out.println("5~5의 사이의 수의 합: "+sumNum(5, 5));
	}
	
	static int sumNum(int a, int b) {
		int result = 0;

			if (a<b) {
				for (int i=a; i<=b; i++) {
					result += i;
				}
			}else if (b<a) {
				for (int i=b; i<=a; i++) {
					result += i;
				}
			}else {
				result = a;
			}
			return result;
	}
		
		
	}
