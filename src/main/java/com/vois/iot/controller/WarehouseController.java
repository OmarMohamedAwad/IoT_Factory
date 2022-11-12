package com.vois.iot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.vois.iot.repository.DeviceRepo;
import javax.servlet.http.HttpServletRequest;
import com.vois.iot.model.Device;
import java.util.*;
import com.vois.iot.utiles.ResponseObject;

@RestController
@RequestMapping("/api/v1/warehouse/")
public class WarehouseController {
	
	@Autowired
    DeviceRepo deviceRepo;
	
	@GetMapping("/device/not-ready")
    public ResponseEntity getNotReadyDevice() throws Exception {
		List<Device> deviceList = deviceRepo.findByStatus("Not Ready");
//		return ResponseEntity.status(HttpStatus.OK).body(new WorkerPojo(true, workers, "OK"), HttpStatus.OKdeviceList);
		return new ResponseEntity(new ResponseObject(true, deviceList, "OK"), HttpStatus.OK);
	}

	@GetMapping("/device/ready")
    public ResponseEntity getReadyDevice() throws Exception {
//		List<Device> deviceList = deviceRepo.findByStatusAndTemperature();
		List<Device> deviceListTemp = deviceRepo.findByStatusAndTemperatureBetween("Ready",-25.0f, 85.0f);
		
		return new ResponseEntity(new ResponseObject(true, deviceListTemp, "OK"), HttpStatus.OK);
	}
	
	@PatchMapping("/device")
    public ResponseEntity update(@RequestBody Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.ID);
			device.setStatus(info.status);
			device.setTemperature(info.temperature);
			deviceRepo.save(device);
			return new ResponseEntity(new ResponseObject(true, null, "OK"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);

		}
	}
	
	
	@DeleteMapping("/device")
    public ResponseEntity delete(@RequestBody Device info) throws Exception {
		try {
			Device device = deviceRepo.findByID(info.ID);
			deviceRepo.delete(device);
			return new ResponseEntity(new ResponseObject(true, null, "OK"), HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new ResponseObject(false, null, e+""), HttpStatus.CONFLICT);

		}
	}
	// Returns all devices in the warehouse that are waiting for activation. from device table
	// Returns an ordered result of devices available for sale.
	// Management endpoints that enable the shop manager to remove or update a device configuration status.
	
}
