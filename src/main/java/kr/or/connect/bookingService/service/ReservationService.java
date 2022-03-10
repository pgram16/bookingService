package kr.or.connect.bookingService.service;

import java.util.List;

import kr.or.connect.bookingService.dto.ReservationInfo;
import kr.or.connect.bookingService.dto.ReservationInfoPrice;

public interface ReservationService {
	
	int INIT_CANCEL_FLAG = 0;
	ReservationInfo insertReservationInfo(ReservationInfo reservationInfo);
	List<ReservationInfo> getReservationInfos(String reservationEmail); 
	ReservationInfo cancleReservationInfo(Integer reservationId);
}
