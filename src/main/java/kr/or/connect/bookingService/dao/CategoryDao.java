package kr.or.connect.bookingService.dao;

import static kr.or.connect.bookingService.dao.sqls.CategoryDaoSqls.*;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.Category;

@Repository
public class CategoryDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Category> selectCategoryAll(){
		return jdbc.query(SELECT_CATEGORY, rowMapper);
	}
	
	
	
	
}
