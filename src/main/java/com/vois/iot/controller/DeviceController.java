package com.vois.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vois.iot.model.Device;
import com.vois.iot.service.DeviceService;

@RestController
@RequestMapping("/api/v1/device/")
public class DeviceController {

	@Autowired
    private DeviceService deviceService;
	
	@GetMapping("/not-ready")
    public ResponseEntity<?> getNotReadyDevice() throws Exception {
		return deviceService.getNotReadyDevice();
	}

	@GetMapping("/ready")
    public ResponseEntity<?> getReadyDevice() throws Exception {
		return deviceService.getReadyDevice();
	}
	
	@PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody Device info) throws Exception {
		return deviceService.update(info);
	}
	
	
	@DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Device info) throws Exception {
		return deviceService.delete(info);
	}
}
