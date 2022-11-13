package com.vois.iot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vois.iot.model.Device;
import com.vois.iot.repository.DeviceRepo;
import com.vois.iot.utiles.ResponseObject;

@Service
@Transactional
public class DeviceService {

	@Autowired
    DeviceRepo deviceRepo;
	
    public ResponseEntity<?> getNotReadyDevice() throws Exception {
    	try {
    		List<Device> deviceList = deviceRepo.findByStatus("Not Ready");
    		return new ResponseEntity<>(new ResponseObject(true, deviceList, "The Devices Returned Succefully"), HttpStatus.OK);    		
    	}
    	catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);
		}
	}

    public ResponseEntity<?> getReadyDevice() throws Exception {
    	try {
    		List<Device> deviceListTemp = deviceRepo.findByStatusAndTemperatureBetweenOrderByIDAsc("Ready",-25.0f, 85.0f);		    	
    		return new ResponseEntity<>(new ResponseObject(true, deviceListTemp, "The Devices Returned Succefully"), HttpStatus.OK);
    	}
    	catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);
		}
	}
	
    public ResponseEntity<?> update(Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.getID());
			device.setStatus(info.getStatus());
			device.setTemperature(info.getTemperature());
			deviceRepo.save(device);
			return new ResponseEntity<>(new ResponseObject(true, null, "The Device Updated Succefully"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new ResponseObject(false, null, "The Device Can't Updated "+e), HttpStatus.CONFLICT);

		}
	}
		
    public ResponseEntity<?> delete(Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.getID());
			deviceRepo.delete(device);
			return new ResponseEntity<>(new ResponseObject(true, null, "The Device Deleted Succefully"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new ResponseObject(false, null, "The Device Can't Deleted "+e), HttpStatus.CONFLICT);

		}
	}
}
