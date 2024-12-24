package ch15;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

	// FIFO(선입선출) 형식의 자료구조 데이터
	
	public static void main(String[] args) {
		// queue 객체 생성
		Queue<Integer> que = new LinkedList<Integer>();
		// LinkedList가 Queue 구현 대표 클래스
		
		// 데이터의 추가 : offer() 혹은 add()	도 사용 가능	*collection 타입이기 떄문
		que.offer(100);
		que.offer(200);
		que.add(300);
		que.add(400);
		System.out.println(que.toString());
		System.out.println(que.remove(200));	// remove(인자)에 인자가 있는 경우 해당 인자 삭제, 없는 경우 맨 앞 데이터 제거
		System.out.println(que);
		System.out.println();
		
		while(!que.isEmpty()) {					// que가 비어있지 않다면
			System.out.println(que.poll());
		}
		
		
		
		
		
		
		
	}

}
