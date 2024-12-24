package ch11;

//예외 처리 방법 중 throws - 문제를 회피, 결국 누군가는 처리를 해야함.
public class ThrowsEx {

	private static String[] greetings = {"안녕", "Hi", "니하오"};
	
	public static void doIt(int index) throws ArrayIndexOutOfBoundsException {
		// throws 사용한 경우 예외 처리를 메소드를 호출한 곳에 넘김
		System.out.println(greetings[index]);
	}
	
	public static void doIt2(int index) {
		try {
			// 예외 발생할 여지가 있는 코드 검증 구간
			System.out.println(greetings[index]);
		} catch (Exception e) {
			// 예외 처리 구간
			System.out.println("잘못된 인덱스 입니다.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int i = (int) (Math.random() * 4);	// 0, 1, 2, 3
		
		
//		doIt(i);	//  Index 3 out of bounds for length 3 
//		└ 안녕, Hi, 니하오 세 개 중 하나가 출력되어야 하는데 랜덤값 i는 0, 1, 2, 3 중 하나가 나옴
		
		// main에서 예외 처리
//		try {		
//			doIt(i);	// 예외가 발생할 수 있는 경우를 입력
//		}catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("main에서 i가 잘못된 값을 넘겼습니다. 다음으로 진행합니다.");	// 예외가 발생했을 때 처리하는 방법을 입력
//		}
		
		// doIt2() 내에서 예외 처리
		doIt2(i);
		
		System.out.println("다음 명령문들이 실행됩니다.");
		
		
	}
	
}