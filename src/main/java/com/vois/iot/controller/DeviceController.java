package com.vois.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vois.iot.model.Device;
import com.vois.iot.repository.DeviceRepo;
import com.vois.iot.utiles.ResponseObject;

@RestController
@RequestMapping("/api/v1/device/")
public class DeviceController {

	@Autowired
    DeviceRepo deviceRepo;
	
	@GetMapping("/not-ready")
    public ResponseEntity getNotReadyDevice() throws Exception {
		List<Device> deviceList = deviceRepo.findByStatus("Not Ready");
//		return ResponseEntity.status(HttpStatus.OK).body(new WorkerPojo(true, workers, "OK"), HttpStatus.OKdeviceList);
		return new ResponseEntity(new ResponseObject(true, deviceList, "OK"), HttpStatus.OK);
	}

	@GetMapping("/ready")
    public ResponseEntity getReadyDevice() throws Exception {
//		List<Device> deviceList = deviceRepo.findByStatusAndTemperature();
		List<Device> deviceListTemp = deviceRepo.findByStatusAndTemperatureBetweenOrderByIDAsc("Ready",-25.0f, 85.0f);
		
		return new ResponseEntity(new ResponseObject(true, deviceListTemp, "OK"), HttpStatus.OK);
	}
	
	@PatchMapping("/update")
    public ResponseEntity update(@RequestBody Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.getID());
			device.setStatus(info.getStatus());
			device.setTemperature(info.getTemperature());
			deviceRepo.save(device);
			return new ResponseEntity(new ResponseObject(true, null, "OK"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);

		}
	}
	
	
	@DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.getID());
			deviceRepo.delete(device);
			return new ResponseEntity(new ResponseObject(true, null, "OK"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);

		}
	}
}
