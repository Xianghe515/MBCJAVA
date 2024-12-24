package dbquiz.persons;

public class PersonsVO {
	private int id;
	private String LastName;
	private String FirstName;
	private int age;
	private String City;
	
	public PersonsVO() {}

	public PersonsVO(int id, String lastName, String firstName, int age, String city) {
		this.id = id;
		LastName = lastName;
		FirstName = firstName;
		this.age = age;
		City = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "PersonsVO [id=" + id + ", LastName=" + LastName + ", FirstName=" + FirstName + ", age=" + age
				+ ", City=" + City + "]";
	}
	
	
	
}
