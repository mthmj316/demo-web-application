package de.mthoma.demowebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/login")
	public String login(Model model) {
		
		model.addAttribute("login_error_message_cls", "cls_invisible");
        
        return "login_page";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/login?error=true")
	public String loginOnError(Model model) {
		
		model.addAttribute("login_error_message_cls", "cls_visible");
        
        return "login_page";
	}
}
