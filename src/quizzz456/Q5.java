package quizzz456;

import quizzz456.obj.Player;
import quizzz456.obj.Warrior;
import quizzz456.obj.Wizard;

public class Q5 {

	public static void main(String[] args) {
		// Player 클래스에 일반화를 통해 공통 코드를 이용한 객체 생성
		// 이를 Wizard, Warrior 클래스에서 자식으로 받아서 사용 가능
		
		Wizard wiz = new Wizard();
		wiz.name = "구르미그린달빛";
		wiz.hp = 500;
		wiz.mp = 1000;
		System.out.println("-----마법사-----");
		wiz.info();
		wiz.iceArrow();
		
		
		Warrior war = new Warrior();
		war.name = "강한친구 대한전사";
		war.hp = 1000;
		war.mp = 500;
		System.out.println("-----전사-----");
		war.info();
//		war.bash();
		
		
		

	}

}