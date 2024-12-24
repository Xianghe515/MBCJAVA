package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckID {

	/*
	 * 사용자가 ID를 입력하면, 올바른 ID인지 체크하고, 올바른 ID라면 회원 배열에 추가하는 프로그램
	 * 확인 내용(메소드로 구현)
	 * 1) 아이디 사이에 공백이 있는가
	 * 2) 중복된 아이디인가
	 * 3) 영어, 숫자, _만 사용 가능(다른 문자 사용 불가능)
	 * 4) 글자수 제한 20자
	 */
	
	
	//List<Member> memList를 생성해서 작업 진행
	static List<Member> memlist = new ArrayList<Member>();
	
	public static void main(String[] args) {
		// 
		Scanner sc = new Scanner(System.in);
		String[] st = new String[100];		// id 저장할 배열
		int a = 0;
		
		while(true) {
			System.out.println("────────────[회원 등록]────────────");
			System.out.print("[메뉴] \n1. ID 등록 \n");
			String sel = sc.next();			// 메뉴 입력 받는 스캐너
			
			
			switch(sel) {					// 메뉴 선택
			
				case "1" -> {
					System.out.print("[ID 입력] : ");
					String id = sc.nextLine();
					id = sc.nextLine();
					
					boolean bool = true;				// id 중복 확인
					for(int i=0; i<st.length; i++) {
						if(id.equals(st[i])) {			// st에 저장되어있는 id들을 0번부터 찾아 id와 같은지 확인
							bool = false;
							System.out.println("[중복된 아이디입니다.]");
							break;
						}
					}
					if(bool) {
						st[a] = id;			// st에 id를 저장
						a++;
						System.out.println("[입력 받은 아이디는 " + id + " 입니다.]");
					}
					
					
					
				}default -> {
					System.out.println("[잘못된 메뉴 선택입니다]");
			}
			
			
			}
			
			
			
		}
	}
			
	}
		

