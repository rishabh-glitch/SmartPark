package com.example.api.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.demo.entity.Vehicle;
import com.example.api.demo.exception.DuplicateVehicleException;
import com.example.api.demo.exception.NoSuchVehicleException;



@Service
public interface VehicleService {
	
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException;

//	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, long userId) throws NoSuchVehicleException;

	public List<Vehicle> findAllVehiclesByUserId(long ownerId);

	public boolean removeVehicleByVehicleNumber(long userId) throws NoSuchVehicleException;

	public Vehicle modifyVehicle(Vehicle vehicle);

	public List<Vehicle> getAllVehicle(long id);
}

