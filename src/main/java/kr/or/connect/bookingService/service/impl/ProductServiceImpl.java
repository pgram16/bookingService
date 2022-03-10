package kr.or.connect.bookingService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.ProductDao;
import kr.or.connect.bookingService.dto.ProductImage;
import kr.or.connect.bookingService.dto.ProductPrice;
import kr.or.connect.bookingService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public List<ProductImage> getProductImages(Integer displayInfoId) {
		return productDao.selectProductImages(displayInfoId);
	}

	@Override
	public List<ProductPrice> getProductPrices(Integer displayInfoId) {
		return productDao.selectProductPrices(displayInfoId);
	}

	@Override
	public ProductImage getProductMainImage(Integer displayInfoId) {
		return productDao.selectProductImages(displayInfoId, "ma").get(0);
	}

	


}
