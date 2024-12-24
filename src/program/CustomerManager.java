package program;

import java.util.Scanner;

import program.obj.Customer;

public class CustomerManager {
	static final int MAX = 100;
	
	// Customer 클래스를 생성해서 객체 배열로 선언
	static Customer[] cusList = new Customer[MAX];
	
	static Scanner sc = new Scanner(System.in);
	
	// count - 저장한 데이터의 크기
	static int count;			// 초기값 = 0
	
	public static void insertCustomerData() {
		// 고객 정보를 저장하는 기능 구현
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("이메일 : ");
		String eMail = sc.next();
		System.out.print("출생년도 : ");
		int birthYear = sc.nextInt();
		// 고객 정보를 배열에 저장
		Customer cus = new Customer(name, gender, eMail, birthYear);
		cusList[count] = cus;
		count++;
		}
	
	// 고객 정보 출력 메소드
	public static void printCustomerData(Customer cus) {
		System.out.println("===========[고객 정보]===========");
		System.out.println(cus.toString());
		System.out.println("===============================");
	}
	// 객체 내 고유 정보(이름)를 통한 검색
	public static Customer selectCustomerData() {
		while (true) {
			System.out.println("[출력/수정/삭제할 이름을 입력]");
			String name = sc.next();
			for (int i=0; i<count; i++) {
				if (cusList[i].getName().equals(name));		// 현재 보고 있는 객체의 이름과 입력된 이름 비교
					return cusList[i];	
			}System.out.println("[Null]");
			
		}
	}
			
	// 데이터 수정
	public static void updateCustomerData(Customer cus) {
		System.out.println("=========[고객 정보 수정]=========");
		System.out.println("이름("+cus.getName()+") :");
		String name = sc.next();
		cus.setName(name);
//		cus.setName(sc.next());
		System.out.println("성별("+cus.getGender()+") :");
		cus.setGender(sc.next());
		System.out.println("이메일("+cus.getEmail()+") :");
		cus.setEmail(sc.next());
		System.out.println("출생년도("+cus.getBirthYear()+") :");
		cus.setBirthYear(sc.nextInt());
		System.out.println("===============================");
		
	}
	
	// 데이터 삭제
	public static void deleteCustomerData(Customer cus) {
		for(int i=0; i < count; i++) {
			// cus에 있는 name과 Customer 배열에 있는 객체들의 name들을 비교
			if(cusList[i].getName().equals(cus.getName())) {
				// 삭제 처리
				for (int j = i; j < count-1; j++) {		
					// 					  └데이터 개수를 하나 줄여야 하기 때문에 -1, 안 하면 out of range
					cusList[j] = cusList[j+1];
				}
			}
			System.out.println("[삭제 완료]");
			count--;	// count를 줄임 -> 마지막 위치 변경
		}
		}
	
	//main()
	public static void main(String[] args) {
		
		while (true) {
			System.out.printf("\n[Info] 고객 수 : %d \n", count);
			System.out.println("[메뉴]");
			System.out.println("(I)nsert \n(S)elect \n(U)pdate \n(D)elete \n(Q)uit");
			System.out.print("[선택]>");
			String menu = sc.next();
			menu = menu.toLowerCase();
			
			switch (menu.charAt(0)) {		//charAt(0) - 가장 첫 번째 문자를 봄
				case 'i', 'ㅑ' -> {
					System.out.println("[고객 정보 입력]");
					insertCustomerData();
					}
				case 's', 'ㄴ'-> {
					System.out.println("[고객 정보 출력]");
					if(count > 0)
					printCustomerData(selectCustomerData());
					else System.out.println("[Null]");
					}
				case 'u', 'ㅕ' -> {
					System.out.println("[데이터 수정]");
					if(count > 0) {			// 삭제할 데이터가 존재해야 삭제 가능 (count는 데이터를 의미)
						updateCustomerData(selectCustomerData());	
					}else {
						System.out.println("[데이터 선택되지 않음]");
					}
					}
				case 'd', 'ㅇ' -> {
					System.out.println("[데이터 삭제]");
					if(count > 0) {
						deleteCustomerData(selectCustomerData());
					}else {
						System.out.println("[데이터 선택되지 않음]");
					}
					}
				case 'q', 'ㅂ' -> {
					System.out.println("[종료]");
					sc.close();
					System.exit(0);			// 프로세스 종료, 로직으로 실행시켜 멈추는 것이 아님
				}
				default -> {
					System.out.println("[Error]");
				}
			}	
		}
	}

	

}