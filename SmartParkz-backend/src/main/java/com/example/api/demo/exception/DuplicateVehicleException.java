package com.example.api.demo.exception;

public class DuplicateVehicleException extends Exception {
    private String message;
	
	public DuplicateVehicleException() {
		super();
	}
	
	public DuplicateVehicleException(String message) {
		super();
		this.message=message;
	}
}
