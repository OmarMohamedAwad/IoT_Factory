package com.vois.iot.controller;

//import org.aspectj.lang.annotation.Before;
import org.junit.Before;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vois.iot.model.Device;
import com.vois.iot.repository.DeviceRepo;
import com.vois.iot.utiles.ResponseObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ImportResource({"classpath*:application-context.xml"})
@WebMvcTest
public class DeviceUnitTest {

	@Autowired
    MockMvc mockMvc;

    @MockBean
    DeviceRepo devicesRepo;
    
    @MockBean
    DeviceController devicesController;

    private final List<Device> devices = new ArrayList<>();
    Device d1 , d2, d3, d4;

    @Before
    public void setup() {
    	d1 = new Device();
    	d2 = new Device();
    	d3 = new Device();
    	d4 = new Device();

        // device 1 data
        d1.setID(8);
        d1.setName("D8");
        d1.setTemperature(25);
        d1.setStatus("Not Ready");
        d1.setSimID(1);

        // device 2 data
        d2.setID(9);
        d2.setName("D9");
        d2.setTemperature(45);
        d2.setStatus("Not Ready");
        d2.setSimID(1);

        // device 3 data
        d3.setID(10);
        d3.setName("D10");
        d3.setTemperature(65);
        d3.setStatus("Ready");
        d3.setSimID(1);
        
        // device 4 data
        d4.setID(11);
        d4.setName("D11");
        d4.setTemperature(68);
        d4.setStatus("Ready");
        d4.setSimID(1);
        
        devices.add(d1);
        devices.add(d2);
        devices.add(d3);
        devices.add(d4);
    }
    
    @Test
    void getWaitingDevices() throws Exception {
    	d1 = new Device();
    	d2 = new Device();

        // device 1 data
        d1.setID(8);
        d1.setName("D8");
        d1.setTemperature(25);
        d1.setStatus("Not Ready");
        d1.setSimID(1);

        // device 2 data
        d2.setID(9);
        d2.setName("D9");
        d2.setTemperature(45);
        d2.setStatus("Not Ready");
        d2.setSimID(1);
        
        Mockito.when(devicesController.getNotReadyDevice()).thenReturn(new ResponseEntity(new ResponseObject(true, asList(d1, d2), "OK"), HttpStatus.OK));

        mockMvc.perform(get("/api/v1/device/not-ready"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", Matchers.is(3)))
                .andExpect(jsonPath("$.data[0].id", Matchers.is(8)))
                .andExpect(jsonPath("$.data[0].status", Matchers.is("Not Ready")))
                .andExpect(jsonPath("$.data[1].id", Matchers.is(9)));
    }

    @Test
    void getAvailableForSellDevices() throws Exception {
    	d3 = new Device();
    	d4 = new Device();
    	
    	// device 3 data
        d3.setID(10);
        d3.setName("D10");
        d3.setTemperature(65);
        d3.setStatus("Ready");
        d3.setSimID(1);
        
        // device 4 data
        d4.setID(11);
        d4.setName("D11");
        d4.setTemperature(68);
        d4.setStatus("Ready");
        d4.setSimID(1);
        
        Mockito.when(devicesController.getReadyDevice()).thenReturn(new ResponseEntity(new ResponseObject(true, asList(d3, d4), "OK"), HttpStatus.OK));

        mockMvc.perform(get("/api/v1/device/ready"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", Matchers.is(3)))
                .andExpect(jsonPath("$.data[0].id", Matchers.is(10)))
                .andExpect(jsonPath("$.data[0].status", Matchers.is("Ready")))
                .andExpect(jsonPath("$.data[1].id", Matchers.is(11)));
    }
	
}
