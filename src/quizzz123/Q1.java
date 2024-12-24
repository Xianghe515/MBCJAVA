package quizzz123;

public class Q1 {

	public static void main(String[] args) {
		// 1. Math.random()을 사용해서 1~100까지 랜덤 정수를 발생시키세요.
		int i = (int)(Math.random()*100)+1;
		System.out.println("랜덤 수는 : "+i);
		// 2. i가 짝수라면“짝수”,  홀수라면 “홀수” 를 출력하는 3항 연산식을세우세요
		String a = (i%2==0) ? "짝수" : "홀수";
		System.out.println("3항 연산의 결과 : "+a);
		
	
		
		
		
		
	}
}