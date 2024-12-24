package test; 
/*
 * 24.11.21 추가
 * 데이터 저장 방법
 * 	1. 텍스트를 이용한 저장
 * 		- String.split()
 * 					└ 예) CSV - ','를 이용하여 값을 분리
 * 	2. 데이터 타입을 저장
 * 		- DataInputStream, DataOutputStream
 * 	3. ObjectInputStream, ObjectOutputStream
 */
import java.util.ArrayList;
import java.util.Scanner;

import test.obj.Customer;

public class asd {
	static ArrayList<Customer> cusList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static int count;

	public static void insertCustomerData() {
		System.out.println("[이름] : ");
		String name = scan.next();
		System.out.println("[성별] : ");
		String gender = scan.next();
		System.out.println("[이메일] : ");
		String email = scan.next();
		System.out.println("[출생년도] : ");
		int birthYear = scan.nextInt();

		Customer cus = new Customer(name, gender, email, birthYear);
		
		cusList.add(cus);
		count++;
	}

	public static void printCustomerData(Customer cus) {
		System.out.println("─────[고객 정보]─────");
		System.out.println(cus.toString());
		System.out.println("───────────────────");
	}

	public static Customer selectCustomerData() {
		while (true) {
			System.out.println("[고객 이름 입력]");
			String name = scan.next();
			for(Customer cus : cusList) {
				if(name.equals(cus.getName())) {
					return cus;
				}
			}
			System.out.println("[존재하지 않는 고객 정보]");
		}

	}

	public static void updateCustomerData(Customer cus) {
		System.out.println("─────[고객 정보 수정]─────");
		System.out.println("이름(" + cus.getName() + ") :");
		String originalName = scan.next();
		cus.setName(originalName);
		System.out.println("성별(" + cus.getGender() + ") :");
		cus.setGender(scan.next());
		System.out.println("이메일(" + cus.getEmail() + ") :");
		cus.setEmail(scan.next());
		System.out.println("출생년도(" + cus.getBirthYear() + ") :");
		cus.setBirthYear(scan.nextInt());
		System.out.println("───────────────────────");
	}

	public static void deleteCustomerData(Customer cus) {
		cusList.remove(cus);
		System.out.println("[삭제 완료]");
		count--;
	}

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n[Info] 고객 수 : " + count + "]\n");
			System.out.println("[메뉴]");
			System.out.println("(I)nsert \n(S)elect \n(U)pdate \n(D)elete \n(Q)uit");
			System.out.println("[선택]>");
			String menu = scan.next();
			menu = menu.toLowerCase();

			switch (menu.charAt(0)) {
			case 'i', 'ㅑ' -> {
				System.out.println("[고객 정보 입력]");
				insertCustomerData();
			}
			case 's', 'ㄴ' -> {
				System.out.println("[고객 정보 출력]");
				if (count > 0) {
					printCustomerData(selectCustomerData());
				} else {
					System.out.println("[존재하지 않는 고객 정보]");
				}
			}
			case 'u', 'ㅕ' -> {
				System.out.println("[고객 정보 수정]");
				if (count > 0) {
					updateCustomerData(selectCustomerData());
				} else {
					System.out.println("[존재하지 않는 고객 정보]");
				}
			}
			case 'd', 'ㅇ' -> {
				System.out.println("[고객 정보 삭제]");
				if (count > 0) {
					deleteCustomerData(selectCustomerData());
				} else {
					System.out.println("[존재하지 않는 고객 정보]");
				}
			}
			case 'q', 'ㅂ' -> {
				System.out.println("[종료]");
				scan.close();
				System.exit(0);
			}
			default -> {
				System.out.println("[오류]");
			}
			}
		}

	}

}
