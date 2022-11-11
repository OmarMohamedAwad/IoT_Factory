package com.vois.iot.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "DEVICE")
public class Device {

//	CREATE TABLE device(
//			id INT AUTO_INCREMENT,
//			   name VARCHAR(100),
//			   temperature FLOAT(24),
//			   status ENUM('Ready','Not Ready'),
//			   category_id INT,
//			   sim_id INT,
//			   PRIMARY KEY(id),
//			   FOREIGN KEY(category_id) references category(id),
//			   FOREIGN KEY(sim_id) references sim(id)
//			);
	@Id
    @Column(name = "ID")
    public int deviceId;
    @Column(name = "NAME")
    public String name;
    @Column(name = "TEMPERATURE")
    public String temperature;
    @Column(name = "STATUS")
    public String status;

}
