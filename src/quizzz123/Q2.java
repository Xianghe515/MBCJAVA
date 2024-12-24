package quizzz123;

public class Q2 {
	public static void main(String[] args) {
//		1.  Math.random() 을 이용하여-5 ~ 5 의 랜덤 수를 발생시키세요.
		int i = (int)(Math.random()*(-11)+5);
		System.out.println("랜덤값 : "+i);
//		2.  3항 연산 식을 사용 해서, 절대값을 구하는식을세우세요.
		int absoluteValue = (i<0) ? -i : i;
		System.out.println(i+"의 절대값은 : "+absoluteValue);
		}
}
