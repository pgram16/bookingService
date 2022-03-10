package kr.or.connect.bookingService.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.bookingService.service.LoginService;


@Controller
@RequestMapping(path="/login")
public class LoginController {
	
	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping
	public String loginForm(){
		
		return "bookinglogin";
	}
	
	@PostMapping
	public String login(@RequestParam String email,
			HttpSession session,
			RedirectAttributes redirectAttribute) {
		
		if(loginService.getCountResevationHistory(email) > 0){
			session.setAttribute("loginEmail", email);
			session.setMaxInactiveInterval(60);
		}
		
		return "redirect:/myreserve";
	}
}
