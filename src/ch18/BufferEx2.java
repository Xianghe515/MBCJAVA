package ch18;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferEx2 {

	public static void main(String[] args) throws Exception {
		// BufferedReader
		BufferedReader br = new BufferedReader(
				new FileReader("src/ch18/BufferEx.java")
		);
				
		// 2. 데이터 처리
		int lineNo = 1;
		while(true) {
			String str = br.readLine(); // "\n"을 만나기 전까지 데이터를 읽기 처리함
			if(str == null) break;	// read()는 -1이, readLine()은 null이 없음을 의미
			System.out.println(lineNo + "\t" + str);
			lineNo ++;
		}

		// 3. close()
		br.close();
	}

}
