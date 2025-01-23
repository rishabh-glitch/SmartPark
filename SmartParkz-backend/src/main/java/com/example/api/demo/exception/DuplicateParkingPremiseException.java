package com.example.api.demo.exception;

public class DuplicateParkingPremiseException extends Exception {
    private String message;
	
	public DuplicateParkingPremiseException() {
		super();
	}
	
	public DuplicateParkingPremiseException(String message) {
		super();
		this.message=message;
	}
}
