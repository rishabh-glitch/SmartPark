package com.example.api.demo.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.entity.ParkingSlots;
import com.example.api.demo.exception.NoSuchParkingSlotException;
import com.example.api.demo.exception.ParkingSlotNotAvailableException;


public interface ParkingService {

	boolean bookParkingSlot(ParkingSlots parkingslot) throws ParkingSlotNotAvailableException;

	public ParkingSlots getParkingSlotsById(Integer parkingSlotId) throws NoSuchParkingSlotException;
	
	public List<ParkingSlots> getAllParkingSlotsByFloor(int parkingFloorId);

	public boolean cancelParkingSlotBooking(int id) throws NoSuchParkingSlotException;

	List<ParkingSlots> getAllParkingSlotsByPremise(int parkingpremiseid);

	public boolean checkAvailability(Date date) throws ParkingSlotNotAvailableException;

	List<ParkingSlots> getAllParkingSlots();
}
