package ch6.obj;

// 부모 클래스
public class Super {
	// 필드
	public int num1 = 10;
	protected int num2 = 20;
	private int num3 = 30;		// 같은 객체 내 접근
	/* default */ int num4 = 40;
	
	// 메소드를 통해 접근
	public int getNum3() {
		return num3;
	}
}
