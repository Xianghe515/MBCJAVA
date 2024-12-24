package quizzz456.obj;

public class Warrior extends Player {
		
	
	
		public Warrior() {}
		
		public Warrior(String name, int hp, int mp) {
			this.name = name;
			this.hp = hp;
			this.mp = mp;
	}
		public Warrior(String name) {
			this(name, 1000, 500);
		}
		
		
		public void bash(Player player) {
			
			// 만약 mp가 100 미만이면 스킬 동작 X
			if (mp<100) {
				System.out.println("mp가 모자라요.");
				return;
			}else {
				// 실행 시 mp 100 감소
				mp -= 100;
				
				if (player instanceof Warrior) {
					player.hp -= 100;
				}else if (player instanceof Wizard) {
					player.hp -= 200;
				}
			}System.out.println(player.name+"님 배쉬 스킬 적중");
			
		}	
		
		
			
		
		@Override
		public void action() {
		System.out.println("전사는 멋진 동작을 합니다.");
		}

}

