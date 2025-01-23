package com.example.api.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@NotNull(message = "Payment Type cannot be empty")
	private String type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paymentDateTime = new Date(System.currentTimeMillis());
//	private Date paymentDateTime;
	@NotNull(message = "Paid Amount cannot be empty")
	private double amountPaid;
	@NotNull(message = "update status")
	private String status;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getPaymentDateTime() {
		return paymentDateTime;
	}
	public void setPaymentDateTime(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Payment(int paymentId, @NotNull(message = "Payment Type cannot be empty") String type, Date paymentDateTime,
			@NotNull(message = "Paid Amount cannot be empty") double amountPaid,
			@NotNull(message = "update status") String status) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.paymentDateTime = paymentDateTime;
		this.amountPaid = amountPaid;
		this.status = status;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
