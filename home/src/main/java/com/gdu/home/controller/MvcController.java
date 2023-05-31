package com.gdu.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

	@GetMapping("/")
	public String index() {
		return "index";   // src/main/resources/templates/index.html    
		                  
	}
	
}
