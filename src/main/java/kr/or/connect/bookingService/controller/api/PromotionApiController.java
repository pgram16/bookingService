package kr.or.connect.bookingService.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookingService.dto.Promotion;
import kr.or.connect.bookingService.service.PromotionService;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {

	private final PromotionService promotionService;
	
	public PromotionApiController(PromotionService promotionService) {
		this.promotionService = promotionService;
	}	
	
	@GetMapping
	public List<Promotion> getPromotions(){
		return promotionService.getPromotions();
	}
	
	
}
