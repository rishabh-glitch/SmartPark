package com.example.api.demo.exception;

public class NoSuchPaymentFoundException extends Exception {
    
	private String message;
	
	public NoSuchPaymentFoundException() {
		super();
	}
	
	public NoSuchPaymentFoundException(String message) {
		super();
		this.message=message;
	}
}
