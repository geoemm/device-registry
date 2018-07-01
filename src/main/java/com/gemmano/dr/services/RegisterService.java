package com.gemmano.dr.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemmano.dr.entities.DeviceStatus;
import com.gemmano.dr.entities.Registry;
import com.gemmano.dr.repositories.DeviceRepo;


@Service
public class RegisterService {
	
	@Autowired
	private DeviceRepo deviceRepo;

	public String setDeviceState(long id) {
		
		if (!deviceRepo.existsById(id)) {
			Registry updateCurrentRegistry = new Registry();
			updateCurrentRegistry.setId(id);
			updateCurrentRegistry.setStatus(DeviceStatus.ON);
			updateCurrentRegistry.setLastState(LocalDateTime.now());
			deviceRepo.save(updateCurrentRegistry);
		} else {
			Optional<Registry> optionalUpdateCurrentRegistry = deviceRepo.findById(id);
			Registry updateCurrentRegistry = optionalUpdateCurrentRegistry.get();
			updateCurrentRegistry.setStatus(updateCurrentRegistry.getStatus() == DeviceStatus.ON ? DeviceStatus.OFF : DeviceStatus.ON);
			updateCurrentRegistry.setLastState(LocalDateTime.now());
			deviceRepo.save(updateCurrentRegistry);
		}
		
		return "OK";
	}

}
