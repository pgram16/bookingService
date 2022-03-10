package kr.or.connect.bookingService.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.ReservationComment;
import kr.or.connect.bookingService.dto.ReservationCommentImage;

import static kr.or.connect.bookingService.dao.sqls.ReservationCommentDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReservationCommentDao {
	

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationComment.class);
	private RowMapper<ReservationCommentImage> imageRowMapper = BeanPropertyRowMapper.newInstance(ReservationCommentImage.class);
	
	public ReservationCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Float getReservationScoreAvg(Integer displayInfoId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.queryForObject(SELECT_SCORE_AVG, params, Float.class);
	}
	
	public List<ReservationComment> getReservationComments(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_COMMENT_ALL, params, rowMapper);
	}
	
	public List<ReservationCommentImage> getReservationCommentImages(Integer reservationInfoId, Integer commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);
		params.put("commentId", commentId);
		
		return jdbc.query(SELECT_COMMENT_IMAGES, params, imageRowMapper);
	}
}
