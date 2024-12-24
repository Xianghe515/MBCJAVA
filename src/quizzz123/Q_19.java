package quizzz123;

public class Q_19 {

	public static void main(String[] args) {
		System.out.println(sum(7));

	}
	
	static int sum(int a) {
		int result = 0;
		
		if(a>0) {
			for(int i=1;i<=a;i++) {
				if(a%i==0) {
					result+=i;
				}
			}
		}else {
			System.out.println("자연수가 아닙니다.");
		}
		return result;
	}
}

