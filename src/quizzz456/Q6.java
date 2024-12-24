package quizzz456;

import quizzz456.obj.Warrior;
import quizzz456.obj.Wizard;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----마법사-----");
		Wizard wiz = new Wizard();
		wiz.action();
		System.out.println("-----전사-----");
		Warrior war = new Warrior();
		war.action();
	}

}
