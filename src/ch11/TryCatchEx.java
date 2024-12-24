package ch11;

public class TryCatchEx {

	// 예외 사항 1 - 0으로 나누는 상황 : ArithmeticException
	public static int divide(int a, int b) {
		return a/b;
	}
	
	
	
	// 예외 사항 2 - 강제로 예외 발생 - throw*		*throws와 또 다름, 일부로 예외를 일으키는 코드를 작성하여 알려주기 위함.
//																└ 예) 나이를 입력 받는데 음수가 입력됨
	public static void doSomething(int a) throws Exception {
		if (a > 50) {
			throw new Exception("a가 50보다 큽니다.");	// throw new 예외객체
		}
		System.out.println("50% 확률로 실행됩니다.");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int a = (int) (Math.random() * 100);	// 0~99
		int b = (int) (Math.random() * 4);		// 0~3
		
		try {
			System.out.printf("a = %d, b = %d, result = %d\n", a, b, divide(a, b));
			doSomething(a);
		}catch (ArithmeticException ae) {
			System.out.println("0으로 나누려고 하고 있어요.");
		}catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			System.out.println("예외 발생 원인 : "+e.getMessage());	// getMessage() 예외 발생 메시지 출력
		}finally {	// 예외 처리 시 항상 실행할 부분
			System.out.println(a);
			System.out.println(b);
		}

	}

}
