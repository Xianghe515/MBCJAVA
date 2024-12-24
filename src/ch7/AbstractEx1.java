package ch7;

import ch7.Shape.Circle;
import ch7.Shape.Rectangle;

/*
 * abstract - 추상 클래스는 추상 메소드를 포함, 인스턴스화 할 수 없음
 * 
 * 추상 메소드는 선언한 부분에서 구현하지 않고 상속 받은 자식 클래스에서 사용됨
 */

//도형 클래스(추상 클래스)
abstract class Shape {
	
//1. 필드(멤버 변수)
private int x;
private int y;
	
//2. 생성자
public Shape() {}
public Shape(int x, int y) {
this.x = x;
this.y = y;
}

//3. 메소드
public String position() {
return "[x ="+x+ ", y ="+y+"]";
}

//추상 메소드 - 추상 메소드가 있는 경우 해당 클래스는 반드시 추상 클래스가 되어야 함
public abstract double getArea();		// 도형의 넓이를 구하는 공식은 다 다름 -> 자식 클래스에서 재정의 하여 사용

// 추상 클래스를 상속받은 클래스
class Circle extends Shape {		// The type Shape. Circle must implement the inherited abstract method Shape.getArea()
	
	// 1. 필드
	private int radius;
	
	// 2. 생성자
	public Circle(int r) {
		this(0, 0, r);
	}
	public Circle(int x, int y, int r) {
		super(x, y);	// 부모 클래스의 생성자
		this.radius = r;
	}
	// 3. 메소드
	@Override
	public double getArea() {			// 추상 메소드에 대한 구현
		return (Math.PI * radius * radius);		// *원 넓이 = 반지름 제곱 x 3.14
	}
}

// 사각형
class Rectangle extends Shape {
	
	// 1. 필드
	private int width;
	private int height;
	
	// 2. 생성자
	public Rectangle() {}
	
	public Rectangle(int w, int h) {
		this(0, 0, w, h);
	}
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);	// 부모 클래스의 생성자
		this.width = w;
		this.height = h;
	}
	// 3. 메소드
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (width * height);
	}
}
}


public class AbstractEx1 {
			
	public static void main(String[] args) {
		// 추상 클래스 테스트
		// 추상 클래스는 인스턴스화 할 수 없다.
//		Shape shape = new Shape(0, 0);
		
		// 자식이 아닌 클래스로 객체 생성 시 익명 클래스*로 생성 가능		*클래스를 만들어서 사용하기는 애매 -> 현재만 사용할 객체를 만드는 경우
//		Shape shape = new Shape() {		// anonymous inner type
//			
//			@Override
//			public double getArea() {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};		
		
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(10);
		shapes[1] = new Rectangle(5,10);
		
		for (Shape s: shapes) {
			System.out.println("도형의 넓이"+s.getArea());
		}
		
	}
}


