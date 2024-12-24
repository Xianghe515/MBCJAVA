package program;

import java.util.Scanner;

public class Supervising {
	// 고객 관리 프로그램 작성ver1
	// 고객 정보(필드) : 이름, 성별, 이메일, 출생년도
	// 기능(메소드) : 입력, 출력, 수정, 삭제(CRUD)
	//	- 출력 기능 세분화 -> 이전 고객, 현재 고객, 다음 고객
	
	// 데이터를 저장할 배열의 최대 크기 100으로 정하기 -> final
	static final int MAX = 100;
	
	// 필드(멤버 변수) 선언, 배열을 통해 고객 정보 저장
	static String[] name 	= new String[MAX];
	static String[] gender	= new String[MAX];
	static String[] eMail	= new String[MAX];
	static int[] birthYear	= new int[MAX];
		
	// 추가 작성해야 할 필드 - 인덱스(int index), 저장 데이터 개수(int count), 입력값 처리(Scanner sc)
	// 배열에서는 참조할 때 인덱스를 필요로 함
	static int index = -1;		// 배열은 0부터 시작하기 때문에 최소 인덱스는 -1로 설정
	// 배열은 처음 선언한 크기보다 같거나 적은 개수의 자료를 저장하기 때문에 현재 데이터가 몇 개 저장되어 있는지 알 수 있어야 함
	static int count = 0;
	// 기본 입력 장치로부터 데이터를 입력 받기 위해 Scanner 객체 생성
	static Scanner sc = new Scanner(System.in);
	
	
	
	
	// 메소드, 기능 구현(입력(insert), 출력(print), 수정(update), 삭제(delete))
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
		Supervising.name[count] = name;
		Supervising.gender[count] = gender;
		Supervising.eMail[count] = eMail;
		Supervising.birthYear[count] = birthYear;
		count++;
		}
		
	public static void printCustomerData(int index) {
		System.out.println("===========[고객 정보]===========");
		System.out.println("[이름] : "+ name[index]);
		System.out.println("[성별] : "+ gender[index]);
		System.out.println("[이메일] : "+ eMail[index]);
		System.out.println("[출생년도] : "+ birthYear[index]);
		System.out.println("=============================");
	}
	
	public static void updateCustomerData(int index) {
		System.out.println("=========[고객 정보 수정]=========");
		System.out.print("[이름(" + name[index] + ")]: ");
		name[index] = sc.next();
		System.out.print("[성별(" + gender[index] + ")]: ");
		gender[index] = sc.next();
		System.out.print("[이메일(" + eMail[index] + ")]: ");
		eMail[index] = sc.next();
		System.out.print("[출생년도(" + birthYear[index] + ")]: ");
		birthYear[index] = sc.nextInt();
		System.out.println("=============================");
	}	
	
	public static void deleteCustomerData(int index) {
		for (int i = index; i < count - 1; i++) {		
			name[i] = name[i+1];		// count의 값을 한 칸 씩 앞으로 이동시켜 덮어씌움
			gender[i] = gender[i+1];
			eMail[i] = eMail[i+1];
			birthYear[i] = birthYear[i+1];
		}
		count--;		// count로 줄이면 마지막 위치값이 변경됨
		}
		
	
	

	
	// main() 메소드를 통해 구현
	public static void main(String[] args) {
	// 메뉴 작성
		while (true) {
		System.out.printf("\n[Info] 고객 수 : %d, 인덱스 : %d\n", count, index+1);
		System.out.println("[메뉴]");
		System.out.println("(I)nsert \n(P)revious \n(N)ext \n(C)urrent \n(U)pdate \n(D)elete \n(Q)uit");
		System.out.print("[선택]>");
		String menu = sc.next();
		
		switch (menu.charAt(0)) {		//charAt(0) - 가장 첫 번째 문자를 봄
			case 'i', 'I' -> {
				System.out.println("[고객 정보 입력]");
			
				if (count >= MAX) {					// 저장된 데이터 개수가 데이터의 최대값을 넘어섰을 경우
					System.out.println("[데이터 저장 공간 부족]");
				}else {								// 아닌 경우
					insertCustomerData(); 			// 메소드를 통해 구현
					System.out.println("[저장 완료]");
				}
			}
			case 'p', 'P' -> {
				System.out.println("[이전 데이터 출력]");
				if (index <= 0) {			// 인덱스가 0보다 작을 경우 이전 데이터가 존재하지 않음
					System.out.println("[데이터가 존재하지 않음]");
				}else {
					// index를 이용하여 데이터 출력
					index--;
					printCustomerData(index);	// 인덱스 사용하여 데이터 출력하는 메소드
				}
			}
			case 'n', 'N' -> {
				System.out.println("[다음 데이터 출력]");
				if (index > count-1) {			//
					System.out.println("[데이터가 존재하지 않음]");
				}else {
					// index를 이용하여 데이터 출력
					index++;
					printCustomerData(index);	// 인덱스 사용하여 데이터 출력하는 메소드
				}
			}
			case 'c', 'C' -> {
				System.out.println("[현재 데이터 출력]");
				if ((index>=0)&&(index<count)) {
					printCustomerData(index);
				}else {
					System.out.println("[데이터가 선택되지 않음]");
				}
			}
			case 'u', 'U' -> {
				System.out.println("[데이터 수정]");
				if((index >= 0) && (index < count)) {
					updateCustomerData(index);			// 현재 인덱스의 자료를 수정하는 메소드
				}else {
					System.out.println("[수정할 데이터가 선택되지 않음]");
				}
			}
			case 'd', 'D' -> {
				System.out.println("[데이터 삭제]");
				if(index >= 0 && index < count) {
					deleteCustomerData(index);
					System.out.println("[데이터 삭제 완료]");
				}else {
					System.out.println("[삭제할 데이터가 선택되지 않음]");
				}
			}
			case 'q', 'Q' -> {
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