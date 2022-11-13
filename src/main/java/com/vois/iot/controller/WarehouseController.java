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
	
	
	
}
