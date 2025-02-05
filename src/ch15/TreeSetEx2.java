package ch15;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetEx2 {
	
	// 일반 객체에 대한 비교
	// 	- Comparator, Comparable(일반 객체 내에서 선언)
	
	public static void main(String[] args) {
		// 1. TreeSet에 Comparator 사용하기
		TreeSet<GymMember> gym = new TreeSet<GymMember>(
				new Comparator<>() {	// 익명 객체 생성
			
			public int compare(GymMember o1, GymMember o2) {
				/*
				 * compare 메소드 사용법
				 * 	- return 1;  : o1과 o2의 자리를 바꿈
				 * 	- return 0;  : 같은 값임을 나타냄
				 * 	- return -1; : 자리 유지
				 */
				if(o1.name.charAt(0) < o2.name.charAt(0)) {
					return -1;
				}else if(o1.name.charAt(0) > o2.name.charAt(0)) {
					return 1;
				}else {
					return 0;	// Set이기 때문에 0이면 중복으로 간주해버림
				}
				
				
			}
		});

		gym.add(new GymMember("박지성", 1000));
		gym.add(new GymMember("김연아", 1001));
		gym.add(new GymMember("싸이", 1002));
		gym.add(new GymMember("봉준호", 1003));
		gym.add(new GymMember("조현아", 1004));
		gym.add(new GymMember("박찬호", 1005));
		gym.add(new GymMember("BTS", 1006));
		System.out.println(gym);	// .charAt으로 비교 - 똑같은 성을 가진 박찬호는 중복되어 같은 값이라고 여김 -> 출력x
		System.out.println("=======================================");
		TreeSet<GymMember> gym2 = new TreeSet<GymMember>();
		gym2.add(new GymMember("박지성", 1000));
		gym2.add(new GymMember("김연아", 1001));
		gym2.add(new GymMember("싸이", 1002));
		gym2.add(new GymMember("봉준호", 1003));
		gym2.add(new GymMember("조현아", 1004));
		gym2.add(new GymMember("박찬호", 1005));
		gym2.add(new GymMember("BTS", 1006));
		System.out.println(gym2);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

// GymMember 생성
// 2. Comparable을 사용한 객체 변경
class GymMember implements Comparable<GymMember> {
	
	// 필드
	String name;
	double height;
	double weight;
	int age;
	int memNum;
	
	// 생성자
	public GymMember(String name, int memNum) {
		this.name = name;
		this.memNum = memNum;
	}
	
	// 메소드
	@Override
	public String toString() {
		return String.format("%s [%d]", name, memNum);
	}
	
	@Override
	public int compareTo(GymMember o) {
		// CompareTo 메소드 사용법 (매개변수로 비교 대상을 전달받음)
		//	- return 1;  : 현재 인스턴스와 o의 자리를 바꿈
		//	- return 0;  : 같은 값임을 나타냄
		// 	- return -1; : 자리 유지
		
		int next = o.memNum;
		System.out.println(memNum + "vs" + next);
		if(memNum < next) {
			return -1;
		}else if(memNum > next) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	
}