package com.example.api.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ParkingFloor {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "parking_Floor_Id")
	private int parkingFloorId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "premise_id")
	private ParkingPremise parkingPremise;
	
	@JsonIgnore
	@OneToMany(mappedBy = "parkingFloor",cascade  = CascadeType.ALL)
	private List<ParkingSlots> parkingslot;

	@NotNull(message = "Cannot be empty")
	private String floorNumber;
	
	@Min(value = 1 , message = "Atleast 1 floor")
	private int numberOfParkingSlots;

	public int getParkingFloorId() {
		return parkingFloorId;
	}

	public void setParkingFloorId(int parkingFloorId) {
		this.parkingFloorId = parkingFloorId;
	}

	public ParkingPremise getParkingPremise() {
		return parkingPremise;
	}

	public void setParkingPremise(ParkingPremise parkingPremise) {
		this.parkingPremise = parkingPremise;
	}

	public List<ParkingSlots> getParkingslot() {
		return parkingslot;
	}

	public void setParkingslot(List<ParkingSlots> parkingslot) {
		this.parkingslot = parkingslot;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getNumberOfParkingSlots() {
		return numberOfParkingSlots;
	}

	public void setNumberOfParkingSlots(int numberOfParkingSlots) {
		this.numberOfParkingSlots = numberOfParkingSlots;
	}

	

	public ParkingFloor(int parkingFloorId, ParkingPremise parkingPremise,
			@NotNull(message = "Cannot be empty") String floorNumber,
			@Min(value = 1, message = "Atleast 1 floor") int numberOfParkingSlots) {
		super();
		this.parkingFloorId = parkingFloorId;
		this.parkingPremise = parkingPremise;
		this.floorNumber = floorNumber;
		this.numberOfParkingSlots = numberOfParkingSlots;
	}

	public ParkingFloor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	// Constructors, Getter & Setter method
	
}
