package kr.or.connect.bookingService.dao;

import static kr.or.connect.bookingService.dao.sqls.ProductDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookingService.dto.Product;
import kr.or.connect.bookingService.dto.ProductImage;
import kr.or.connect.bookingService.dto.ProductPrice;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductPrice> priceRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	private RowMapper<ProductImage> imageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	
	public ProductDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImage> selectProductImages(Integer displayInfoId) {
		return this.selectProductImages(displayInfoId, null);
	}
	
	public List<ProductImage> selectProductImages(Integer displayInfoId, String imageType) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		params.put("type", imageType);
		
		return jdbc.query(SELECT_PRODUCT_IMAGE, params, imageRowMapper);
	}
	
	
	public List<ProductPrice> selectProductPrices(Integer displayInfoId) {
		
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		
		return jdbc.query(SELECT_PRODUCT_PRICE, params, priceRowMapper);
	}
}
