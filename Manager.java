package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int managerId;
	private String managerName;
	private double managerSalary;
	private long managerPhone;
	private int managerYOE;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public double getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(double managerSalary) {
		this.managerSalary = managerSalary;
	}
	public long getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(long managerPhone) {
		this.managerPhone = managerPhone;
	}
	public int getManagerYOE() {
		return managerYOE;
	}
	public void setManagerYOE(int managerYOE) {
		this.managerYOE = managerYOE;
	}
	
}
