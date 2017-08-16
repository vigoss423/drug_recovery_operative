package com.blueocean.web.pharmacymanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/")
	public String handleError(){
		return "home";
	}
	
	@RequestMapping("/home")
	public String index(){
		return "home";
	}

}
