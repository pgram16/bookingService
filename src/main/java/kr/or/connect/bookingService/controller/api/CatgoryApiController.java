package kr.or.connect.bookingService.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookingService.dto.Category;
import kr.or.connect.bookingService.service.CategoryService;

@RestController
@RequestMapping(path="/api/categories")
public class CatgoryApiController {

	private final CategoryService categoryService;
	
	public CatgoryApiController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}	
	
	@GetMapping
	public List<Category> getCategories() {
		
		return categoryService.getCategory();
	}
	

	
}
