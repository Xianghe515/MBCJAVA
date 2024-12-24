package ch18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamEx {

	public static void main(String[] args) throws Exception {
		// DataInputStream, DataOutputStream
		// 보조스트림을 연결하면 기본타입 값을 입출력으로 사용 가능
		// 					└ boolean, char, short, int, long, float, double

		// 1. 객체 생성
		// 기본
		FileOutputStream fos = new FileOutputStream("D://Temp/primitive.db");
		// 보조
		DataOutputStream dos = new DataOutputStream(fos);
		
		// 기본 타입 출력 - ※주의 - 데이터 순서 주의
		dos.writeUTF("홍길동");		// a 문자열
		dos.writeDouble(95.6);		// b 실수
		dos.writeInt(1);			// c 정수
		
		dos.writeUTF("김갑순");
		dos.writeDouble(90.2);
		dos.writeInt(2);
		
		dos.flush();
		dos.close();
		fos.close();
		
		// DataInputStream 생성
		FileInputStream fis = new FileInputStream("D://Temp/primitive.db");
		DataInputStream dis = new DataInputStream(fis);
		
		// 만약 데이터 순서를 지키지 않는다면
//		for(int i=0;i<2;i++) {
//			String name = dis.readUTF();		// a 문자열
//			int order = dis.readInt();			// c 정수
//			double score = dis.readDouble();	// b 실수
//			System.out.println(name + " : " + score + " : " + order);
//		}
//		결과 	홍길동 : 1.9035980475658475E185 : 1079502438
//			김갑순 : -9.255964115728932E61 : 1079413964
//		=> 이상한 값 나옴
		
		// 기본 타입 입력
		for(int i=0;i<2;i++) {
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}
		dis.close();
		fis.close();
		
		
		
		
	}

}
