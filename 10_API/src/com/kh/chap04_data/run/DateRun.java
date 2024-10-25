package com.kh.chap04_data.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateRun {
	public static void main(String[] args) {
		DateRun dr = new DateRun();
		dr.test4
		();
		/*
		 * Calendar: 날짜와 시간에 관한 데이터를 쉽게 처리 가능한 "추상클래스"
		 *
		 * */
	}
	
	public void test1() {
		//현재시간, 날짜정보를 조회
		Calendar cal1 = new GregorianCalendar();
		//getInstance():현재 컴퓨터 시스템상의 지역정보를 바탕으로 해당지역의 시간정보를 가져옴(그레고리력)
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println(cal1);
		System.out.println(cal1.get(Calendar.YEAR));
		System.out.println(cal1.get(Calendar.MONTH) +1); // 0부터 시작해서 +1이 필요
		System.out.println(cal1.get(Calendar.DATE));
		
		System.out.println(cal1.get(Calendar.HOUR));
		System.out.println(cal1.get(Calendar.MINUTE));
		System.out.println(cal1.get(Calendar.SECOND));
		
	}
	// 특정일 특정시간을 기준으로 Calendar 객체생성
	public void test2() {
		
		Calendar cal1 = Calendar.getInstance(); // 현재시간
		cal1.set(2025, 0, 1); // 0 = 1월 //25.01.01.
		System.out.println(cal1.get(Calendar.MONTH)+1);
		
		Calendar cal2 = new GregorianCalendar(2024,8,19 , 0, 0); // 8= 9월 // 24.09.19.
		
		// 날짜차이 계산하기
		Calendar now = Calendar.getInstance(); // 24.10.10.
		
		//현재 시간을 밀리초단위로 변환
		// 1970년1월1일부터 ~ 현재 시간까지의 밀리초를 반환
		// mills / 1s == 1000ms
		// day 1000(초)*60(분)*60(시)*24(일)
		long num1 = now.getTimeInMillis();
		long num2 = cal1.getTimeInMillis();
		
		long diff=(num2 - num1)/ 24/60/60/1000;
		System.out.println("새해까지 D-"+diff+"일 남았습니다");
		
	}
	
	// java.util.date
	// 날짜와 시간에 대한 정보는 담을 수 있는 클래스
	// 자바 개발 초창기에 급하게 만들어져 완성도가 높지는 않음
	public void test3() {
		
		// 기본 생성자를 통한 Date객체 생성
		// - 현재 날짜 및 시간 정보를 가지고 옴
		Date today = new Date();
		System.out.println("기본생성자: "+today);
		
		// 내가 원하는 날짜 (2024.06.19.)
		/*
		 *방법 1) 년,월,일 생성자를 통해 생성
		 *
		 * 년 설정방법: 내부적으로 내가 전달한 년도 + 1900, 셋팅하고자 하는 년 -1900
		 *
		 */
		 Date date1 = new Date(2024-1900, 6-1, 19);
		 System.out.println("매개변수 생성자: "+date1);
		
		 // 방법 2) mills초를 통한 객체생성
		 Calendar cal2 = new GregorianCalendar(2024, 6-1, 19, 19, 15, 30);
		 long millis = cal2.getTimeInMillis();
		 Date date2 = new Date(millis);
		 System.out.println("long 타입 생성자: "+date2);
		
	}
	
	public void test4() {
		/*
		 * SimpleDateFormat
		 * - "XXXX년 XX월 XX일 XX시 XX분 XX초"
		 * - Date객체를 활용하여 내가 원하는 형식의 시간을 설정한 문자열을 반환
		 *
		 * */
		// SimpleDateformat 객체 생성
		// 1. 출력형식을 지정하면서 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		// 2. sdf에서 제공하는 format매서드 호출시 매개변수로 Date객체를 전달
		String formatDate = sdf.format(new Date());
		System.out.println(formatDate);
		
		
	}
	
}
