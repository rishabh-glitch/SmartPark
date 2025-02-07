package com.example.api.demo.jwt.resource;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.jwt.JwtTokenUtil;
import com.example.api.demo.jwt.JwtUserDetails;
import com.example.api.demo.repository.UserRepository;
import com.example.api.demo.service.UserServiceImpl;


@RestController
@CrossOrigin("*")
public class JwtAuthenticationRestController {

  @Value("${jwt.http.request.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  
  @Autowired
  private UserServiceImpl service;
  
  @Autowired
  private UserRepository userrepo;

  @Autowired
  private UserDetailsService jwtInMemoryUserDetailsService;
//	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
//			throws AuthenticationException {
//		
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//		
//		final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		
//		return ResponseEntity.ok(new JwtTokenResponse(token));
//	}

  @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
      throws AuthenticationException {

    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    
    //04-08-2023   
    final JwtUserDetails admin = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());      
    if(admin!=null) {
    	final String token = jwtTokenUtil.generateToken(admin);
       	return ResponseEntity.ok(new JwtTokenResponse(token));
    }
//    ---------
    final JwtUserDetails userDetails = userrepo.findByEmail(authenticationRequest.getUsername()).get();

    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtTokenResponse(token));
  }

  @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String authToken = request.getHeader(tokenHeader);
    final String token = authToken.substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.canTokenBeRefreshed(token)) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

  @ExceptionHandler({ AuthenticationException.class })
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("INVALID_CREDENTIALS", e);
    }
  }
  @PostMapping("/create-user")
  public JwtUserDetails createUser(@RequestBody JwtUserDetails user) {
	  return service.createUser(user);
  }
}

//package com.example.api.demo.jwt.resource;
//
//import java.util.Objects;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.api.demo.jwt.JwtTokenUtil;
//import com.example.api.demo.jwt.JwtUserDetails;
//
//
//@RestController
//@CrossOrigin("*")
//public class JwtAuthenticationRestController {
//	
//	@Value("${jwt.http.request.header}")
//	private String tokenHeader;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
//	@Autowired
//	private UserDetailsService jwtInMemoryUserDetailsService;
//	
//	@RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
//			throws AuthenticationException {
//		
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//		
//		final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		
//		return ResponseEntity.ok(new JwtTokenResponse(token));
//	}
//	
//	@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
//	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//		String authToken = request.getHeader(tokenHeader);
//		final String token = authToken.substring(7);
//		String username = jwtTokenUtil.getUsernameFromToken(token);
//		JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);
//		
//		if (jwtTokenUtil.canTokenBeRefreshed(token)) {
//			String refreshedToken = jwtTokenUtil.refreshToken(token);
//			return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
//		} else {
//			return ResponseEntity.badRequest().body(null);
//		}
//	}
//	
//	@ExceptionHandler({ AuthenticationException.class })
//	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//	}
//	
//	private void authenticate(String username, String password) {
//		Objects.requireNonNull(username);
//		Objects.requireNonNull(password);
//		
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new AuthenticationException("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new AuthenticationException("INVALID_CREDENTIALS", e);
//		}
//	}
//	
//}
//
