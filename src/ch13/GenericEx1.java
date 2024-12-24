package ch13;

public class GenericEx1 {

	public static void main(String[] args) {
		// 타입을 지정하는 <T>, T
		// Box<String> box1 = new Box<String>();
		// class box에서 선언한 T에 String이 들어감
		Box<String> box1 = new Box<>();
//		box1.content = 1; - T content -> String conten로 변했기 때문에 다른 타입 입력 불가
		box1.content = "안녕";
		String str = box1.content;
		System.out.println(str);
		
		// Box<Integer> box2 = new Box<Integer>();
		Box<Integer> box2 = new Box<>();
		box2.content = 100;
		int value= box2.content;
		System.out.println(value);
		
		// generic 지정하지 않으면 타입은 Object로 지정(암묵적으로)
		Box box3 = new Box();
		box3.content = "안녕하신가";
		String hi = (String)box3.content;
		box3.content = 100;
		int value2 = (Integer)box3.content;
		System.out.println(hi);
		System.out.println(value2);
		
	}

}


class Box<T> {
	public T content;
}