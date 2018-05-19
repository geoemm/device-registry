package com.gemmano.dr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemmano.dr.repositories.DeviceRepo;


@Service
public class RegisterService {
	
	/*private DeviceRepo deviceRepo;
	
	@Autowired	
	public RegisterService(DeviceRepo deviceRepo) {
		this.deviceRepo = deviceRepo;
	}*/

	public boolean setDeviceState(long id) {
		
		/*1 checkifexist
		2 if does not return error
		3 if it does add device to pool of devices set flag as ON
		
		table should keep history of device when it registers/unregisters
		table should keep current state information like id/description*/
		
		return true;
	}

}
