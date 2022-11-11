package com.vois.iot.controller;

import org.springframework.web.bind.annotation.PostMapping;
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

@RestController
@RequestMapping("/api/v1/warehouse/")
public class WarehouseController {
	
	@Autowired
    DeviceRepo deviceRepo;
	@PostMapping("/index")
    public ResponseEntity index(@RequestBody Device info) throws Exception {
		System.out.println("request = "+info.status);
		List<Device> deviceList = deviceRepo.findByStatus(info.status);
		
		return ResponseEntity.status(HttpStatus.OK).body(deviceList);
	}
	
	// Returns all devices in the warehouse that are waiting for activation. from device table
	// Management endpoints that enable the shop manager to remove or update a device configuration status.
	// Returns an ordered result of devices available for sale.
}
