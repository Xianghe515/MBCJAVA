package quizzz456.obj;

public class Wizard extends Player {	// 정보를 적지는 않았지만 Player 클래스를 통해 상속받음

	public Wizard() {}
	
	public Wizard(String name, int hp, int mp) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
	}
	
	public Wizard(String name) {
		this(name, 500, 1000);
	}
	
	public void iceArrow() {
		System.out.println("얼음화살 사용");
	}
	
	public void blizzard(Player[] players) {
		System.out.println("------------------------");
		System.out.println(this.name + "님의 눈보라 시전!");
		// 향상된 for문 사용
		for (Player play:players) {
			// 10~15사이의 난수 생성
			int damage = (int)(Math.random()*6)+10;
			// hp 감소
			play.hp -= damage;
			// 감소 내용 출력
			System.out.println(play.name+ "님이 "+damage+" 피해를 입었습니다.");
		}
	}
	
	
	
	@Override
		public void action() {
		System.out.println("마법사는 귀여운 동작을 합니다.");
		}

	
	}



