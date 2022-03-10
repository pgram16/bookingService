package kr.or.connect.bookingService.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookingService.dao.DisplayDao;
import kr.or.connect.bookingService.dao.ReservationDao;
import kr.or.connect.bookingService.dto.Display;
import kr.or.connect.bookingService.dto.ReservationInfo;
import kr.or.connect.bookingService.dto.ReservationInfoPrice;
import kr.or.connect.bookingService.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private ReservationDao reservationDao;
	private DisplayDao displayDao;
	
	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao, DisplayDao displayDao){
		this.reservationDao = reservationDao;
		this.displayDao = displayDao;
	}

	@Override
	@Transactional(readOnly=false)
	public ReservationInfo insertReservationInfo(ReservationInfo reservationInfo) {

		reservationInfo.setCancelFlag(INIT_CANCEL_FLAG);
		reservationInfo.setCreateDate(new Date());
		reservationInfo.setModifyDate(new Date());
		reservationInfo.setReservationDate(reservationInfo.getReservationYearMonthDay());
		
		int id = reservationDao.insertReservationInfo(reservationInfo);
		reservationInfo.setReservationInfoId(id);
		
		for(ReservationInfoPrice v : reservationInfo.getPrices()){
			v.setReservationInfoId(id);
			int priceId = reservationDao.insertReservationInfoPrice(v);
			v.setId(priceId);
		}
		
		return reservationInfo;
	}

	@Override
	public List<ReservationInfo> getReservationInfos(String reservationEmail) {
		List<ReservationInfo> reservations = reservationDao.getReservationInfos(reservationEmail);
		
		for(ReservationInfo v: reservations){
			Display display = displayDao.selectDisplayInfo(v.getDisplayInfoId());
			v.setDisplayInfo(display);
		}
		
		return reservations;
	}

	@Override
	@Transactional(readOnly=false)
	public ReservationInfo cancleReservationInfo(Integer reservationId) {
		reservationDao.updateCancleFlag(reservationId);
		
		ReservationInfo reservationInfo = reservationDao.getReservationInfo(reservationId);
		List<ReservationInfoPrice> prices = reservationDao.getReservationInfoPrices(reservationId);
		reservationInfo.setPrices(prices);
		
		return reservationInfo;
	}


}
