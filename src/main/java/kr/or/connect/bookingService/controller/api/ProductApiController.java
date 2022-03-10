package kr.or.connect.bookingService.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookingService.dto.Product;
import kr.or.connect.bookingService.service.CatalogService;
import kr.or.connect.bookingService.service.DisplayService;
import kr.or.connect.bookingService.service.ProductService;
import kr.or.connect.bookingService.service.ReservationCommentService;

@RestController
@RequestMapping(path="/api/products")
public class ProductApiController {

	private final CatalogService catalogService;
	private final ProductService productService;
	private final ReservationCommentService commentService;
	private final DisplayService displayService;
	
	
	public ProductApiController(CatalogService catalogService
			,  ProductService productService
			,  ReservationCommentService commentService
			,  DisplayService displayService) {
		this.catalogService = catalogService;
		this.productService = productService;
		this.commentService = commentService;
		this.displayService = displayService;
	}	
	
	@GetMapping
	public List<Product> getProducts(@RequestParam(defaultValue="0") int categoryId
			, @RequestParam(defaultValue="0")int start) {
		
		return catalogService.getCatalogs(categoryId, start);
	}
	
	@GetMapping(path="/count")
	public int getCatalogCount(@RequestParam(defaultValue="0") int categoryId) {
		return catalogService.getCatalogCount(categoryId);
	}
	
	@GetMapping(path="/{displayInfoId}")
	public Map<String, Object> getProductDisplayInfo(@PathVariable int displayInfoId) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("averageScore", commentService.getAvgScore(displayInfoId));
		resultMap.put("comments", commentService.getReservationComments(displayInfoId));
		resultMap.put("displayInfo", displayService.getDisplayInfo(displayInfoId));
		resultMap.put("displayInfoImage", displayService.getDisplayInfoImage(displayInfoId));

		resultMap.put("productImages", productService.getProductImages(displayInfoId));
		resultMap.put("productPrices", productService.getProductPrices(displayInfoId));
		
		return resultMap;
	}
	
	
}
