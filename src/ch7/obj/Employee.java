package ch7.obj;

// Person 클래스의 자식
public class Employee extends Person {
	
	public String department;
	
	public Employee() {};		// 생성자는 부모로부터 상속받지 않음
	public Employee(String name, int age, String department) {
		super(name, age);		// super : 부모 객체를 의미
		// super. 	: 부모 필드와 메소드에 접근
		// super()	: 부모 생성자에 접근
		this.department = department;		// 부모에 없는 것은 추가하여 정의
		
	}
	
	@Override		// @Override : 부모로부터 상속 받은 것을 재정의
	public String info() {
		return "이름 : "+name+", 나이 : "+age+", 부서 : "+department;
	}
	public void working() {
		// TODO Auto-generated method stub
		
	}
}
