package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {
	
	//Dependency - Autowiring
	@Autowired
	private WelcomeService service;
	
	@Autowired
	private BasicConfiguration configuration;

	//welcome
	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}
	
	//dynamic configuration
	@RequestMapping("/dynamicConfiguration")
	public Map dynamicConfiguration() {
		Map myMap = new HashMap();
		myMap.put("message", configuration.getMessage());
		myMap.put("number", configuration.getNumber());
		myMap.put("value", configuration.isValue());
		
		return myMap;
	}
}
