package com.example.api.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.api.demo.entity.Vehicle;
//import com.example.api.demo.entity.Owner;
import com.example.api.demo.jwt.JwtUserDetails;
import com.example.api.demo.repository.UserRepository;
import com.example.api.demo.repository.VehicleRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private VehicleRepository vehiclerepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<JwtUserDetails> getUsers(){
		return userrepo.findAll();
	}

	@Override
	public JwtUserDetails createUser(JwtUserDetails user) {
		// TODO Auto-generated method stub
//		user.setUserId(UUID.randomUUID());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userrepo.save(user);
	}

	@Override
	public List<Vehicle> getId(String email) {
		// TODO Auto-generated method stub
		Optional<JwtUserDetails> user =  userrepo.findByEmail(email);
		Long id = user.get().getUserId();
		System.out.println("---------------Value of ----------------------");
		System.out.println("---------------Value of ----------------------"+id);
		return vehiclerepo.findByUser(id);
	}

}
//package com.example.api.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.api.demo.entity.Owner;
//import com.example.api.demo.repository.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService{
//	@Autowired
//	private UserRepository userrepo;
//	
//	@Override
//	public void saveUser(Owner owner) {
//		// TODO Auto-generated method stub
//		userrepo.save(owner);
//	}
//	
//}
