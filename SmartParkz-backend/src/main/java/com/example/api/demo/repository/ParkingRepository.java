package com.example.api.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.demo.entity.ParkingPremise;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingPremise,Integer>{
	List<ParkingPremise> findByParkingPremiseName(String parkingPremiseName);
	ParkingPremise findByParkingPremiseId(int parkingPremiseId);
}
