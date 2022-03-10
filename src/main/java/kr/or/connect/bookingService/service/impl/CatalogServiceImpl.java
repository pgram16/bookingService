package kr.or.connect.bookingService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.CatalogDao;
import kr.or.connect.bookingService.dto.Product;
import kr.or.connect.bookingService.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

	private final CatalogDao catalogDao;
	
	public CatalogServiceImpl(CatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}

	@Override
	public int getCatalogCount(Integer id) {
		return catalogDao.selectCatalogCount(id);
	}

	@Override
	public List<Product> getCatalogs(Integer id, Integer start) {
		return catalogDao.selectCatalogAll(id, start*LIMIT, LIMIT);
	}


}
