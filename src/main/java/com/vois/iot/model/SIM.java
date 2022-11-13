package com.vois.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Library;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "SIM")
public class SIM {

//	CREATE TABLE sim(
//			id INT AUTO_INCREMENT,
//			   operator_code VARCHAR(100),
//			   country VARCHAR(20),
//			   status ENUM('Active', 'Pending', 'Blocked', 'Deactivated')
//			   PRIMARY KEY(id),
//			);
	
	@Id
    @Column(name = "ID")
    private int ID;
    @Column(name = "OPERATOR_CODE")
    private String operatorCode;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATUS")
    private String status;
    
    @JsonIgnore
    @OneToOne(mappedBy = "simCard")
    private Device device;
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Device getDevice() {
		return device;
	}
//	public void setDevice(Device device) {
//		this.device = device;
//	}
    
	
}
