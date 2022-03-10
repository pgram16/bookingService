package kr.or.connect.bookingService.dao;

import static kr.or.connect.bookingService.dao.sqls.DisplayDaoSqls.*;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.Display;
import kr.or.connect.bookingService.dto.DisplayInfoImage;

@Repository
public class DisplayDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Display> rowMapper = BeanPropertyRowMapper.newInstance(Display.class);
	private RowMapper<DisplayInfoImage> imageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	
	public DisplayDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Display selectDisplayInfo(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_DISPLAY_INFO, params, rowMapper).get(0);
	}
	
	public DisplayInfoImage selectDisplayInfoImage(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE, params, imageRowMapper).get(0);
	}
	
}
