package kr.or.connect.bookingService.service;

import java.util.List;

import kr.or.connect.bookingService.dto.ProductImage;
import kr.or.connect.bookingService.dto.ProductPrice;

public interface ProductService {
	ProductImage getProductMainImage(Integer displayInfoId);
	List<ProductImage> getProductImages(Integer displayInfoId);
	List<ProductPrice> getProductPrices(Integer displayInfoId);
}
