package com.example.api.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.exception.DuplicateParkingFloorException;
import com.example.api.demo.exception.DuplicateParkingPremiseException;
import com.example.api.demo.exception.NoSuchParkingFloorException;
import com.example.api.demo.exception.NoSuchParkingPremiseException;
import com.example.api.demo.repository.ParkingFloorRepository;
import com.example.api.demo.repository.ParkingRepository;

@Service
public class AdminServiceImpl implements AdminServices{
	
	@Autowired
	private ParkingRepository parkingrepository;
	@Autowired
	private ParkingFloorRepository floorrepo;
	
	@Override
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException
	{
		parkingrepository.saveAndFlush(parkingPremise);
		return true;
	}
	
	@Override
	public boolean addParkingFloor(ParkingFloor parkingfloor) throws DuplicateParkingFloorException{
		// TODO Auto-generated method stub
		floorrepo.saveAndFlush(parkingfloor);
		return true;
	}
	
	@Override
	public List<ParkingFloor> getAllParkingFloors() {
		return floorrepo.findAll();
	}
	
	
	@Override
	public Optional<ParkingPremise> getParkingPremiseById(int parkingPremiseId) throws NoSuchParkingPremiseException {
		Optional<ParkingPremise> p = parkingrepository.findById((int) parkingPremiseId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Premise found for this ID");
		return p;
	}
	
	@Override
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException {
		List<ParkingPremise> p = parkingrepository.findByParkingPremiseName(premiseName);
		return p;
	}
	
	@Override
	public List<ParkingPremise> getAllParkingPremises() {
		return parkingrepository.findAll();
	}
	
	@Override
	public boolean removeParkingFloor(long parkingFloorId) throws NoSuchParkingPremiseException {
		Optional<ParkingFloor> p = floorrepo.findById((int) parkingFloorId);
		if(!p.isPresent())
			throw new NoSuchParkingPremiseException("No Parking Floor found for this ID");
		parkingrepository.deleteById((int) parkingFloorId);
		return true;
	}
	
	@Override
	public ParkingFloor getParkingFloorById(int parkingFloorId) throws NoSuchParkingFloorException {
		ParkingFloor p = floorrepo.findById(parkingFloorId).get();
		if(p==null)
			throw new NoSuchParkingFloorException("No Parking Floor found for this ID");
		return p;
	}
	
	@Override
	public List<ParkingFloor> getParkingFloorByNumber(int parkingPremiseId, String floorNumber)
			throws NoSuchParkingFloorException {
		List<ParkingFloor> li = (List<ParkingFloor>) floorrepo.findByFloorNumber(floorNumber);
		return li;
	}

	@Override
	public long countPremises() {
		// TODO Auto-generated method stub
		return parkingrepository.count();
	}
	
}
