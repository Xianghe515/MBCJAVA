package quizzz123;

public class Q_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. 2중 for문을 이용하여 다음을구현하세요. (아래로 표현)
//		 2. 실행결과에보이는모든숫자는상위for문과, 하위for문에서 사용한변수로출력하여야합니다
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i+ " X " + j+ " = "+ (i*j));
			}
		}
		
	}

}
