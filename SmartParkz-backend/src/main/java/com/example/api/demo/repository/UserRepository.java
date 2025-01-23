
package com.example.api.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.api.demo.jwt.JwtUserDetails;

@Repository
public interface UserRepository extends JpaRepository<JwtUserDetails,Long>{
	@Query(value = "SELECT * FROM owner s WHERE s.email=?1 and s.password=?2", nativeQuery = true)
	public JwtUserDetails findUser(String email, String pass);
	
	@Query(value = "SELECT * FROM JWT_USER_DETAILS where EMAIL = ?1",nativeQuery = true)
	public Optional<JwtUserDetails> findByEmail(String email);// after changes for storing and getting user from database.
}

//package com.example.api.demo.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.example.api.demo.entity.Owner;
//
//@Repository
//public interface UserRepository extends JpaRepository<Owner,Integer>{
//	@Query(value = "SELECT * FROM owner s WHERE s.email=?1 and s.password=?2", nativeQuery = true)
//	public Owner findUser(String email, String pass);
//}
