package kr.or.connect.bookingService.service;

import java.util.List;

import kr.or.connect.bookingService.dto.Product;

public interface CatalogService {

	Integer LIMIT = 4;
	int getCatalogCount(Integer id);
	List<Product> getCatalogs(Integer id, Integer start);
	
}
