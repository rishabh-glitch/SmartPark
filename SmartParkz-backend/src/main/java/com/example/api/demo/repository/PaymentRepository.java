package com.example.api.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.demo.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

	public List<Payment> findAllByPaymentDateTime(java.util.Date paymentDate);
	
}
