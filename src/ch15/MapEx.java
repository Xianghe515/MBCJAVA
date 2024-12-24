package ch15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapEx {

	/*
	 * Map
	 * 	- key-value 쌍으로 만들어지는 데이터
	 * 	- key를 이ㅐ용해서 value를 참조하여 작업
	 * 	- key는 중복 불허 	*만약 같은 키를 사용하여 값을 대입하면 변경(갱신)
	 *  - key와 value는 1:1 관계
	 * 	- 주요 메소드
	 * 		- put(key, value) : 주어진 키와 값을 추가. 저장 시 값 리턴
	 * 		- containsKey(key) : 주어진 key 있는지 여부 확인
	 * 		- containValue(value)
	 * 		- Set<Map.Entry<K, V>> entrySet() : 키와 값을 쌍으로 구성된 모든 Map.entry를 Set에 담아 리턴	* key는 중복되면 안 되기 때문에 set
	 * 		- get(key) : 주어진 키의 값을 리턴
	 * 		- isEmpty() : 컬렉션이 비어 있는지 확인
	 * 		- Set<K> keySet() : 컬렉션에 있는 모든 키 값을 담아 리턴
	 * 		- size() : 컬렉션 내 키의 개수
	 * 		- values() : 저장된 모든 값을 Collection<V>로 리턴
	 * 		- clear() : 모든 Map.Entry(키와 값) 삭제
	 * 		- remove(key) : 주어진 키와 일치하는 Map.Entry 삭제. 삭제 시 값 리턴
	 */
	public static void main(String[] args) {
		// HashMap
		//  - 넣은 순서와 관계 없는 순서로 저장됨
		//	- key를 통해 값을 찾는(검색하는) 속도가 Map 중 가장 빠름

		Map<String, Integer> map = new HashMap<>();
		Map map2 = new HashMap();	// key와 value가 모두 오브젝트임
		
		map.put("홍길동", 99);
		map.put("임꺽정", 93);
		map.put("ABC", 123);
		map.put("FF", 123);
		map.put("홍길동", 88);	// 이미 있는 키에 값을 넣은 경우 덮어씀(갱신)	* key가 중심임
		
		System.out.println(map);	// *결과값 {}으로 출력 - 파이썬의 dict과 유사
		
		// get(key) : 키를 넣으면 그에 해당하는 값을 반환
		System.out.println(map.get("홍길동"));
		System.out.println(map.get("임꺽정"));
		
		// keySet() : Map의 모든 키들을 Set으로 반환
		for(String key : map.keySet()) {
			System.out.printf("%s : %d \n", key, map.get(key));
		}
		
		// entrySet() : Map의 entrySet을 반환		*[k=v, k=v, ...]의 형태
		System.out.println(map.entrySet());
		for(Entry<String, Integer> entry: map.entrySet()) {
			// Entry 인터페이스의 메소드, getKey(), getValue()
			System.out.println(entry.getKey() + " : ");
			System.out.println(entry.getValue());
			
		}
		
		// values() : Map에 있는 모든 값들을 Collection 타입으로 반환
		System.out.println(map.values());
		// 리스트로 받아서 처리하고 싶은 경우
		List<Integer> list = new ArrayList<Integer>(map.values());		// 결과값 :  [123, 123, 88, 93] 	- 컬렉션 타입
		System.out.println(list);										// 결과값 : [123, 123, 88, 93]	- 리스트
		
		// containsKey(key) : key가 포함되어 있는지 여부 확인
		System.out.println(map.containsKey("홍길동"));		// 결과값 : true
		System.out.println(map.containsKey(10));			// 결과값 : false
		
		// containsValue(value) : value가 존재하는지 여부 확인
		System.out.println(map.containsValue(88));			// 결과값 : true
		
		// remove(key)
		System.out.println("삭제 후 반환 값 : "+ map.remove("홍길동"));		// 결과값 : 88 	*remove(key) 삭제 시 value가 반환됨
		System.out.println(map);
		map.clear();
		System.out.println(map.isEmpty());	// 결과값 : true	*isEmpty() : 맵이 비어있는지 확인
		
		map2.put(0, 10);
		map2.put('1', 20);
		map2.put(2, 30);
		map2.put(3.3, 40);
		System.out.println(map2);
		
		System.out.println(map2.get(0));
		System.out.println(map2.get(1));	// 결과값 : null	* 키가 없기 때문에 연결된 값이 없음
		System.out.println(map2.get('1'));	// 결과값 : 20
		
		
		
		
		
		
	}

}
