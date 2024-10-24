package com.kh.practice.network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("호스트 명 : ");
			String hostName = sc.nextLine();

			InetAddress[] ips = InetAddress.getAllByName(hostName);

			System.out.println(hostName + "는 " + ips.length + "개의 IP주소를 가지고 있습니다.");

			for (int i = 0; i < ips.length; i++) {
				System.out.println((i + 1) + "번 IP = " + ips[i]);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
