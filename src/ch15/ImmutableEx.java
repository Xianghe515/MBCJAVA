package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableEx {

	public static void main(String[] args) {
		// 1. List 불변 컬렉션 생성
		List<String> immutableList1 = List.of("A", "B", "C");
//		immutableList1.add("D");
		
		// 2. Set 불변 컬렉션 생성
		Set<String> immutablesSet1 = Set.of("A", "B", "C");
//		immutableSet1.add("D");
		
		// 3. Map 불변 컬렉션 생성
		Map<Integer, String> immutableMap1 = Map.of(
				1, "A", 
				2, "B", 
				3, "C"
		);
//		immutableMap1.put(4, "D");
		System.out.println(immutableMap1);

		// copyOf() 메소드 -> 불변 컬렉션으로 만듦
		// 1. List 컬렉션을 불변 컬렉션으로 복사
		List<String> list = new ArrayList<String>();
		list.add("D");
		list.add("E");
		list.add("F");
		List<String> immutableList2 = List.copyOf(list);	// list를 불변 리스트로 만들어줌
//		immutableList2.add("A");
		
		// 1-1. immutable이었던 리스트를 다시 일반 리스트로 변경
		List<String> test = new ArrayList<String>(immutableList2);
		test.add("A");
		System.out.println(test);
		
		// 2. Set 컬렉션을 불변 컬렉션으로 복사
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutableSet2 = Set.copyOf(set);	// set을 불변 셋으로 만듦
//		immutalbeSet2.add("D");
		
		// 3. Map 컬렉션을 불변 컬렉션으로 복사
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);	// map을 불변 맵으로 만듦
		
		// 배열로부터 List 불변 컬렉션 생성
		String[] arr = {"A", "B", "C"};
		List<String> immutablelist3 = Arrays.asList(arr);	// 배열을 불변 리스트로 바꿔줌
//		immutablelist3.add("D");
		
		
		
	}

}
