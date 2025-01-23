//package com.example.api.demo.entity;
//
//import java.util.Collection;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@Entity
//public class Owner implements UserDetails{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int userId;
//	private String firstName;
//	private String lastName;
//	@Email
//	private String email;
//	@NotBlank
//	@Pattern(regexp = "^[6-9]*\\d{9}")
//	private String mobile;
//	@NotNull
//	@Size(min=2,message="min 5 chars in pass")
//	private String password;
//
//
//	public int getUserId() {
//		return userId;
//	}
//
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//
//	public String getLastName() {
//		return lastName;
//	}
//
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//
//	public String getEmail() {
//		return email;
//	}
//
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//
//	public String getMobile() {
//		return mobile;
//	}
//
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public Owner(int userId, String firstName, String lastName, @Email String email,
//			@NotBlank @Pattern(regexp = "^[6-9]*\\d{9}") String mobile,
//			@Size(min = 2, message = "min 5 chars in pass") String password) {
//		super();
//		this.userId = userId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.mobile = mobile;
//		this.password = password;
//	}
//
//
//	public Owner() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.email;
//	}
//
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	
//}
