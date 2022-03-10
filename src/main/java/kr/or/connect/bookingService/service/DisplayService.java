package kr.or.connect.bookingService.service;

import kr.or.connect.bookingService.dto.Display;
import kr.or.connect.bookingService.dto.DisplayInfoImage;

public interface DisplayService {
	Display getDisplayInfo(Integer displayInfoId);
	DisplayInfoImage getDisplayInfoImage(Integer displayInfoId);
}
