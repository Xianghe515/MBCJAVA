package quizzz456;

import quizzz456.obj.Warrior;
import quizzz456.obj.Wizard;

public class Q10 {

	public static void main(String[] args) {
		
		Warrior me = new Warrior("강한친구대한전사");
		
		Wizard play2 = new Wizard("구르미그린마법사");
		Warrior play3 = new Warrior("전사약해요");
				
		System.out.println("---나의 케릭 배쉬스킬 사용---");
		me.bash(play2);
		me.bash(play3);
		
		me.bash(play2);
		me.bash(play3);
		
		play2.info();
		play3.info();
	}

}
