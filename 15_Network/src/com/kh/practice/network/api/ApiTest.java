package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTest {
	public static void main(String[] args) {
		try {
			String address = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
			String serviceKey = "ucjAiRoZM8CbOWPnZbQuOUZfw0631HfR%2FO1sMkLWsdEdgSlbZJc%2BsYDp262Q52utVuAz4y%2FXH0ZfwpKXebw9YA%3D%3D";
			String stationName = "종로구";
			String dataTerm = "Daily";
			address += "?serviceKey=" + serviceKey;
			address += "&stationName=" + URLEncoder.encode(stationName, "UTF-8");
			address += "&dataTerm=" + dataTerm;
			URL url = new URL(address);
			
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			
			br.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
