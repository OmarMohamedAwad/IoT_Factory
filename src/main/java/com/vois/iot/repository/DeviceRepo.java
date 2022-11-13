package com.vois.iot.repository;

import com.vois.iot.model.Device;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device, String>{

	List<Device> findByStatus(String status);
	List<Device> findByStatusAndTemperatureBetweenOrderByIDAsc(String status,float min, float max);
	Device findByID(int id);
	int deleteByID(int id);
}
