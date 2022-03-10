package kr.or.connect.bookingService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.bookingService.dto.Product;
import kr.or.connect.bookingService.dto.Category;
import kr.or.connect.bookingService.dto.Promotion;
import kr.or.connect.bookingService.service.CatalogService;
import kr.or.connect.bookingService.service.CategoryService;
import kr.or.connect.bookingService.service.PromotionService;

@Controller
public class MainPageController {

	private final CategoryService categoryService;
	private final CatalogService catalogService;
	private final PromotionService promotionService;
	
	public MainPageController(CategoryService categoryService, CatalogService catalogService, PromotionService promotionService) {
		this.categoryService = categoryService;
		this.catalogService = catalogService;
		this.promotionService = promotionService;
	}	
	
	@GetMapping("/mainpage")
	public String setDataOnPage(@RequestParam(defaultValue="0") Integer categoryId
			,@RequestParam(defaultValue="0") Integer start
			, ModelMap modelMap) {

		List<Category> category = categoryService.getCategory();
		
		int count = catalogService.getCatalogCount(categoryId);
		List<Product> catalogs = catalogService.getCatalogs(categoryId, start);
		List<Promotion> promotions = promotionService.getPromotions();
		
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("catalogs", catalogs);
		modelMap.addAttribute("promotions", promotions);
		
		return "mainpage";
	}
	
	@GetMapping("/morePage")
	@ResponseBody
	public Map<String, Object> morePage(@RequestParam(required=false) Integer categoryId
			,@RequestParam(defaultValue="0") Integer start) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Product> catalogs = catalogService.getCatalogs(categoryId, start);
		int count = catalogService.getCatalogCount(categoryId);
		
		map.put("count", count);
		map.put("catalogs", catalogs);
		
		return map;
	}
	
}
