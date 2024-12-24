package database.persons;

public class PersonsVO {
	/* JAVA에서 VO, DTO 객체
		VO : DB와 연동할 데이터를 저장하는 객체
		DTO : 데이터를 전달하는 객체로 사용
	+ DB 연동 동작에 대해 DAO를 생성하여 작업 진행
	*/
	// 테이블 Persons에 있는 컬럼 - ID, FirstName, LastName, Age, City
	private int id;
	private String FirstName;
	private String LastName;
	private int age;
	private String City;
	
	// 기본 생성자
	public PersonsVO() {}
	// 필드 생성자
	public PersonsVO(int id, String firstName, String lastName, int age, String city) {
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.age = age;
		City = city;
	}

	// 메소드
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getFirstName() {return FirstName;}
	public void setFirstName(String firstName) {FirstName = firstName;}
	public String getLastName() {return LastName;}
	public void setLastName(String lastName) {LastName = lastName;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getCity() {return City;}
	public void setCity(String city) {City = city;}
	
	@Override
	public String toString() {
		return "PersonsVO [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", age=" + age
				+ ", City=" + City + "]";
	}
	

	
}
