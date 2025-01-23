package com.example.api.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.api.demo.jwt.JwtUserDetails;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vehicleId;
	
	@NotNull(message = "vehicle type cannot be empty")
	private String vehicleType;
	
	@Pattern(regexp = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$",message = "Enter valid vehicle number in indian format")
	private String vehicleNumber;	
	
	@NotNull(message = "vehicle company cannot be empty")
	private String vehicleCompany;
	
	@NotNull(message = "vehicle company cannot be empty")
	private String vehicleModel;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private JwtUserDetails user;

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleCompany() {
		return vehicleCompany;
	}

	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public JwtUserDetails getUser() {
		return user;
	}

	public void setUser(JwtUserDetails user) {
		this.user = user;
	}

	public Vehicle(long vehicleId, @NotNull(message = "vehicle type cannot be empty") String vehicleType,
			@Pattern(regexp = "^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$", message = "Enter valid vehicle number in indian format") String vehicleNumber,
			@NotNull(message = "vehicle company cannot be empty") String vehicleCompany,
			@NotNull(message = "vehicle company cannot be empty") String vehicleModel, JwtUserDetails user) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleCompany = vehicleCompany;
		this.vehicleModel = vehicleModel;
		this.user = user;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
