package kr.or.connect.bookingService.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.CategoryDao;
import kr.or.connect.bookingService.dto.Category;
import kr.or.connect.bookingService.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public List<Category> getCategory() {
		return categoryDao.selectCategoryAll();
	}

}
