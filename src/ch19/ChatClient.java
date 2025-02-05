package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {

	// 필드
	Socket socket;
	// IO 처리를 보조스트림
	DataInputStream dis;
	DataOutputStream dos;
	// 챗 이름
	String chatName;
	
	// 메소드 : 서버 연결
	public void connect() throws IOException {
		// 연결을 위한 Socket 생성
		socket = new Socket("192.168.0.133", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		System.out.println("[클라이언트] 서버에 연결됨");
	}
	
	// 메소드 : JSON 데이터를 받기 위한 메소드
	public void receive() {		// 서버에서는 부하를 줄이기 위해 스레드풀 썼었음, 얘는 서버 아니라 안 씀
		Thread thread = new Thread(() -> {		
			try {
				while(true) {
					String json = dis.readUTF();	// JSON 형태의 문자열
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("[" + chatName + "@" + clientIp + "] " + message);
				}
			} catch (Exception e1) {
				System.out.println("[클라이언트] 서버 연결 끊김");
				System.exit(0);		// 프로세스 종료(프로그램 종료)
			}
		});
		thread.start();
	}
	
	// 메소드 : JSON 데이터 전송하기
	public void send(String json) throws IOException {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
			System.out.println("[메시지 전송 실패]"+e.getMessage());
		}
	}
	
	// 메소드 : 서버 연결 종료
	public void unconnect() throws IOException {
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			// ChatClient 객체 생성
			ChatClient chatClient = new ChatClient();
			// 서버 연결
			chatClient.connect();
			
			// 데이터 생성
			Scanner scanner = new Scanner(System.in);
			System.out.println("대화명 입력 : ");
			chatClient.chatName = scanner.nextLine();
			
			// JSON 데이터 생성
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);
			// 여기까지 대화방 참여
			
			// 서버가 보내는 JSON 정보 받기
			chatClient.receive();
			
			System.out.println("───────────────────────────────────────────");
			System.out.println("보낼 메시지를 입력하고 Enter");
			System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
			System.out.println("───────────────────────────────────────────");
			while(true) {
				// 반복적으로 메시지를 전송하는 과정 처리
				String message = scanner.nextLine();
				if(message.toLowerCase().equals("q")) {
					break;
				}else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			scanner.close();
			chatClient.unconnect();
			
		} catch (IOException e) {
			System.out.println("[클라이언트] 서버가 연결되지 않음");
		}

	}

}
