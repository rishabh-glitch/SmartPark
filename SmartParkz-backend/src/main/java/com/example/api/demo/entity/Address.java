package com.example.api.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Address {
	// should be auto-generated
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int addressId;
		@NotNull
		private String city;
		@NotNull
		private String state;
		@NotNull
		private String pin;
		
		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public Address(int addressId, String city, String state, String pin) {
			super();
			this.addressId = addressId;
			this.city = city;
			this.state = state;
			this.pin = pin;
		}
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}

		// Constructors, Getter & Setter method
}
