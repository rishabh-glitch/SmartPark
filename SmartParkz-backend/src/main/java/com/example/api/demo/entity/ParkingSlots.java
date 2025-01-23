package com.example.api.demo.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ParkingSlots {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingSlotId;
	
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "parking_floor_reference_id")
	private ParkingFloor parkingFloor;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	@Temporal(TemporalType.DATE)
	private Date parkingDate;
	@NotNull(message = "cannot be empty")
	@Pattern(regexp = "((1[0-2]|0?[1-9]):([0-5][0-9]) ?([AaPp][Mm]))",message = "Enter valid time")
	private String parkingTime;
	@Temporal(TemporalType.DATE)
	private Date bookingDate = new Date(System.currentTimeMillis());
	@NotNull
	private int slot_no;
	@NotNull(message = "parking duration cannot be null")
	private int parkingDuration;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;
	public int getSlot_no() {
		return slot_no;
	}
	public void setSlot_no(int slot_no) {
		this.slot_no = slot_no;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(int parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	public ParkingFloor getParkingFloor() {
		return parkingFloor;
	}
	public void setParkingFloor(ParkingFloor parkingFloor) {
		this.parkingFloor = parkingFloor;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}
	public String getParkingTime() {
		return parkingTime;
	}
	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getParkingDuration() {
		return parkingDuration;
	}
	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}
	

	public ParkingSlots(int parkingSlotId, ParkingFloor parkingFloor, Vehicle vehicle, Date parkingDate,
			@NotNull(message = "cannot be empty") @Pattern(regexp = "((1[0-2]|0?[1-9]):([0-5][0-9]) ?([AaPp][Mm]))", message = "Enter valid time") String parkingTime,
			Date bookingDate, @NotNull int slot_no,
			@NotNull(message = "parking duration cannot be null") int parkingDuration, Payment payment) {
		super();
		this.parkingSlotId = parkingSlotId;
		this.parkingFloor = parkingFloor;
		this.vehicle = vehicle;
		this.parkingDate = parkingDate;
		this.parkingTime = parkingTime;
		this.bookingDate = bookingDate;
		this.slot_no = slot_no;
		this.parkingDuration = parkingDuration;
		this.payment = payment;
	}
	public ParkingSlots() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Constructors, Getter & Setter method
}
