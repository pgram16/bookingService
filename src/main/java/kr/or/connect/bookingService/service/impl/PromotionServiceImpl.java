package kr.or.connect.bookingService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.PromotionDao;
import kr.or.connect.bookingService.dto.Promotion;
import kr.or.connect.bookingService.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	private final PromotionDao promotionDao;
	
	public PromotionServiceImpl(PromotionDao promotionDao){
		this.promotionDao = promotionDao;
	}
	
	@Override
	public List<Promotion> getPromotions() {
		return promotionDao.selectPromotionAll();
	}

}
