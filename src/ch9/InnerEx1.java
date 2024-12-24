package ch9;

import java.awt.Color;	//윈도우창 color 클래스
import java.awt.Frame;	//Frame클래스
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;	//랜덤난수클래스

// GUI - 인터페이스를 그래픽화하여 작동시키는 것을 말함
	// 자바의 GUI
	//	- AWT - 만들기 쉽지만 무거움
	//	- Swing - 만들기는 어렵지만 가벼움
	// Frame 또는 JFrame 클래스를 사용하여 GUI 작업을 진행
	// 프레임 창을 구현 -> 각종 이벤트 처리, 버튼, 패널, 입력창, 메뉴바, 속성 등 요소를 각 클래스를 이용하여 구현
	// A라는 Frame 클래스 각종 구성 요소 클래스들을 전부 호출. 구성 요소인 클래스들은 각 프레임 창별로 달라짐
	// 	-> 개별 클래스화 하게 되면 여러가지 측면에서 낭비가 발생하게 됨

public class InnerEx1 {
	
	// 필드
	private Frame f;
	
	// 생성자
	public InnerEx1() {
		f = new Frame("Inner 예제");	// 창이름
	}
	
	// 메소드
	public void launchFrame() {
		// frame 창에 대한 속성 지정
//		f.addWindowListener(new MyWindowAdapter());
		// 익명 사용
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		f.setSize(300, 300);
		f.setVisible(true);
		
	}
	
public static void main(String[] args) {
	InnerEx1 ie = new InnerEx1();
	ie.launchFrame();
	}
}

class MyWindowAdapter extends WindowAdapter {
	
	// 창에 X 버튼 클릭 시
	public void windowClosing(WindowEvent e) {
		System.exit(0); 	// 시스템 종료
	}
}