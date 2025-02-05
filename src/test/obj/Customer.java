package test.obj;

public class Customer {
	public String name;
	public String gender;
	public String email;
	public int birthYear;
	
	
	public Customer() {}
	public Customer(String name, String gender, String email, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthYear = birthYear;
	
	
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public int getBirthYear() {return birthYear;}
	public void setBirthYear(int birthYear) {this.birthYear = birthYear;}
	
	@Override
	public String toString() {
		return "[이름 = " + name + 
				", 성별 = " + gender + 
				", 이메일 = " + email + 
				", 출생년도 : " + birthYear + "]";
	}
	
}
