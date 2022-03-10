package kr.or.connect.bookingService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/myreserve")
public class MyReservation {

	@GetMapping
	public String getReservationHistory(){
		return "myreservation";
	}
}
