package com.gemmano.dr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gemmano.dr.services.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	private RegisterService registerService;

	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
	public String registerDevice(@RequestParam("id") long id) {//TODO check for min/max
		
		return registerService.setDeviceState(id);
	}
}
