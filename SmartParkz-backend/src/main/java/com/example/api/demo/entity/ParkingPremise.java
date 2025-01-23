package com.example.api.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ParkingPremise {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingPremiseId;
	@NotNull(message = "premise name cannot be empty")
	private String parkingPremiseName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_id")
	private Address premiseAddress;
	@Min(value = 1 , message = "Atleast 1 floor")
	private int numberOfParkingFloors;
	
	@JsonIgnore
	@OneToMany(mappedBy = "parkingPremise",cascade = CascadeType.ALL)
	private List<ParkingFloor> parkingFloor;

	public int getParkingPremiseId() {
		return parkingPremiseId;
	}

	public void setParkingPremiseId(int parkingPremiseId) {
		this.parkingPremiseId = parkingPremiseId;
	}

	public String getParkingPremiseName() {
		return parkingPremiseName;
	}

	public void setParkingPremiseName(String parkingPremiseName) {
		this.parkingPremiseName = parkingPremiseName;
	}

	public Address getPremiseAddress() {
		return premiseAddress;
	}

	public void setPremiseAddress(Address premiseAddress) {
		this.premiseAddress = premiseAddress;
	}

	public int getNumberOfParkingFloors() {
		return numberOfParkingFloors;
	}

	public void setNumberOfParkingFloors(int numberOfParkingFloors) {
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	public List<ParkingFloor> getParkingFloor() {
		return parkingFloor;
	}

	public void setParkingFloor(List<ParkingFloor> parkingFloor) {
		this.parkingFloor = parkingFloor;
	}

	

	public ParkingPremise(int parkingPremiseId,
			@NotNull(message = "premise name cannot be empty") String parkingPremiseName, Address premiseAddress,
			@Min(value = 1, message = "Atleast 1 floor") int numberOfParkingFloors) {
		super();
		this.parkingPremiseId = parkingPremiseId;
		this.parkingPremiseName = parkingPremiseName;
		this.premiseAddress = premiseAddress;
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	public ParkingPremise() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		// Constructors, Getter & Setter method
}




//@OneToMany(cascade = CascadeType.ALL)
//private List<ParkingFloor>  parkingfloor = new ArrayList<>(); 