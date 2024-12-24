package quizzz456;

public class Q2and3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("홍길동", 20, 180);
		p1.info();
		
		System.out.println("------------------");
		Person p2 = new Person();
		p2.age = 40;
		p2.name = "김길동";
		p2.tall = 170;
		
		p2.info();
	}

}

class Person {
	String name;
	int age;
	int tall;
	
	public Person(String name, int age, int tall) {
		this.name = name;
		this.age = age;
		this.tall = tall;
	}
	
	
	public Person() {
		super();
	}


	void info() {
		System.out.println(name);
		System.out.println(age+"세");
		System.out.println("키 : "+ tall);
	}
}