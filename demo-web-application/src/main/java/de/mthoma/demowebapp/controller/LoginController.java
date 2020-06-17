package de.mthoma.demowebapp.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {


	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/login")
	public String login(@RequestParam Optional<String> error, Model model) {
		
		String visibilityClass = "cls_invisible";
		if(error.isPresent() && "true".equals(error.get())) {
			visibilityClass = "cls_visible";
		}
		
		model.addAttribute("login_error_message_cls", visibilityClass);
        
        return "login_page";
	}
	
//	/**
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@PostMapping(value = "/login?error=true")
//	public String loginOnError(Model model) {
//		
//		model.addAttribute("login_error_message_cls", "cls_visible");
//        
//        return "login_page";
//	}
}
