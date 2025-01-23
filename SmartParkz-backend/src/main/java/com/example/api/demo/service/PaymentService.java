package com.example.api.demo.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.api.demo.entity.Payment;
import com.example.api.demo.exception.NoSuchPaymentFoundException;

public interface PaymentService {

	public Optional<Payment> findPaymentById(Integer paymentId) throws NoSuchPaymentFoundException;

	public List<Payment> findPaymentByDate(Date paymentDate) throws NoSuchPaymentFoundException;
}
