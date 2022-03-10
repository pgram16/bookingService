package kr.or.connect.bookingService.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.bookingService.config.ApplicationConfig;
import kr.or.connect.bookingService.dto.ReservationInfo;
import kr.or.connect.bookingService.dto.ReservationInfoPrice;

public class DaoTest {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ReservationDao dao = ac.getBean(ReservationDao.class);
		/*
		ReservationInfo info = new ReservationInfo();
		info.setProductId(1);
		info.setDisplayInfoId(1);
		info.setReservationName("박가람");
		info.setReservationEmail("pgram16@naver.com");
		info.setReservationTel("010-5865-5555");
		info.setCancelFlag(1);
		info.setCreateDate(new Date());
		info.setReservationDate(new Date());
		info.setModifyDate(new Date());
		
		
		Integer id = dao.insertReservationInfo(info);
		System.out.println("id : " + id);
		 */
		
		ReservationInfoPrice price= new ReservationInfoPrice();
		price.setCount(9);
		price.setReservationInfoId(16);
		price.setProductPriceId(1);
		
		dao.insertReservationInfoPrice(price);
	}

}
