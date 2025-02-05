package ch18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BuffereEx {

	public static void main(String[] args) throws Exception {
		// 1. 입출력 스트림 생성
		String originalFilePath1 = "D:/Temp/testImg.jpg";
		String targetFilePath1 = "D:/Temp/normalTestImage.jpg";
		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
		
		// 입출력 스트림 + 버퍼 스트림 생성
		String targetFilePath2 = "D:/Temp/bufferedTestImage.jpg";
		FileInputStream fis2 = new FileInputStream(originalFilePath1);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		// 버퍼 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		// 버퍼 사용하지 않고 복사
		long nonBufferedTime = copy(fis, fos);
		System.out.println("버퍼 미사용 : \t" + nonBufferedTime + " ns");
		
		// 버퍼 사용하고 복사
		long BufferedTime = copy(bis, bos);
		System.out.println("버퍼 사용 : \t" + BufferedTime + " ns");
	}
	
	// 복사 작업을 진행하고 반환값으로 걸린 시간을 넘김
	public static long copy(InputStream is, OutputStream os) throws Exception {
		// 시작 시간 저장
		long start = System.nanoTime();
		
		// 1바이트 데이터를 읽고 1바이트 출력
		while(true) {
			int data = is.read();
			if(data == -1) break;
			os.write(data);
		}
		os.flush();
		//끝 시간 저장
		long end = System.nanoTime();
		return(end - start);
	}
}
