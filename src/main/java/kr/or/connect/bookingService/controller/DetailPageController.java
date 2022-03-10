package kr.or.connect.bookingService.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/detail")
public class DetailPageController {
	
	@GetMapping(path="/{displayInfoId}")
	public String setDataOnPage(@PathVariable int displayInfoId, ModelMap modelMap) {

		modelMap.addAttribute("displayInfoId", displayInfoId);
		
		return "detail";
	}
	
    @GetMapping(path="/review/{displayInfoId}")
    public String setReviewOnPage(@PathVariable int displayInfoId, ModelMap modelMap) {
        
        modelMap.addAttribute("displayInfoId", displayInfoId);

        return "review";
    }
    
}
