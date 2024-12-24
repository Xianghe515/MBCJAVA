package ch8;

public class SealedInterfaceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplClass impl = new ImplClass();
		
		interfaceA ia = impl;
		ia.methodA();
		
		System.out.println();
		interfaceB ib = impl;				//		┌────C────┐
		ia.methodA();						//		│┌───B───┐│
		ib.methodB();						//		││	 A	 ││
											//		│└───────┘│
		System.out.println();				//		└─────────┘
		interfaceC ic = impl;				
		ia.methodA();
		ib.methodB();
		ic.methodC();
		

	}

}

// interfaceA
sealed interface interfaceA permits interfaceB {
	void methodA();
}

non-sealed interface interfaceB extends interfaceA {		// interfaceA로 부터 상속 받음
	void methodB();
}

interface interfaceC extends interfaceB {
	void methodC();
}

// 구현체
class ImplClass implements interfaceC {		// interfaceC로 한번에

	@Override
	public void methodB() {
		System.out.println("methodB() 실행");
		
	}

	@Override
	public void methodA() {
		System.out.println("methodA() 실행");
		
	}

	@Override
	public void methodC() {
		System.out.println("methodC() 실행");
		
	}
	
}
