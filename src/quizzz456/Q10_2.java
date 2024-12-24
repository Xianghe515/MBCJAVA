package quizzz456;

import quizzz456.obj.Player;
import quizzz456.obj.Warrior;
import quizzz456.obj.Wizard;

public class Q10_2 {

	public static void main(String[] args) {
		
		
		Warrior w1 = new Warrior("강한친구");
		Wizard w2 = new Wizard("구르미");
		Warrior me = new Warrior("나의 캐릭터");
		
		Player[] target = new Player[2];
			target[0] = w1;
			target[1] = me;
			
			// w2의 블리자드를 5번 실행
		for (int i=0; i<5; i++) {
//			w2.blizzard(target);
			w2.blizzard(new Player[] {w1, me});
		}
		
		System.out.println();
		w1.info();
		me.info();
		
		
		
	}

}
