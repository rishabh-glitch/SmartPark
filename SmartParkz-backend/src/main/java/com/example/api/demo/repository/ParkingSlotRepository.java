package com.example.api.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.api.demo.entity.ParkingFloor;
import com.example.api.demo.entity.ParkingPremise;
import com.example.api.demo.entity.ParkingSlots;
import com.example.api.demo.entity.Payment;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlots,Integer>{

	@Query("select p from ParkingSlots p")
	public List<ParkingSlots> getSlots();
	
	@Query(value = "select * from parking_floor join parking_slots "
			+ "on parking_floor.parking_floor_id = parking_slots.parking_floor_reference_id "
			+ "where parking_slots.parking_floor_reference_id=?1", 
			  nativeQuery = true)
	List<ParkingSlots> findAllParkingSlot(int id);

	@Query(value = "select *from parking_floor join parking_slots "
			+ "on parking_floor.parking_floor_id = parking_slots.parking_floor_reference_id join parking_premise "
			+ "on parking_premise.parking_premise_id = parking_floor.premise_id "
			+ "where parking_floor.premise_id=?1",
			nativeQuery = true)
	public List<ParkingSlots> findAllParkingSlotByPremise(int parkingpremiseid);

	public List<ParkingSlots> findAllByBookingDate(Date date);

	public List<ParkingSlots> findAllByParkingDate(Date date);
	
	@Query(value = "select *from parking_slots where parking_floor_reference_id =?1 and slot_no = ?2",nativeQuery = true)
	public List<ParkingSlots> findSlotOnFloorId(int parkingFloorId,int slot_no);
}