package de.mthoma.demowebapp.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/home")
	public String login(Model model) {
		
		model.addAttribute("var_user_name", this.getAuthenticatedUserName());
        
        return "home_page";
	}
	
	/*
	 * Returns the alias of the logged in user.
	 */
	private String getAuthenticatedUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    return authentication.getName();
		}
		return "";
	}
}
