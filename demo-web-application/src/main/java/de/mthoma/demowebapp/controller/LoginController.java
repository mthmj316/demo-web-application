package de.mthoma.demowebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


	@GetMapping(value = "/demo-web-application/login")
	public String login(Model model) {
        
        return "login_page";
	}
}
