package com.example.api.demo.exception;

public class DuplicateParkingFloorException extends Exception {
	
	private String message;
	
	public DuplicateParkingFloorException() {
		super();
	}
	
	public DuplicateParkingFloorException(String message) {
		super();
		this.message=message;
	}
}
