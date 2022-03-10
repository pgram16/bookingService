package kr.or.connect.bookingService.service;

import java.util.List;

import kr.or.connect.bookingService.dto.ReservationComment;
import kr.or.connect.bookingService.dto.ReservationCommentImage;

public interface ReservationCommentService {
	List<ReservationComment> getReservationComments(Integer displayInfoId);
	Float getAvgScore(Integer displayInfoId);
	List<ReservationCommentImage> getReservationCommentImages(Integer reservationInfoId, Integer commentId);
}
