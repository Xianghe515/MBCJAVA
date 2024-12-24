package ch6;

public class EncapsulationEx {
	/*
	 * Encapsulation(은닉, 캡슐화) - 사용자에게 상세한 내부 구현을 숨기고, 필요한 부분만 보이게 만드는 것
	 * 	- 클래스의 필드(멤버 변수)의 접근 제한자를 private으로 설정한다.
	 *  - 은닉된 필드에 접근하기 위해서는 공개된(public) 메소드를 통해 접근 가능
	 *  - 이와 같이 변수의 값을 변경하는 데 사용되는 메소드 Setter 메소드라고 하고, 
	 *    변수의 값을 불러오는 메소드를 Getter 메소드라고 함
	 *  - 공개 메소드를 이용하여 데이터를 변경시킬 경우 메소드 내에 데이터 유효성을 검증할 루틴을 작성 가능
	 *  - 경우에 따라 접근 권한을 체크할 수 있는 로직을 포함하면 인가되지 않은 사용자에게 중요한 데이터나 로직을 숨길 수 있다.
	 *  - 꼭 필드만 private으로 제한하는 것은 아니고, 외부에 공개하고 싶지 않은 메소드들도 preivate 처리 가능 
	 */
	public static void main(String[] args) {
		// MyDate 테스트
		MyDate myBirth = new MyDate();
		myBirth.setDay(32);		// 날짜가 잘못된 경우 day=1로 설정
		System.out.println("My birth day is "+myBirth.getDay());
	}
}
class MyDate {
	// 은닉을 사용하지 않는 경우 public
public int day;
public int month;
public int year;

//getter setter
public int getDay() {
	return day;
}
public String setday() {
	// TODO Auto-generated method stub
	return null;
}
public void setDay(int day) {
	if(day < 1 || day > 31) {			// day가 1보다 작거나 31보다 큰 경우
		System.out.println("잘못된 날짜 입력");
		this.day = 1;
	}else {
		this.day = day;
	}
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

}

