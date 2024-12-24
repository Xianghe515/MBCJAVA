package ch15;

import java.util.List;
import java.util.Vector;

public class ListEx2 {
	
	// Vector
	// 동기화된 메소드로 구성되어 있어 멀티 스레드가 동시에 Vector() 메소드를 실행 못하게 함
	// 멀티 스레드 환경에서 안전하게 객체를 추가 또는 삭제할 수 있게 만들어 줌
	
	public static void main(String[] args) {
		// Vector 컬렉션 생성
		List<Board>	list = new Vector<>();	// '이 List는 Board 객체만 가지고 있어요'
		
		for (int i=0; i<100; i++) {
			list.add(new Board("제목", "내용", "작성자"+i));
		}
		
		for(Board board : list) {
			System.out.println(board);
		}
		System.out.println("객체 객수 : " + list.size());
		
		
	}

}

class Board {	// 게시글 클래스
	// 1. 필드
	private String subject;
	private String content;
	private String writer;
	
	// 2. 생성자
	public Board() {}	// 기본 생성자
	
	public Board(String subject, String content, String writer) {	// 필드 생성자		*alt+shift+s -> Generate Constructor using Fields
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	// 3. 메소드
	// getter, setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "제목 : "+subject + ", 내용 : " +content +", 작성자 : " + writer;
	}
	
}