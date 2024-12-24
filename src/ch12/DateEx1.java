package ch12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx1 {

	public static void main(String[] args) {
		// Date 클래스
		// Date 객체 생성
		Date now = new Date();	// java.util에서 생성		*java.sql 아님
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		// SimpleDateFormat : 시간을 원하는 형태로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm.ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}

}
