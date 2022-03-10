package kr.or.connect.bookingService.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.bookingService.dto.Display;
import kr.or.connect.bookingService.dto.ProductImage;
import kr.or.connect.bookingService.dto.ProductPrice;
import kr.or.connect.bookingService.service.DisplayService;
import kr.or.connect.bookingService.service.ProductService;
import kr.or.connect.bookingService.service.ReservationService;

@Controller
@RequestMapping(path="/reserve")
public class ReservationPageController {

	private final int RANDOM_DAY = 5;
	private DisplayService displayService;
	private ProductService productService;
	private ReservationService reservationService;
	
	@Autowired
	public ReservationPageController(DisplayService displayService
			, ProductService productService
			, ReservationService reservationService) {
		this.displayService = displayService;
		this.productService = productService;
		this.reservationService = reservationService;
	}
	
	@GetMapping(path="/{displayInfoId}")
	public String init(@PathVariable Integer displayInfoId, ModelMap model){
		
		Display display = displayService.getDisplayInfo(displayInfoId);
		ProductImage productImage = productService.getProductMainImage(displayInfoId);
		List<ProductPrice> productPrices = productService.getProductPrices(displayInfoId);
		
		
		model.put("display", display);
		model.put("productImage", productImage);
		model.put("productPrices", productPrices);
		
		int randomDay = (int)(Math.random()*100)%RANDOM_DAY;
		Date date = this.getDate(new Date(), randomDay);
		
		//model.put("reserveDate1", getFormattingDate(date));
		model.put("reserveDate", date);
		
		return "reserve";
	}
	
	
	private Date getDate(Date date, int day){
	
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	private String getFormattingDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		return format.format(date);
	}
}
