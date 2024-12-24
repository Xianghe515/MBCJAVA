package ch11;

import java.io.IOException;
import java.sql.SQLException;

// 예외의 상속 관계
//	- 부모가 throws하지 않는 Exception은 throws 할 수 없음

public class InheritExcptionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Super {
	public void doIt() throws IOException {
		System.out.println("IOException을 throws합니다.");
	}
}


class sub extends Super {
	
	// 재정의 상황에서 throws에 IOException을 SQLException으로 변경한다면
	@Override
	public void doIt() throws IOException /*, SQLException */{
		System.out.println("Sub.doIt");
		try {
			super.doIt();	// 부모의 메소드
		} catch (IOException e) {
//			throw new SQLException(e.getMessage());
		}

	}
}