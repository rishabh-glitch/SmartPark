package com.example.api.demo.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;
  
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String firstName;
	private String lastName;
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp = "^[6-9]*\\d{9}")
	private String mobile;
	@NotNull
	@Size(min=2,message="min 5 chars in pass")
	private String password;


	public Long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public JwtUserDetails(Long userId, String firstName, String lastName, @Email String email,
			@NotBlank @Pattern(regexp = "^[6-9]*\\d{9}") String mobile,
			@Size(min = 2, message = "min 5 chars in pass") String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}


	public JwtUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


//  private final Long id;
//  private final String username;
//  private final String password;
//  private final Collection<? extends GrantedAuthority> authorities;

//  public JwtUserDetails(Long id, String username, String password, String role) {
//    this.id = id;
//    this.username = username;
//    this.password = password;
//
//    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//    authorities.add(new SimpleGrantedAuthority(role));
//
//    this.authorities = authorities;
//  }

  @JsonIgnore
  public Long getId() {
    return userId;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

//  @JsonIgnore
//  @Override
//  public String getPassword() {
//    return password;
//  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}


//package com.example.api.demo.jwt;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//public class JwtUserDetails implements UserDetails {
//	
//	private static final long serialVersionUID = 5155720064139820502L;
//	
//	private final Long id;
//	private final String username;
//	private final String password;
//	private final Collection<? extends GrantedAuthority> authorities;
//	
//	public JwtUserDetails(Long id, String username, String password, String role) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(role));
//		
//		this.authorities = authorities;
//	}
//	
//	@JsonIgnore
//	public Long getId() {
//		return id;
//	}
//	
//	@Override
//	public String getUsername() {
//		return username;
//	}
//	
//	@JsonIgnore
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//	
//	@JsonIgnore
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//	
//	@JsonIgnore
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//	
//	@JsonIgnore
//	@Override
//	public String getPassword() {
//		return password;
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//	
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//	
//}
//
//
