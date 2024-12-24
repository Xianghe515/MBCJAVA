package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class InputStreamReaderEx {

	public static void main(String[] args) throws Exception {
		// 문자 변환 스트림
		write("문자 변환 스트림을 사용합니다.");
		read();

	}


	public static void write(String str) throws Exception {
		// 1. 객체 생성
		// 기본 입출력 객체(OutputStream)
		OutputStream os = new FileOutputStream("D:/Temp/test.txt");
		os.write(str.getBytes());
		os.close();
//		Writer writer = new OutputStreamWriter(os, "UTF=8");
//		writer.write(str);
//		writer.flush();
//		writer.close();
		
		
		
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream("D:/Temp/test.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		System.out.println(data);
		String str = new String(data, 0, num);
		System.out.println(str);
//		while(true) {
//			int data = is.read();
//			if(data == -1) break;
//			System.out.println((char)data);
//		}
//		is.close();
		return null;
	}
	
}