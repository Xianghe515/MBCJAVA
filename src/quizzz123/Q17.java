package quizzz123;

import java.util.Arrays;

public class Q17 {
	
//	 “안녕” 출력 ㅇ
	static void method1() {
		System.out.println("안녕");
	}
	
//	 “전달받은매개변수리턴＂ ㅇ
	static String method2(String str) {
		return str;
	}
	
//	 “세매개변수합리턴＂ ㅇ
	static double method3(int x, int y, double z) {
		return x+y+z;
	}
	
//	 “매개변수가짝수면“짝수“, 홀수라면“홀수“ 리턴 ㅇ
	static String method4(int a) {
		return a%2==0 ? "짝수" : "홀수";
	}
	
//	 “매개변수 int만큼 String 반복출력” ㅇ
	static void method5(String str, int a) {
		for (int i=0; i<a; i++) {
			System.out.println(str);
		}
	}
	
//	“매개변수 2개를 입력받아 큰수 리턴” ㅇ
	static double maxNum(double m, double n) {
		if(m < n) {
			return n;
		}else {
			return m;
		}
	}
	
//	 “절대값리턴＂
	static int abs(int a) {
		return a > 0 ? a : -a;
	}
	
//	 “0~매개변수까지합을저장해서리턴＂ ㅇ
	static int method6(int a) {
		int result = 0;
		for (int i=0; i<=a; i++) {
			result += i;
		}
		return result;
	}
	
//	 “배열의 길이를 리턴＂ ㅇ
	static int method7(int a[]) {
		return a.length;
	}
	
//	 “매개변수를 배열에 저장하여 배열 리턴＂ ㅇ
	static String[] method8(String str1, String str2) {
		String[] result = {str1, str2};
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[2];
		String[] arr2 = new String[2];
		
		// TODO Auto-generated method stub
		System.out.println(method6(5));
		System.out.println(method7(arr));
		method5("help", 5);
		System.out.println(Arrays.toString(method8("r", "s")));

	}
}