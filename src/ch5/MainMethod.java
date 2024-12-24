package ch5;

import java.util.Arrays;

public class MainMethod {

	public static void main(String[] args) {		// 외부에서 실행할 때 값을 받아서 처리해줌
		// 자바에서는 프로그램을 실행하기 위해 main() 메소드를 작성하여 동작
		// main()에는 전달 받는 값으로 Stirng[] args를 사용하고 있습니다.
		System.out.println(args);						// 결과 : [Ljava.lang.String;@b3d7190
		System.out.println(Arrays.toString(args));		// 결과 : []
//		Rus as - Run configuration - Arguments - program arguments에 내용을 입력하면 []에 들어감	*194p
		
		if (args[0].equals("-d")) {
			System.out.println("옵션 d에 대한 작업을 진행합니다.");
			System.out.println("옵션 d의 내용은 \""+ args[1]+"\"에 대한 내용입니다.");
		}
		
	}

}
