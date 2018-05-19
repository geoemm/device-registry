package com.gemmano.dr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gemmano.dr.services.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Value("${DB_URL}")
	private String dbUrl;
	
	private RegisterService registerService;

	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String registerDevice(@RequestParam("id") long id) {//TODO check for min/max
		
		registerService.setDeviceState(id);
		
		return "hey " + dbUrl;
	}
}
