package kr.or.connect.bookingService.dao;

import static kr.or.connect.bookingService.dao.sqls.CatalogDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.Product;

@Repository
public class CatalogDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public CatalogDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public int selectCatalogCount(Integer id){
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(SELECT_CATALOG_COUNT, params, Integer.class);
	}
	
	public List<Product> selectCatalogAll(Integer id, Integer start, Integer end){
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		params.put("end", end);
		
		return jdbc.query(SELECT_CATALOG, params, rowMapper);
	}
	
	
	
}
