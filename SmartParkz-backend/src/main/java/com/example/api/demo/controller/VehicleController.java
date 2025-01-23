package com.example.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.entity.Vehicle;
import com.example.api.demo.exception.DuplicateVehicleException;
import com.example.api.demo.exception.NoSuchVehicleException;
import com.example.api.demo.jwt.JWTWebSecurityConfig;
import com.example.api.demo.jwt.JwtUserDetails;
import com.example.api.demo.service.VehicleService;


@CrossOrigin("*")
@RestController
@RequestMapping("vehicles")
public class VehicleController {
	@Autowired
	VehicleService service;
	@Autowired JWTWebSecurityConfig config;
	@PostMapping("/add")
	public ResponseEntity<String> addUsersVehicle(@RequestBody Vehicle vehicle) throws DuplicateVehicleException {
		service.addUsersVehicle(vehicle);
		return new ResponseEntity<String>("Added", HttpStatus.CREATED);
	}
	@GetMapping("/users/{userId}")
	public List<Vehicle> fetchAllVehiclesByUserId(@PathVariable long userId) {
		return service.findAllVehiclesByUserId(userId);
	}
//	@GetMapping("/{vehicleNumber}/users/{userId}")
//		public Vehicle fetchVehicleByVehicleNumberAndUserId(@PathVariable String vehicleNumber,@PathVariable long userId) throws NoSuchVehicleException 
//		{
//			return service.findVehicleByVehicleNumber(vehicleNumber, userId);
//		}
	@DeleteMapping("/users/{Id}")
	public ResponseEntity<String> removeUsersVehicle(@PathVariable long Id) throws NoSuchVehicleException {
		service.removeVehicleByVehicleNumber(Id);
		return new ResponseEntity<String>("Vehicle removed successfully", HttpStatus.OK);
	}
	@PutMapping 
	public ResponseEntity<String> modifyUsersVehicle(@RequestBody Vehicle vehicle) {
		service.modifyVehicle(vehicle);
		return new ResponseEntity<String>("Vehicle details updated", HttpStatus.OK);
	}
	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicles(){
		JwtUserDetails user = config.getLoggedInUser();
		long id = user.getId();
		return service.getAllVehicle(id);
	}
}
