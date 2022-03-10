package kr.or.connect.bookingService.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookingService.dto.ReservationInfo;
import kr.or.connect.bookingService.service.ReservationService;

@RestController
@RequestMapping(path="/api/reservations")
public class ReservationsApiController {

	private final ReservationService reservationService;
	
	public ReservationsApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public Map<String, Object> getReservationInfo(@RequestParam String reservationEmail){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ReservationInfo> reservations = this.reservationService.getReservationInfos(reservationEmail);
		
		map.put("reservations", reservations);
		map.put("size", reservations.size());

		return map;
	}
	
	@PostMapping
	public ReservationInfo makeReservation(@RequestBody ReservationInfo reservationInfo){
		System.out.println(reservationInfo.toString());
		
		return reservationService.insertReservationInfo(reservationInfo);
	}
	
	@PutMapping(path="/{reservationId}")
	public ReservationInfo cancleReservation(@PathVariable Integer reservationId){
		return reservationService.cancleReservationInfo(reservationId);
	}
}
