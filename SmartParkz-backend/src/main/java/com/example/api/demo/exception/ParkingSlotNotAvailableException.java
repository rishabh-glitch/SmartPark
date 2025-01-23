package com.example.api.demo.exception;

public class ParkingSlotNotAvailableException extends Exception{
private String msg;
	
	public ParkingSlotNotAvailableException(String msg)
	{
		super();
		this.msg = msg;
	}
	public ParkingSlotNotAvailableException() {
		super();
	}
}
