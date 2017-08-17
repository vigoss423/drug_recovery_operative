package com.blueocean.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer  extends WebMvcConfigurerAdapter{
	

	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 
	  registry.addResourceHandler("/**").addResourceLocations("classpath:/");
	 }
	 
}

