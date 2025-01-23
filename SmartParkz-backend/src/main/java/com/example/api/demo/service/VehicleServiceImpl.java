package com.example.api.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.api.demo.entity.Owner;
import com.example.api.demo.entity.Vehicle;
import com.example.api.demo.exception.DuplicateVehicleException;
import com.example.api.demo.exception.NoSuchParkingSlotException;
import com.example.api.demo.exception.NoSuchVehicleException;
import com.example.api.demo.jwt.JwtUserDetails;
import com.example.api.demo.repository.VehicleRepository;



@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleDao;
	
//	the code i am writing is just for testing purpose because i want to call the data from here without storing in database
	
	static JwtUserDetails user = new JwtUserDetails((long) 1,"Rishabh","singh","rishabh123@gmail.com","9012333333","password");
	
	static Vehicle vehicle = new Vehicle(1,"TwoWheeler","UP 30 AB 2020","Ford","X4",user);
	static Vehicle vehicle2 = new Vehicle(1,"TwoWheeler","UP 30 AB 2121","Ford","X4",user);
	private static List<Vehicle> al = new ArrayList<Vehicle>();
	static{al.add(vehicle);
	al.add(vehicle2);}
//	-----------------------------------till here---------------------------------
	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException{
		
		vehicleDao.saveAndFlush(vehicle);
		return true;
	}
//	@Override
//	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, long userId) throws NoSuchVehicleException{
//		Vehicle userVehicle = vehicleDao.findByVehicleNumberAndUserId(vehicleNumber, userId);
//		if(userVehicle == null)
//			throw new NoSuchVehicleException("No Vehicle found for Vehicle Number " + vehicleNumber);
//		return userVehicle;
//	}
	@Override 
	public List<Vehicle> findAllVehiclesByUserId(long ownerId){
		JwtUserDetails u=new JwtUserDetails();
		u.setUserId(ownerId);
		List<Vehicle> vehiclesList = vehicleDao.findByUser(u);

		return vehiclesList;
	}
	@Override
	public boolean removeVehicleByVehicleNumber(long userId) throws NoSuchVehicleException {
//		vehicleDao.deleteById(userId);
		if(vehicleDao.existsById(userId))
		{
			vehicleDao.deleteById(userId);
			return true;
		}
		else
		{
			throw new NoSuchVehicleException();
		}
	}
	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) {
		vehicleDao.save(vehicle);
		return vehicle;
	}
	public List<Vehicle> getAllVehicle(long id) {
		// TODO Auto-generated method stub
		return vehicleDao.findByUser(id);
	}
	

}
