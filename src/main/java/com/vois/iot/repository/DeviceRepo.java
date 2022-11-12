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
//	@Modifying
//	@Query(value = "select * from device d  where d.status = 'Ready' AND d.temperature BETWEEN -25.0 AND 85.0", nativeQuery=true)
//	List<Device> findByStatusAndTemperature();
	List<Device> findByStatusAndTemperatureBetween(String status,float min, float max);
	Device findByID(int id);
	int deleteByID(int id);
}