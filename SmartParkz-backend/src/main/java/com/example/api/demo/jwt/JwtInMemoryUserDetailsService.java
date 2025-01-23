package com.example.api.demo.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.example.api.demo.entity.Owner;
import com.example.api.demo.repository.UserRepository;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

// changed on 04-08-23
  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "admin","smartparkz","admin@123","9044567756",
        "$2a$10$WLFXJ40gQQAWANB2a/Vu8ueqcZkErDI69ccLD2ChyIRxiAVHS85mS"));
  }
//    inMemoryUserList.add(new JwtUserDetails(2L, "rishabh",
//    		"$2a$10$GBhEZ8iw7cv3FOn0DN5oqOUA9dp9i0./7dLiZb0H1sGFwLzANhpFy", "ROLE_USER_2"));
////    "$2a$10$GBhEZ8iw7cv3FOn0DN5oqOUA9dp9i0./7dLiZb0H1sGFwLzANhpFy"
//
//  }
  

	@Autowired
	private UserRepository userRepository;
  @Override
  public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//	  JwtUserDetails user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)));
//	  return user;
	  
// changes on 04-08-23	
	
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(admin -> admin.getUsername().equals(username)).findFirst();

    if(findFirst.isPresent()) {
    	return findFirst.get();
    }
	 JwtUserDetails user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)));
 
    return user;
//    if (!findFirst.isPresent())  {
//      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//    }
//
//    return findFirst.get();
  }

}


