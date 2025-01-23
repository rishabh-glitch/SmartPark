package com.example.api.demo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.entity.Payment;
import com.example.api.demo.exception.NoSuchPaymentFoundException;
import com.example.api.demo.service.PaymentService;
@CrossOrigin("*")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;
	
	@GetMapping("/getPaymentById/{paymentId}")
	public Optional<Payment> findPaymentById(@PathVariable Integer paymentId) throws NoSuchPaymentFoundException
	{
		return paymentservice.findPaymentById(paymentId);
	} 
	
	@GetMapping("/getPaymentByDate/{paymentDateTime}")
	public List<Payment> findPaymentByDate(@PathVariable(name = "paymentDateTime") String paymentDate) throws NoSuchPaymentFoundException, ParseException
	{
		Date payDate = new SimpleDateFormat("yyyy-MM-dd").parse(paymentDate);
		return paymentservice.findPaymentByDate(payDate);
	}
}













