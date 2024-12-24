package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class ObejectInputOutputStreamEx {

	public static void main(String[] args) throws Exception {
		// ObjectInputStream, ObjectOutputStream
		// 1. 스트림 객체 생성 후 보조 스트림 연결
		FileOutputStream fos = new FileOutputStream("D:/Temp/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// 2. 객체 생성
		Member m1 = new Member("winter", "눈꽃송이");
		Product p1 = new Product("컴퓨터", 1000000);
		int[] arr1 = { 1, 2, 3, 4 };

		oos.writeObject(m1);
		oos.writeObject(p1);
		oos.writeObject(arr1);

		// 버퍼 정리 및 close;
		oos.flush();
		oos.close();
		fos.close();

		// FileInputStream에 ObjectInputStream 보조 연결
		FileInputStream fis = new FileInputStream("D:/Temp/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// 파일을 읽고 역직렬화로 객체 복원
		Member m2 = (Member) ois.readObject();
		Product p2 = (Product) ois.readObject();
		int[] arr2 = (int[]) ois.readObject();

		ois.close();
		fis.close();
		System.out.println(m2);
		System.out.println(p2);
		System.out.println(Arrays.toString(arr2));

	}

}

class Member implements Serializable { // 직렬화 인터페이스
	// ┌ 상수 ┌ 객체를 구분하기 위한 고유값
	private static final long serialVersionUID = -1931982038194863371L;
	// └ 겹치지 않게 가장 범위가 큰 long으로
	// 1. 필드
	private String id;
	private String name;

	// 2. 생성자
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// 3. 메소드
	@Override
	public String toString() {
		return id + " : " + name;
	}
}

class Product implements Serializable {

	private static final long serialVersionUID = -7041165767628801237L;

	// 1. 필드
	private String name;
	private int price;

	// 2. 생성자
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// 3. 메소드
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + price;
	}

}