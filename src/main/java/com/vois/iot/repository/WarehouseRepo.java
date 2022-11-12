package com.vois.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vois.iot.model.Warehouse;

public interface WarehouseRepo extends JpaRepository<Warehouse, String>{

}
