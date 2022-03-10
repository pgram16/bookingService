package kr.or.connect.bookingService.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.ReservationInfo;
import kr.or.connect.bookingService.dto.ReservationInfoPrice;

import static kr.or.connect.bookingService.dao.sqls.ReservationDaoSqls.*;


@Repository
public class ReservationDao {

	private SimpleJdbcInsert reservationInfoInsertAction;
	private SimpleJdbcInsert reservationInfoPriceInsertAction;
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationInfo> reservationRowMapper = new BeanPropertyRowMapper<>().newInstance(ReservationInfo.class);
	private RowMapper<ReservationInfoPrice> reservationPriceRowMapper = new BeanPropertyRowMapper<>().newInstance(ReservationInfoPrice.class);

	
	public ReservationDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.reservationInfoInsertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
		this.reservationInfoPriceInsertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price").usingGeneratedKeyColumns("id");
	}
	
	public Integer insertReservationInfo(ReservationInfo reservationInfo){
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		
		return reservationInfoInsertAction.executeAndReturnKey(params).intValue();
	}

	public Integer insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice){
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		
		return reservationInfoPriceInsertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<ReservationInfo> getReservationInfos(String reservationEmail){
		Map<String, String> params = new HashMap<>();
		params.put("reservationEmail", reservationEmail);
		
		return jdbc.query(SELECT_RESERVATION_INFO_BY_EMAIL, params, reservationRowMapper);
	}
	
	public int updateCancleFlag(Integer reservationId){
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationId", reservationId);
		
		return jdbc.update(UPDATE_CANCLE_FLAG, params);
	}
	
	public ReservationInfo getReservationInfo(Integer reservationId){
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationId", reservationId);
		
		return jdbc.query(SELECT_RESERVATION_INFO_BY_ID, params, reservationRowMapper).get(0);
	}
	
	public List<ReservationInfoPrice> getReservationInfoPrices(Integer reservationId){
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationId", reservationId);
		
		return jdbc.query(SELECT_RESERVAION_INFO_PRICE_BY_ID, params, reservationPriceRowMapper);
	}
	
	public Integer countReservationUsingEmail(String email){
		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		
		return jdbc.queryForObject(RESERV_COUNT, params, Integer.class);
	}
	
}
