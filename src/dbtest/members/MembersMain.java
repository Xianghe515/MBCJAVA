package dbtest.members;

import java.util.List;
import java.util.Scanner;

public class MembersMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MembersDAO dao = MembersDAO.getInstance();
		
		// 메뉴
		while(true) {
		System.out.println("[멤버 관리 프로그램]");
		System.out.println("1. 멤버 추가");
		System.out.println("2. 멤버 출력");
		System.out.println("3. 멤버 수정");
		System.out.println("4. 멤버 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print(">");
		String menuSelect = sc.nextLine();
		
		switch (menuSelect) {
		// insert
		case "1" -> {
			System.out.print("[UserID] : ");
				String userId = sc.nextLine();
			System.out.print("[비밀번호] : ");
				String userPw = sc.nextLine();
			System.out.print("[이름] : ");
				String name = sc.nextLine();
			System.out.print("[나이] : ");
				int age=0;
				while(true) {
				age = sc.nextInt();
					if (age>=15) {
						break;
					} else System.out.print("[15세 이상부터 가입 가능]\n[나이] : ");
				}
			System.out.print("[전화번호] : ");
			sc.nextLine();
				String phone =sc.nextLine();

			MembersVO vo = new MembersVO(0, userId, userPw, name, age, phone, null);
			
			// 등록 여부 확인
			int result = dao.insert(vo);
			if (result > 0) {
				System.out.println("[등록 성공]");
			}else {
				System.out.println("[등록 실패]");
			}
		}
		// select
		case "2" -> {
			System.out.print("1. 모든 멤버 출력\n2. ID 검색\n3. 이름 검색\n0. 이전 메뉴\n>");
			String sel = sc.nextLine();
	
			switch(sel) {
			case "1" -> {
				List<MembersVO> list = dao.selectAll();
				for (MembersVO vo:list) {
					System.out.println(vo);
				}
				break;
			}
			case "2" -> {
				System.out.print("[검색할 ID 입력] : ");
				int searchID = sc.nextInt();
				System.out.println(dao.selectOne(searchID));
				sc.nextLine();
				break;
			}
			case "3" -> {
				System.out.print("[검색할 이름 입력] : ");
				String searchName = sc.nextLine();
				System.out.println(dao.selectOneName(searchName));
				break;
			}
			case "0" -> {
				break;
			}
			default -> {
				System.out.println("[잘못된 메뉴 선택]");
				break;
			}
			}
		}
		// update
		case "3" -> {
			System.out.print("[수정할 ID 입력] : ");
			int searchID = sc.nextInt();
			System.out.println(dao.selectOne(searchID));
			MembersVO mod = dao.selectOne(searchID);

			System.out.print("[UserID 수정] : ");
				sc.nextLine();
				String userId = sc.nextLine();
				mod.setUserId(userId);
			System.out.print("[비밀번호 수정] : ");
				String userPw = sc.nextLine();
				mod.setUserPw(userPw);
			System.out.print("[이름 수정] : ");
				String name = sc.nextLine();
				mod.setName(name);
			System.out.print("[나이 수정] : ");
				int age=0;
				while(true) {
				age = sc.nextInt();
					if (age>=15) {
						mod.setAge(age);
						break;
					} else System.out.println("[15세 이상부터 입력 가능]\n[나이 수정] : ");
				}
			System.out.print("[전화번호 수정] : ");
				String phone =sc.next();
				mod.setPhone(phone);
				
			int result = dao.update(mod, searchID);
			if (result != 0) {
				System.out.println("[업데이트 성공]");
			}else {
				System.out.println("[업데이트 실패]");
			}
			sc.nextLine();
		}		
		// delete
		case "4" -> {
			System.out.print("[삭제할 ID 입력] : ");
			int deleteUser = sc.nextInt();
			int result = dao.delete(deleteUser);
			if (result !=0) {
				System.out.println("[삭제 성공]");
			}else {
				System.out.println("[삭제 실패]");
			}
			sc.nextLine();
		}
		case "0" -> {
			System.out.println("[프로그램 종료]");
			System.exit(0);
		}
		default -> {
			
			System.out.println("[잘못된 메뉴 선택]");
			break;
		}
		}
		}
	}
}


