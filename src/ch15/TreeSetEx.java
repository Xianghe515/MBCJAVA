package ch15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {

	/*
	 * TreeSet : 이진 검색 트리**를 구현한 컬렉션
	 * 				  └ *모든 노드*는 최대 두 개의 자식 노드를 가질 수 있음		*값, 데이터 지점, 장치
	 * 				  └ 왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드
	 * 				  └ 노드의 추가・삭제는 오래 걸리지만 검색과 정렬은 빠름
	 *  - 순서가 있기 때문에 정렬이 가능한 Set
	 *  - 정렬 방법을 프로그래머가 Comparator 인터페이스를 이용하여 직접 지정이 가능
	 *  - 검색과 정렬에 뛰어난 성능을 가지고 있음(미리 정렬해서 저장) -> 저장 속도는 약간 느림
	 */
	public static void main(String[] args) {
		// TreeSet 객체 생성
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(9);
		tree.add(3);
		tree.add(17);
		tree.add(15);
		tree.add(21);
		tree.add(10);
		System.out.println(tree);

		// headSet(n) : n보다 머리쪽(왼쪽)에 있는 요소를 Set으로 반환(n 미포함)
		System.out.println(tree.headSet(9));
		
		// tailSet(n) : n부터 꼬리쪽(오른쪽)에 있는 요소를 Set으로 반환(n 포함)
		System.out.println(tree.tailSet(9));
		
		// subSet(start, end) : start 이상, end 미만의 요소를 Set으로 반환
		System.out.println(tree.subSet(1, 15));
		
		// pollFirst : 첫 번째 요소를 반환하면서 지움
		System.out.println(tree);				// [3, 9, 10, 15, 17, 21] 
		System.out.println(tree.pollFirst());	// 3 반환 후 삭제
		System.out.println(tree.pollFirst());	// 9 반환 후 삭제
		System.out.println(tree);				// [10, 15, 17, 21]
		
		// pollLast
		System.out.println(tree);				// [10, 15, 17, 21]
		System.out.println(tree.pollLast());	// 21 반환 후 삭제
		System.out.println(tree.pollLast());	// 17 반환 후 삭제
		System.out.println(tree);				// [10, 15]
		
		tree.add(19);
		tree.add(43);
		tree.add(14);
		tree.add(4);
		System.out.println(tree);		// [4, 10, 14, 15, 19, 43]
		// first()
		System.out.println("first() : " +tree.first());			// first() : 4
		// last()
		System.out.println("last() : " +tree.last());			// last() : 43
		// lower()
		System.out.println("lower(10) : " +tree.lower(10));		// lower(10) : 4
		// higher()
		System.out.println("higher(10) : " +tree.higher(10));	// higher(10) : 14
		
		// floor(10) : 12이거나 바로 아래 점수
		System.out.println("floor(12) : " +tree.floor(12));
		// ceiling(12) : 12이거나 바로 위 점수
		System.out.println("ceiling(12) : " +tree.ceiling(12));
		
		// 내림차순 정렬
		NavigableSet<Integer> descendingSet = tree.descendingSet();
		System.out.println(descendingSet);		// [43, 19, 15, 14, 10, 4]
		
		// subSet() 범위 검색 - 반환타입:NavigableSet
		descendingSet = tree.subSet(5, true, 17, false);	// 5 <= X < 17, true는 포함, false는 미포함
		for(Integer i : descendingSet) {
			System.out.println(i + " ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
