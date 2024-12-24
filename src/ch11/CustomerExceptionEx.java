package ch11;

// 사용자 정의 예외 : 예외 클래스를 상속받아 개발자가 자의적인 예외 클래스를 생성

public class CustomerExceptionEx {

	public static void main(String[] args) {
		// 멤버 생성
		Member member = new Member("홍길동", "010-2345-5678", "산골짜기");
		try {
			new MemberManager().insert(member);
			System.out.println("예외 없음");
		} catch (DuplicateKeyException e) {
			System.out.println(e.getMessage());
		}
		

	}

}

// Member 클래스 - 사용자 정보를 저장
class Member {
	// 필드
	String name;
	String phone;
	String address;
	
	// 생성자
	public Member(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
}

// Member에 대한 작업을 클래스(기능을 담고 있는 클래스)
class MemberManager {
	// 사용자 추가
	public void insert(Member member) throws DuplicateKeyException {
		System.out.println("고객 정보를 저장합니다.");
		System.out.println(member.name+"님의 정보");
		// 저장공간 또는 DB에 홍길동/010-1234-5678 정보를 가지고 있다고 가정
		if("홍길동".equals(member.name)&&"010-1234-5678".equals(member.phone)) {
			// 이 경우 저장공간 혹은 DB에 이미 동일 정보가 저장된 상태
			// 예외를 발생시켜 insert 메소드를 호출한 곳으로 데이터가 중복됨을 알리고 싶은 경우
			
			// 예외를 강제 발생
			throw new DuplicateKeyException("데이터가 중복됩니다.");
		}else {
			System.out.println("데이터베이스에 저장했습니다.");
		}
	}
}

// 사용자 정의 예외 클래스 만들기
class DuplicateKeyException	extends Exception {
	public DuplicateKeyException(String message) {
		super(message);
	}
}




