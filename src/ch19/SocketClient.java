package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	
	// 필드
	ChatServer chatServer;
	Socket socket;
	// 채팅 이름과 clientIP
	String clientIp;
	String chatName;
	// 데이터(채팅 내용)를 저장하기 위해 IO 객체 생성
	DataInputStream dis;	
	DataOutputStream dos;
	
	// 생성자
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			// socket에 있는 데이터를 처리하기 위한 객체 초기화
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			// clientIp 생성
			InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
			this.clientIp = isa.getAddress().getHostAddress();
			// JSON 받기 처리
			clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {}

	}
	
	// 메소드 : JSON 받기
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while(true) {
					String receiveJson = dis.readUTF();
					
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");
					
					switch(command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						// this - 현재 객체
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
				
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}
	
	// 메소드 : 메시지 전달(json 양식을 전달)
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (Exception e) {}
	}
	
	// 메소드 : 연결 종료
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {}
	}

}