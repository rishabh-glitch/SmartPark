package com.example.api.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.entity.ParkingSlots;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor,Integer>{

	List<ParkingFloor> findByFloorNumber(String floorNumber);
}
