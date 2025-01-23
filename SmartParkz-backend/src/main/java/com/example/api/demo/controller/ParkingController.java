package com.example.api.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.entity.ParkingSlots;
import com.example.api.demo.exception.NoSuchParkingSlotException;
import com.example.api.demo.exception.ParkingSlotNotAvailableException;
import com.example.api.demo.service.ParkingService;

@RestController
@CrossOrigin("*")
public class ParkingController {

	@Autowired
	private ParkingService parkingservice;
	
	@PostMapping("/saveSlot")
	public String bookSlot(@RequestBody @Valid ParkingSlots slot) throws ParkingSlotNotAvailableException
	{
		parkingservice.bookParkingSlot(slot);
		return "saved";
	}	
	
	@GetMapping("/getAllSlots")
	public List<ParkingSlots> getAllSlots()
	{
		return parkingservice.getAllParkingSlots();
	}
	
	@GetMapping("/findBySlotId/{id}")
	public ParkingSlots findBySlotId(@PathVariable Integer id) throws NoSuchParkingSlotException
	{
		return parkingservice.getParkingSlotsById(id);
	}
	
	@GetMapping("/getAllSlots/{id}") 
	public List<ParkingSlots> getSlots(@PathVariable int id)
	{
		
		return parkingservice.getAllParkingSlotsByFloor(id);
	}
	
	
	@GetMapping("/getAllSlotsByPremise/{id}")
	public List<ParkingSlots> getSlotsByPremise(@PathVariable int id)
	{
		
		return parkingservice.getAllParkingSlotsByPremise(id);
	}
	
	@GetMapping("/checkAvailability/{date}")
	public boolean checkAvailability(@PathVariable String date) throws ParkingSlotNotAvailableException, ParseException
	{
		Date slotDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		return parkingservice.checkAvailability(slotDate);
	}

	
	@DeleteMapping("/deleteSlot/{id}")
	public String delete(@PathVariable int id) throws NoSuchParkingSlotException
	{
		parkingservice.cancelParkingSlotBooking(id);
		return "deleted";
	}	
}
