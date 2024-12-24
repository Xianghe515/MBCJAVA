package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerEx2 {
	// TCP 서버 스레드풀 사용
	// 스레드 제한을 통한 서버 부하 줄이기
	
	// 스레드풀 생성(스레드 숫자 제한 : 10)
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	// ServerSocket 객체 멤버 생성
	private static ServerSocket serverSocket = null;
			
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("───────────────────────────────────────────");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("───────────────────────────────────────────");
		
		// TCP 서버 시작
		startServer();
		
		while(true) {
			String key = scan.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			public void run() {
				// 서버 작업을 위한 코드
				try {	// 입출력 예외를 위한 try-catch 사용
					// ServerSocket 생성 및 Port 바인딩
					// 1. 생성자를 이용한 포트 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("서버가 시작됩니다.");
					
					while(true) {	// 무한반복을 사용하는 이유 - 연결이 언제 될 지 모르기 때문
						System.out.println("\n[서버] 연결 요청을 기다리고 있습니다.\n");
						// 2. accept()를 이용해서 연결 수락을 기다림 -> 연결되면 Socket 객체를 반환
						Socket socket = serverSocket.accept();
						
						executorService.execute(()->{
							try {
								// 3. 서버 연결 후 작업
								// 연결된 클라이언트 정보 얻기
								InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
								System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락합니다.");
								
							// 클라이언트로부터 송신한 데이터 수신
								InputStream is = socket.getInputStream();	// InputStream 객체 안에 데이터를 저장
								// 데이터 처리를 위한 공간 설정
								DataInputStream dis = new DataInputStream(is);
								String recieveMessage = dis.readUTF();
								
//								byte[] bytes = new byte[1024];	// 버퍼(buffer) : 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역
//								int readByteCount = is.read(bytes);		// 끝 인덱스를 나타냄
////														   시작 인덱스┐		┌끝 인덱스
//								String message = new String(bytes, 0, readByteCount, "utf-8");
////												  버퍼 데이터 값┘							└우리가 쓰는 언어로 표현
								System.out.println("[서버] 데이터 수신 : "+ recieveMessage);
								
							// 클라이언트에게 데이터 송신
								// 전송할 데이터 입력 받음
								String sendMessage = "やだ";
								// getoutputStream() : OupputStram 객체 반환 - 전송 시 내보낼 데이터 처리를 위한
								OutputStream os = socket.getOutputStream();
								// DataOutputStream
								DataOutputStream dos = new DataOutputStream(os);
								dos.writeUTF(sendMessage);
								dos.flush();
//								bytes = sendMessage.getBytes("utf-8");
//								os.write(bytes);
//								os.flush();
								System.out.println("[서버] 데이터 송신 : " + sendMessage);
								
								// 4. 연결 끊기
								socket.close();
								System.out.println("[서버] " + isa.getHostName() + "와(과)의 연결이 끊어졌습니다.");
								
							} catch (IOException e) {
								// TODO: handle exception
							}
						});
					}
					
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		
		// 스레드 시작
		thread.start();
		
	}
	
	public static void stopeServer() {
		try {
			// ServerSocket을 닫고 port 언바인딩
			serverSocket.close();
			executorService.shutdownNow();
			System.out.println("[서버] 종료되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
