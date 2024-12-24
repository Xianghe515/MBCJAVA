package program.obj;

import java.io.Serializable;

public class Customer implements Serializable {		// 직렬화
	
	private static final long serialVersionUID = 7424772227768766494L;

	// 필드(멤버 변수)
	public String name;
	public String gender;
	public String email;
	public int birthYear;

	// 생성자
	public Customer() {
	}

	public Customer(String name, String gender, String email, int birthYear) {
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthYear = birthYear;
	}

	// 메소드
	@Override // 재정의
	public String toString() { // toString은 Object 클래스에서 정의되어있는 메소드 -> 불러서 사용
		return "[이름 = " + name + ", 성별 = " + gender + ", 이메일 = " + email + ", 출생년도 : " + birthYear + "]";
	}

	// getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
}
