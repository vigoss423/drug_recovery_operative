package com.blueocean.web.pharmacymanage.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/** 全局访问失败处理类 -- 处理404 */
@Controller
public class MainsiteErrorController implements ErrorController {
	
	//定义404的@RequestMapping
	public static final String ERROR_PATH = "/error"; 
	
	
	@RequestMapping(value = ERROR_PATH)
	public String handleError(HttpServletRequest req,HttpServletResponse rep){
		//rep.setStatus(200);
		return "forward:/home";
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}


