package ch7;

import ch7.obj.Employee;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class PolymorhphismEx2 {

	/*
	 *  매개 변수의 다형성
	 * 	 - Promotion은 필드(멤버 변수)의 값을 대입할 때도 일어나지만, 메소드를 호출할 때 사용하는 매개 변수에서도 발생
	 * 	 - 보통 메소드를 호출할 때는 메소드 선언부에 지정한 데이터 타입과 일치하는 매개값을 전달하여 호출
	 * 		- 그러나 매개 변수에 다형성을 적용하면 자식 객체를 전달 가능
	 */
	
	public static void main(String[] args) {
		
		// instanceof - 객체가 지정한 클래스인지 아닌지 검사할 때 사용
		//	- 왼쪽 항의 객체가 오른쪽 항의 클래스인지 검사 - 맞으면 true, 틀리면 false
		// 		예) person instanceof Person 
		
		
		
		
		Student s = new Student("홍길동", 15, "2024110501");
		System.out.println("instanceof 결과 : "+ (s instanceof Student));		// 결과 : true
		System.out.println("instanceof 결과 : "+ (s instanceof Person)+ "\n");		// 결과 : true
		printPersonInfo(s);
		
		Teacher t = new Teacher("도사님", 100, "도술");
		printPersonInfo(t);
		
		Employee e = new Employee("홍길자", 45, "식사 담당");
		printPersonInfo(e);
				

	}
	
	
	
	public static void printPersonInfo(Person p) {
		// instanceof를 사용하여 각 객체별 배너의 값을 출력하게 만드시오
//		 	Student인 경우 배너는 Student Info로, Teacher인 경우 Teacher Info
//		 	Person인 경우 Person Info로
		
		
		if (p instanceof Student) {
			System.out.println("************ Student Info ************");
		}else if (p instanceof Teacher) {
			System.out.println("************ Teacher Info ************");
		}else if (p instanceof Employee) {
			System.out.println("************ Employee Info ************");
		}else {
			System.out.println("************ Person Info ************");
		}
			System.out.println(p.getClass());
			System.out.println(p.info());
			System.out.println("*************************************");
		}
	}
