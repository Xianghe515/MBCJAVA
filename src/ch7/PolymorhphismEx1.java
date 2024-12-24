package ch7;

import ch7.obj.Employee;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class PolymorhphismEx1 {

	public static void main(String[] args) {
		// 부모 객체는 자식 객체를 포함하고 있음
		Person p;	// 부모 객체 변수를 선언
		
		// 자식 객체를 부모 객체에 넣어줌 -> Promotion(자동형변환)
		// Promotion이 일어나면, 자식 객체는 부모 객체가 가지고 있는 것들에 대해 접근 및 실행 가능
		// 즉, 필드(멤버 변수)와 메소드를 실행 가능
		// 메소드는 재정의 했다면, 재정의한 것으로 실행
		p = new Student("홍길동", 18, "2024110501");
		System.out.println(p.info());
		p = new Teacher("홍길동 사부", 100, "도술");
		System.out.println(p.info());
		p = new Employee("홍길자", 45, "식사담당");
	    System.out.println(p.info());
//	    p.working();	// 부모 클래스인 Person에 working()가 없기 때문에 실행 X
	    System.out.println(p.getClass());
	    
	    Employee e1 = (Employee)p;		// casting을 통해서 형변환
	    System.out.println(e1.info());
	    e1.working();
	    System.out.println(e1.getClass());

	}

}
