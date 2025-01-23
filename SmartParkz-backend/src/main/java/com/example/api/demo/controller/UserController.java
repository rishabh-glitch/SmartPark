package com.example.api.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.entity.Vehicle;
//import com.example.api.demo.entity.Owner;
import com.example.api.demo.jwt.JwtUserDetails;
import com.example.api.demo.jwt.resource.JwtTokenRequest;
import com.example.api.demo.repository.UserRepository;
import com.example.api.demo.repository.VehicleRepository;
import com.example.api.demo.service.UserService;
@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	private UserService userserv;

	@GetMapping("/users")
	public List<JwtUserDetails> getUser(){
		System.out.println("Getting users");
		return userserv.getUsers();
	}
	@GetMapping("/getUser/{id}")
	private List<Vehicle> getId(@PathVariable String id) {
		return userserv.getId(id);
	}
}
 


//	@PostMapping("/login")
//	public String login(@RequestBody JwtTokenRequest user) {
//		JwtUserDetails authuser=userRepository.findUser(user.getUsername(), user.getPassword());
//		String a = authuser.getEmail();
//		String b = "admin@123";
//		if(a.equals(b))
//		{
//			return "logged in as a admin";
//		}
//		if(Objects.nonNull(authuser))
//		{
//			return "logged in";
//		}
//		else {
//			return "failed";
//		}
//	}
	
//package com.example.api.demo.controller;
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.api.demo.entity.Owner;
//import com.example.api.demo.repository.UserRepository;
//import com.example.api.demo.service.UserService;
//@CrossOrigin("*")
//@RestController
//public class UserController {
//	@Autowired
//	private UserService userserv;
//	@Autowired
//	private UserRepository userRepository;
//	
//	@PostMapping("/saveUser")
//	public String saveUser(@RequestBody Owner owner) {
//		if(owner.getEmail()=="admin")
//		{
//			return "cannot save";
//		}
//		else
//		{			
//			userserv.saveUser(owner);
//			return "saved";
//		}
//	}
//	
//	@PostMapping("/login")
//	public String login(@RequestBody Owner user) {
//		Owner authuser=userRepository.findUser(user.getEmail(), user.getPassword());
//		String a = authuser.getEmail();
//		String b = "admin@123";
//		if(a.equals(b))
//		{
//			return "logged in as a admin";
//		}
//		if(Objects.nonNull(authuser))
//		{
//			return "logged in";
//		}
//		else {
//			return "failed";
//		}
//	}
//	
//}
