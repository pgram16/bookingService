package kr.or.connect.bookingService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.ReservationCommentDao;
import kr.or.connect.bookingService.dto.ReservationComment;
import kr.or.connect.bookingService.dto.ReservationCommentImage;
import kr.or.connect.bookingService.service.ReservationCommentService;

@Service
public class ReservationCommentServiceImpl implements ReservationCommentService {
	
	private ReservationCommentDao reservationCommentDao;
	
	public ReservationCommentServiceImpl(ReservationCommentDao reservationCommentDao) {
		this.reservationCommentDao = reservationCommentDao;
	}

	@Override
	public List<ReservationComment> getReservationComments(Integer displayInfoId) {
		
		StringBuffer sb = new StringBuffer();
		
		List<ReservationComment> comments = reservationCommentDao.getReservationComments(displayInfoId);

		for(ReservationComment comment : comments) {
			comment.setCommentImages( this.getReservationCommentImages(comment.getReservationInfoId(), comment.getCommentId()) );

			comment.setReservationEmail(sb.append(comment.getReservationEmail().split("@")[0].substring(0, 4)).append("****").toString());
			sb.delete(0, sb.length());
		}
		
		return comments;
	}
	
	@Override
	public Float getAvgScore(Integer displayInfoId) {
		
		Float avgScore = reservationCommentDao.getReservationScoreAvg(displayInfoId);

		return avgScore;
	}

	@Override
	public List<ReservationCommentImage> getReservationCommentImages(Integer reservationInfoId, Integer commentId) {
		return reservationCommentDao.getReservationCommentImages(reservationInfoId, commentId);
	}


}
