package ch19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClientEx1 {

	public static void main(String[] args) {
		try {
			// 1. DatagramSocket 생성
			DatagramSocket datagramSocket = new DatagramSocket();
			
			// 2. 데이터 생성(DatagramPacket에 저장할)
			// 구독하고 싶은 뉴스 주제 보내기
			String data = "경제";
			byte[] bytes = data.getBytes("utf-8");
			// DatagramPacket 객체로 보낼 데이터 생성
			DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("192.168.0.133", 50002));
			datagramSocket.send(sendPacket);
			
			while (true) {
			// 3. 데이터 받기 처리
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);
				
			// 4. 받은 데이터 처리
				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "utf-8");
				System.out.println(news);
				
			// while 탈출
				if (news.contains("뉴스10")) {	// news에 "뉴스10"이 포함되어 있으면
					break;
				}
			}
			
			// DatagramSocket 닫기 처리
			datagramSocket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
