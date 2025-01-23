package com.example.api.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.exception.DuplicateParkingFloorException;
import com.example.api.demo.exception.DuplicateParkingPremiseException;
import com.example.api.demo.exception.NoSuchParkingFloorException;
import com.example.api.demo.exception.NoSuchParkingPremiseException;

public interface AdminServices {
//	public boolean login(Login login) throws InvalidLoginCredintialException;

//	public boolean blockUser(User user) throws NoSuchUserException;

	// Parking Premise
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException;
	public Optional<ParkingPremise> getParkingPremiseById(int parkingPremiseId) throws NoSuchParkingPremiseException;

	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException;

	public List<ParkingPremise> getAllParkingPremises();


//	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise);
//
//	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException;
//
//	// Parking Floor
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException;
	
	public ParkingFloor getParkingFloorById(int parkingFloorId) throws NoSuchParkingFloorException;
	
	public List<ParkingFloor> getParkingFloorByNumber(int parkingPremiseId, String floorNumber)
			throws NoSuchParkingFloorException;

	public List<ParkingFloor> getAllParkingFloors();


//	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor);

	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException;
	public long countPremises();
}
