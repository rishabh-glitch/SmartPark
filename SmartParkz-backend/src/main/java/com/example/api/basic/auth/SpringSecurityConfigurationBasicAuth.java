package com.example.api.basic.auth;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@SuppressWarnings("deprecation")
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()   
	        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            //.formLogin().and()
	            .httpBasic();
	    }

}
//Web Security Configuration Adapter is deprecated so this is how we will do now(mention code above) to authorize.
