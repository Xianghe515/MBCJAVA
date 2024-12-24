package database.persons;

import java.util.List;

public class PersonsMain {

	public static void main(String[] args) {
//		// test1 - INSERT　테스트
//		// 1. 추가할 데이터 생성
//		PersonsVO vo = new PersonsVO(0, "javatest", "test", 17, "Seoul");
//		
//		// 2. DAO 객체 호출 ( - 데이터 처리는 DAO가)
//		PersonsDAO dao = new PersonsDAO();
//		
//		// 3. 작업 처리 - insert() 함수 호출
//		int result = dao.insert(vo);
//		if(result>0) {
//			System.out.println("레코드 등록 성공");
//		}else {		// result가 0이면 실패
//			System.out.println("레코드 등록 실패");
//		}
		
		// test2 - SELECT 테스트
		// 1. DAO 객체 호출
//		PersonsDAO dao = new PersonsDAO();
		// *싱글톤인 경우
		PersonsDAO dao = PersonsDAO.getInstance();
		// 2. DAO 객체에 있는 select 처리할 메소드 호출(전체 출력, firstname으로 출력)
			// 1) 전체 출력
		List<PersonsVO> list = dao.selectAll();
		for (PersonsVO vo:list) {
			System.out.println(vo);
		}
		
		System.out.println("─────────────────────────────────────────────────────────────────");
		
			// 2) 부분 조회(firstname)
		list = dao.selectOneName("test");
		System.out.println("firstname에 'test'가 있는 경우 레코드 출력");
		for (PersonsVO vo:list) {
			System.out.println(vo);
		}
			// 2) id로 부분 조회
		System.out.println("─────────────────────────────────────────────────────────────────");
		System.out.println("id=10인 경우 레코드 출력");
		System.out.println(dao.selectOne(10));
		
		
		System.out.println("─────────────────────────────────────────────────────────────────");

//		test3 - UPDATE 테스트
		PersonsVO mod = dao.selectOne(10);
		mod.setFirstName("modified");
		mod.setAge(100);
		mod.setLastName("soooooooohardtome");

		int result = dao.update(mod);
		if (result != 0) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		
		
//		test4 - DELETE 테스트
		dao.delete(9);
		if (result !=0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
		
	
		

}
