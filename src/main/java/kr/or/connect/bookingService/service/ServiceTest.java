package kr.or.connect.bookingService.service;

import java.util.Calendar;
import java.util.Date;

public class ServiceTest {

	public static void main(String[] args) {
		Date date = new Date();
		
		for(int i=0;i<100;i++){
			int randomDay = (int)(Math.random()*100)%6;
			System.out.println(">>>>>>>>>>>>>>>randomDay " + randomDay);
		}
	}
	
	public static Date getDate(Date date, int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

}
