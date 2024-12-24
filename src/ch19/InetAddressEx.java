package ch19;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressEx {

	public static void main(String[] args) {
		// InetAddress 객체는 통신을 위한 주소 정보를 처리하는 객체
		try {
			// 객체 생성 : InetAddress 객체 생성	* 객체 생성 방법 4가지
			//		1) getByName()
			System.out.println("───getByName()───");
			InetAddress ip = InetAddress.getByName("www.nate.com");
			System.out.println("hostname : " + ip.getHostName());
			System.out.println("IP : " + ip.getHostAddress());
			
			// 2. getAllByName() 객체 생성
			System.out.println("───getAllByName()───");
			InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
			for(InetAddress i : ips) System.out.println("IP 주소 : " + i);
			
			// 3. getLocalHost() 객체 생성 - Local은 현재 컴퓨터
			System.out.println("───getLocalHost()───");
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("현재 컴퓨터의 IP : " + local);
			System.out.println("현재 컴퓨터의 IP : " + local.getHostAddress());
			
			// 4. getByAddress() 객체 생성
			System.out.println("───getgetByAddress()───");
			InetAddress ip2 = InetAddress.getByAddress(ips[0].getAddress());
			System.out.println(ips[0].getHostName() + "주소 : " + ip2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			
		
		
	}

}
