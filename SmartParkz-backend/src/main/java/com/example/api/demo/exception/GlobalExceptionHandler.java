package com.example.api.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//import com.example.vehicle_insurance_system.exception.VehicleAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ParkingSlotNotAvailableException.class)
	public ResponseEntity<String> SlotNotAvailable(ParkingSlotNotAvailableException slot)
	{
		return new ResponseEntity<String>("No parking slot available",HttpStatus.CONFLICT);
	}
	//NoSuchParkingSlotException
	@ExceptionHandler(value = NoSuchParkingSlotException.class)
	public ResponseEntity<String> noSuchParking(NoSuchParkingSlotException slot)
	{
		return new ResponseEntity<String>("no parking with that id",HttpStatus.BAD_REQUEST);
	}
	
	//NoSuchVehicleException
	@ExceptionHandler(value = NoSuchVehicleException.class) //handler, custom exception
	public ResponseEntity<String> NoSuchVehicleException(NoSuchVehicleException vehicle){
		return new ResponseEntity<String>("this vehicle does not exist", HttpStatus.CONFLICT);
	}
	
	//NoSuchPaymentFoundException
	//httpstatus can be payment required if digital cash is used
	@ExceptionHandler(value = NoSuchPaymentFoundException.class) //handler, custom exception
	public ResponseEntity<String> NoSuchPaymentFoundException(NoSuchPaymentFoundException payment){
		return new ResponseEntity<String>("Such payment does not exists", HttpStatus.CONFLICT);
	}
	
	//DuplicateVehicleException
	@ExceptionHandler(value = DuplicateVehicleException.class) //handler, custom exception
	public ResponseEntity<String> DuplicateVehicleException(DuplicateVehicleException vehicle){
		return new ResponseEntity<String>("duplicate user being accessed", HttpStatus.BAD_REQUEST);
		
	}
	
}
