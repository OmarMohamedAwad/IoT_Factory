package com.vois.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vois.iot.model.Category;

public interface CategoryRepo extends JpaRepository<Category, String>{

}
