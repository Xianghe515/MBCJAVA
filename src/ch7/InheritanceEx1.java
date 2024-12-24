package ch7;

import ch7.obj.Employee;
import ch7.obj.FinalClass;
import ch7.obj.Person;
import ch7.obj.Student;
import ch7.obj.Teacher;

public class InheritanceEx1 {
	// 상속 테스트를 위한 클래스
	/*
	 * Inheritance(상속)
	 * 	- OOP에서 상속은 기존의 클래스를 확장하여 새로운 클래스를 이끌어 내는 것을 의미
	 * 	- 기존 코드를 재사용 -> 불필요한 코드를 재작성하지 않아도 됨
	 * 	- 클래스의 상속은 단일 상속만 가능		* 인터페이스는 다중 상속 가능
	 * 	- 상속은 extends라는 키워드를 사용하여 상속을 표현
	 *  - 부모 클래스(parent 혹은 super) : 필드와 메소드를 물려준 클래스
	 * 	- 자식 클래스(child 혹은 sub) : 어떤 클래스가 다른 클래스로부터 상속을 받아 만들어지면 새롭게 만들어진 클래스
	 * 	- 상속 하게 되면 부모 클래스의 필드와 메소드를 자식 클래스에 상속
	 *  - 생성자는 상속되지 않음
	 *  - 자바의 모든 클래스는 Object 클래스를 상속받고 있음 (Object - 최상위 클래스)
	 *  - final 클래스는 상속 불가
	 *  - abstract(추상) 클래스는 반드시 상속해서 처리
	 *  
	 *  상속을 잘못 사용한 경우
	 *  - 개별 클래스들이 중복된 속성(필드)/기능(메소드)을 포함
	 *  상속을 잘 사용한 경우
	 *  - 중복된 기능은 빼고 새로운 클래스를 작성 후 구체화
	 *  	일반화된 클래스는 부모 클래스로, 구체화된 클래스를 자식 클래스로 사용
	 */
	public static void main(String[] args) {
		// Person과 Student, Teacher, Employee의 관계
		// 자식 객체 생성
		Employee emp = new Employee();
		Teacher te = new Teacher();
		Student st = new Student();
		Person test1 = new Person("테스터", 26);

		emp.name = "홍길동";
		emp.age = 18;
		emp.height = 180.8;
		emp.department = "교육부"; 		// Employee에서 Override를 통해 수정 -> 출력값 바뀜
		System.out.println(emp.info());
		// Employee 클래스에 name, age, height을 정의하지 않았지만 부모 클래스인 Person에서 상속
		
		te.age = 47;
		te.subject = "프로그래밍";
		te.name = "이황";
		System.out.println(te.info());
		st.name = "이율곡";
		st.age = 15;
		st.studentId = "program001";
		System.out.println(st.info());
		
		
		System.out.println("s1, t1 확인");
		Student s1 = new Student("이율곡", 15, "program001");
		System.out.println(s1.info());	// override한 결과 : [이름: 이율곡, 나이 : 15, 학번 : program001]
		System.out.println(s1);
		
		// 객체 비교
				System.out.println("s1 - 이율곡, 15의 해쉬값 : "+s1.hashCode()); 	// 결과 : 1060174414
				Student s2 = new Student("이율곡", 10, "program001");
				// 이름은 같으나 나이가 다름 -> 해쉬코드 다르게 출력
				System.out.println("s2 - 이율곡, 10의 해쉬값 : "+s2.hashCode());	// 결과 : 1060169609
				Student s3 = new Student("이율곡", 15, "program001");
				s3.height = 180;
				System.out.println("s3 - 이율곡, 15의 해쉬값 : "+s3.hashCode());	// 결과 : 1060174414
				System.out.println("s1과 s3의 동등 비교 결과 : "+(s1 == s3));		// 결과 : false
				
				// 재정의한 equals를 통해 비교
				System.out.println("s1과 s3의 equals 결과 : "+s1.equals(s3));		// 결과 : true
				// studentID에 대한 내용은 보지 않고, age와 name만 봄 -> true
		
		Teacher t1 = new Teacher("이황", 47);
		System.out.println(t1.info());	// override 안 함 : ch7.obj.Teacher@80169cf
		System.out.println(t1);
		
		System.out.println(s1.getClass());
		System.out.println(s2.getClass());
		System.out.println(new Person().getClass());
		
		// final 메소드 확인
		FinalClass finaltest = new FinalClass();
		finaltest.method();			// 오버라이드는 안 되지만, 부모에게 상속받은 메소드 사용은 가능
		
	}

}
