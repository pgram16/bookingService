package kr.or.connect.bookingService.service.impl;

import org.springframework.stereotype.Service;

import kr.or.connect.bookingService.dao.DisplayDao;
import kr.or.connect.bookingService.dto.Display;
import kr.or.connect.bookingService.dto.DisplayInfoImage;
import kr.or.connect.bookingService.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {

	private DisplayDao displayDao;
	
	public DisplayServiceImpl(DisplayDao displayDao) {
		this.displayDao = displayDao;
	}
	
	@Override
	public Display getDisplayInfo(Integer displayInfoId) {
		return displayDao.selectDisplayInfo(displayInfoId);
	}

	@Override
	public DisplayInfoImage getDisplayInfoImage(Integer displayInfoId) {
		return displayDao.selectDisplayInfoImage(displayInfoId);
	}


}
