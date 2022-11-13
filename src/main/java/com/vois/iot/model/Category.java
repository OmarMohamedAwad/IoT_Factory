package com.vois.iot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "CATEGORY")
public class Category {

//	CREATE TABLE category(
//			id INT AUTO_INCREMENT,
//			   name VARCHAR(100),
//			   location VARCHAR(100),
//			   warehouse_id INT,
//			   PRIMARY KEY(id,
//			   FOREIGN KEY(warehouse_id) references warehouse(id)
//			);
	
	@Id
    @Column(name = "ID")
	private int ID;
    @Column(name = "LOCATION")
    private String location;
    
//    @OneToMany(mappedBy = "category")
//    private List<Device> devices;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;
    
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

//	public List<Device> getDevices() {
//		return devices;
//	}
//
//	public void setDevices(List<Device> devices) {
//		this.devices = devices;
//	}
    
	
}
