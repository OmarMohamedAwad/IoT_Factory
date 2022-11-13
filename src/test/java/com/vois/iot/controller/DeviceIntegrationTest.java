package com.vois.iot.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vois.iot.VoisIoTFactoryApplication;
import com.vois.iot.model.Device;
import com.vois.iot.model.SIM;
import com.vois.iot.repository.DeviceRepo;
import com.vois.iot.repository.SIMRepo;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ImportResource({"classpath*:application-context.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest(
         webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
         classes = VoisIoTFactoryApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class DeviceIntegrationTest {

	@Autowired
    MockMvc mockMvc;

	@Autowired
    DeviceRepo devicesRepo;
	
	@Autowired
    SIMRepo simRepo;
    
    private void addDevice(String status){
        // add device and sim and assign sim to device
        Device d = new Device();
        SIM s = new SIM();
        d.setID(1);
        d.setStatus(status);
        d.setTemperature(25);
        s.setID(1);
        s.setStatus("Active");
        s.setOperatorCode("201");
        s.setCountry("Egypt");

        simRepo.save(s);
        d.setSimCard(s);
        devicesRepo.save(d);
    }
    
    @Test
    void getWaitingDevices() throws Exception {
    	addDevice("Not Ready");

        mockMvc.perform(get("/api/v1/device/not-ready"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", Matchers.is(3)))
                .andExpect(jsonPath("$.data[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$.data[0].status", Matchers.is("Not Ready")))
                .andExpect(jsonPath("$.data[0].simCard.country", Matchers.is("Egypt")));
    }

    @Test
    void getAvailableForSellDevices() throws Exception {        
    	addDevice("Ready");
        mockMvc.perform(get("/api/v1/device/ready"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.size()", Matchers.is(3)))
                .andExpect(jsonPath("$.data[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$.data[0].status", Matchers.is("Ready")))
                .andExpect(jsonPath("$.data[0].simCard.id", Matchers.is(1)));
    }
    
}
