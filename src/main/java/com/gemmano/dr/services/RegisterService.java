package com.gemmano.dr.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gemmano.dr.entities.DeviceStatus;
import com.gemmano.dr.entities.Registry;
import com.gemmano.dr.entities.Sync;
import com.gemmano.dr.repositories.DeviceRepo;
import com.gemmano.dr.repositories.SyncRepo;


@Service
public class RegisterService {
	
	private DeviceRepo deviceRepo;
	private SyncRepo syncRepo;
	
	@Autowired	
	public RegisterService(DeviceRepo deviceRepo, SyncRepo syncRepo) {
		this.deviceRepo = deviceRepo;
		this.syncRepo = syncRepo;
	}

	public Sync setDeviceState(long id) {
		
		Sync newSync;
		
		if (deviceRepo.existsById(id)) {
			Registry updateCurrentRegistry = new Registry();
			updateCurrentRegistry.setId(id);
			updateCurrentRegistry.setStatus(DeviceStatus.ON);
			updateCurrentRegistry.setLastState(LocalDateTime.now());
			deviceRepo.save(updateCurrentRegistry);
			newSync = syncRepo.findById(1L).get();
		} else {
			return new Sync();
		}
		/*
		table should keep history of device when it registers/unregisters
		table should keep current state information like id/description*/
		//change prop to update
		return newSync;
	}

}
