package com.example.api.demo.exception;

public class NoSuchParkingFloorException extends Exception {
    private String message;
	
	public NoSuchParkingFloorException() {
		super();
	}
	
	public NoSuchParkingFloorException(String message) {
		super();
		this.message=message;
	}
}
