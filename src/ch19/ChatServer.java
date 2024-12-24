package ch19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	// 1. 필드 생성
	ServerSocket serverSocket;
	// 스레드풀 생성 - 서버이기 때문에 동시에 접근하지 못하도록
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	// 채팅 메시지 처리를 위한 객체 생성(채팅방)
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
	
	// 2. 생성자
	
	// 3. 메소드 - 서버 시작
	public void start() throws IOException {
		// ServerSocket 객체 생성
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 서버 시작");
		
		Thread thread = new Thread(()-> {
			try {
				while(true) {
					Socket socket = serverSocket.accept();
					// SocketClient 연결을 생성
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {}
		});
		thread.start();
	}
	
	// 메소드 :클라이언트 연결 시 SocketClient 생성 및 추가
	public void addSocketClient(SocketClient socketClient) {
		// key 생성하기 위해 chatname과 clientIP를 사용
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}
	
	// 메소드 : 클라이언트 연결 종료 시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감 : " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}
	
	// 메소드 : 모든 클라이언트에게 메시지 보냄
		public void sendToAll(SocketClient sender, String message) {
		// 메시지 전달방식은 JSON 형태로 생성
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		for(SocketClient sc : socketClients) {
			if(sc == sender) continue;	// continue로 본인인 경우는 제외	
			// 메시지 전달을 위한 메소드, SocketClient 내에
			sc.send(json);
		}
	}
	
	// 메소드 : 서버 종료
		public void stop() {
			// 객체 정리
			try {
				serverSocket.close();
				threadPool.shutdownNow();
				for(SocketClient sc : chatRoom.values()) {
					sc.close();		// SocketClient 정리
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	
	
	public static void main(String[] args) {
		// 서버 구동
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("───────────────────────────────────────────");
			System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
			System.out.println("───────────────────────────────────────────");
			
			Scanner scanner = new Scanner(System.in);
			while(true) {
				String key = scanner.nextLine();
				if(key.equals("q")) break;
			}
			scanner.close();
			chatServer.stop();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
		
	}

}
