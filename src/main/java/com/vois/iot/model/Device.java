package com.vois.iot.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "DEVICE")
public class Device {

	@Id
    @Column(name = "ID")
	private int ID;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TEMPERATURE")
    private float temperature;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SIM_ID", insertable = false, updatable = false)
    private int simID;
    
    @OneToOne
    @JoinColumn(name = "SIM_ID", referencedColumnName = "id")
    private SIM simCard;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SIM getSimCard() {
		return simCard;
	}
	public void setSimCard(SIM simCard) {
		this.simCard = simCard;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getSimID() {
		return simID;
	}
	public void setSimID(int simID) {
		this.simID = simID;
	}
			
}
