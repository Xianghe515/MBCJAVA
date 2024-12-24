package ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListEx3 {

	public static void main(String[] args) {
		// ArrayList
		List<String> list1 = new ArrayList<String>();
		
		// LinkedList
		List<String> list2 = new LinkedList<String>();

		long startTime;		// 시작 시간
		long endTime;		// 종료 시간
		// ArrayList 컬렉션에 저장하는 시간 측정
		startTime = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			list1.add(0, String.valueOf(i));		// 추가를 통해 ArrayList 내 변동이 일어나게끔 만듦
		}
		endTime = System.currentTimeMillis();
		System.out.printf("%-17s %8d ms \n", "ArryaList 걸린 시간 : ", endTime-startTime);
		
		// LinkedList 컬렉션에 저장하는 시간 측정
		startTime = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			list2.add(0, String.valueOf(i));		// 추가를 통해 LinkedList 내 변동이 일어나게끔 만듦
		}
		endTime = System.currentTimeMillis();
		System.out.printf("%-17s %8d ms \n", "LinkedList 걸린 시간 : ", endTime-startTime);
		
		// ArrayList - 검색 등 데이터를 찾는 작업은 빠름
		// LinkedList - 데이터의 양이 많아질수록 컬렉션 내 수정 및 작업 시간 ArrayList보다 빠름
		
		
		
		
		
		
	}

}
