package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientEx1 {

	// 클라이언트 프로그램
	
	public static void main(String[] args) {
		try {
			// 1. Socket 생성
			//	- 방법 1) 생성자에 직접 입력하는 방법
//			Socket socket = new Socket("192.168.0.133", 50001);
			//	- 방법 2) 생성자 주입 정보 : InetSocketAddress 객체 사용
			Socket socket = new Socket();
			InetSocketAddress serverAddr = new InetSocketAddress("192.168.0.133", 50001);
			socket.connect(serverAddr);		// connect() 주어진 객체 주소로 연결을 시도하는 메소드
			
			System.out.println("[클라이언트] 연결을 성공했습니다.");
			
			// 2. 데이터 처리를 위한 작업
		// 서버에게 데이터 송신
			// 전송할 데이터 입력 받음
			String sendMessage = "久しぶり";
			// getoutputStream() : OupputStram 객체 반환 - 전송 시 내보낼 데이터 처리를 위한
			OutputStream os = socket.getOutputStream();
			// 보조 스트림 중 DataOutputStream
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(sendMessage);
			dos.flush();
			
//			byte[] bytes = sendMessage.getBytes("utf-8");
//			os.write(bytes);
//			os.flush();		// 다음 데이터를 위해 버퍼에 남아있는 것 정리
			System.out.println("[클라이언트] 데이터 송신 : " + sendMessage);
			
		// 서버로부터 데이터 수신
			InputStream is = socket.getInputStream();
			// 데이터 처리를 위한 공간 설정
			DataInputStream dis = new DataInputStream(is);
			String recieveMessage = dis.readUTF();
//			bytes = new byte[1024];
//			int readByteCount = is.read(bytes);
//			String message = new String(bytes, 0, readByteCount, "utf-8");
			System.out.println("[클라이언트] 데이터 수신 : " + recieveMessage);
			
//			 3. 연결 끊기 : Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결을 끊었습니다.");
			
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못된 경우
		} catch (IOException e) {
			// 서버에 연결하지 못하는 경우
			e.printStackTrace();
		}
		

	}

}
