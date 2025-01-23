package com.example.api.demo.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.example.api.demo.entity.Owner;
import com.example.api.demo.entity.Vehicle;
import com.example.api.demo.jwt.JwtUserDetails;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	//public boolean createUsersVehicle(Vehicle vehicle) throws SQLException;

	//public boolean deleteVehicleByVehicleNumber(String vehicleNumber, int userId) throws SQLException;

	//public Vehicle updateVehicle(Vehicle vehicle);

//	public Vehicle findByVehicleNumberAndUserId(String vehicleNumber, long userId);
//	@Query(value = "SELECT * FROM Vehicle v WHERE v.vehicleId=user_Id", nativeQuery = true)
//	public List<Vehicle> findAllVehicles();
	
	public List<Vehicle> findByUser(JwtUserDetails u);

	@Query(value = "SELECT * from Vehicle WHERE Vehicle.USER_ID = ?1",nativeQuery = true)
	public List<Vehicle> findByUser(Long id);
}
