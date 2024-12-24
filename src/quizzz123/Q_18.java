package quizzz123;

public class Q_18 {

	public static void main(String[] args) {
		String str = java(5);
		System.out.println(str);

	}
	public static String java (int a){
		for(int i=0; i<a; i++) {
			if (i%2==0) {
				System.out.print("자");
			}else {
				System.out.print("바");
			}
		}
		return "";
	}


}