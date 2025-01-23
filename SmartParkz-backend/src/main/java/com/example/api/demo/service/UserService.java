package com.example.api.demo.service;

import java.util.List;

import com.example.api.demo.entity.Vehicle;
import com.example.api.demo.jwt.JwtUserDetails;

public interface UserService{

	public List<JwtUserDetails> getUsers();
	public JwtUserDetails createUser(JwtUserDetails user);
	public List<Vehicle> getId(String email);

}
//package com.example.api.demo.service;
//
//import com.example.api.demo.entity.Owner;
//
//public interface UserService{
//	
//	void saveUser(Owner owner);
//	
//}
