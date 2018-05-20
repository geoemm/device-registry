package com.gemmano.dr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemmano.dr.entities.Registry;
import com.gemmano.dr.repositories.DeviceRepo;


@Service
public class RegisterService {
	
	private DeviceRepo deviceRepo;
	
	@Autowired	
	public RegisterService(DeviceRepo deviceRepo) {
		this.deviceRepo = deviceRepo;
	}

	public boolean setDeviceState(long id) {
		
		Registry myRegistry = new Registry();
		myRegistry.setId(id);
		myRegistry.setName("ESP8266");
		myRegistry.setDescription("thermometer");
		
		deviceRepo.save(myRegistry);
		
		/*1 checkifexist
		2 if does not return error
		3 if it does add device to pool of devices set flag as ON
		
		table should keep history of device when it registers/unregisters
		table should keep current state information like id/description*/
		//change prop to update
		return true;
	}

}
