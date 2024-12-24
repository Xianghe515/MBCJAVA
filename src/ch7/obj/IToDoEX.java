package ch7.obj;

public class IToDoEX {

	public static void main(String[] args) {
		// 다중 인터페이스 및 다중 상속 예제
		ToDo toDo = new ToDo();
		
		IToDo3 iToDo3 = toDo;	// 다형성으로 구현체인 toDo 객체가 인터페이스 IToDo3에 타입변환함
		iToDo3.m1();
		iToDo3.m2();
		iToDo3.m3();
//		iToDo3.m4();	동작x - 해당 인터페이스 객체에서 m4() 추상 메소드로 선언x
		
		IToDo4 iToDo4 = toDo;
		iToDo4.m4();
	}

}


// 인터페이스들
interface IToDo1 {
	// 추상 메소드
	void m1();
}
interface IToDo2 {
	// 추상 메소드
	void m2();
}

// 다중 상속 인터페이스
interface IToDo3 extends IToDo1, IToDo2 {
	// 추상 메소드
	void m3();
}

interface IToDo4 {
	// 추상 메소드
	void m4();
}

// 다중 인터페이스 구현체
class ToDo implements IToDo3, IToDo4{		// IToDo3만 상속받아도 1, 2 한번에

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}
	
}