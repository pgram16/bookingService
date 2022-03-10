package kr.or.connect.bookingService.service.impl;


import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.ReservationDao;
import kr.or.connect.bookingService.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private ReservationDao reservationDao;
	
	public LoginServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	@Override
	public Integer getCountResevationHistory(String email) {
		return reservationDao.countReservationUsingEmail(email);
	}

}
