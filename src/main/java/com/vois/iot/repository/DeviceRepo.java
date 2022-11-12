package com.vois.iot.repository;

import com.vois.iot.model.Device;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

public interface DeviceRepo extends JpaRepository<Device, String>{

	List<Device> findByStatus(String status);
	List<Device> findByStatusAndTemperatureBetween(String status,float min, float max);
	Device findByID(int id);
	int deleteByID(int id);
}
