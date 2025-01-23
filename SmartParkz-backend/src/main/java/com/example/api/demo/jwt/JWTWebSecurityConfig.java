//package com.example.api.demo.jwt;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class JWTWebSecurityConfig {
//
//    @Autowired
//    private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;
//
//    @Autowired
//    private UserDetailsService jwtInMemoryUserDetailsService;
//
//    @Autowired
//    private JwtTokenAuthorizationOncePerRequestFilter jwtAuthenticationTokenFilter;
//
//    @Value("${jwt.get.token.uri}")
//    private String authenticationPath;
//
// /*   @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(jwtInMemoryUserDetailsService)
//            .passwordEncoder(new BCryptPasswordEncoder());
//    }*/
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//    	DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
//    	provider.setUserDetailsService(jwtInMemoryUserDetailsService);
//    	provider.setPasswordEncoder(new BCryptPasswordEncoder());
//    	return provider;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoderBean() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//            .csrf().disable()
//            .exceptionHandling().authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeRequests()
//            .anyRequest().authenticated();
//
//       httpSecurity
//            .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        
//        httpSecurity
//            .headers()
//            .frameOptions().sameOrigin()  //H2 Console Needs this setting
//            .cacheControl(); //disable caching
//        
//        httpSecurity.authenticationProvider(daoAuthenticationProvider());
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (webSecurity)->
//            webSecurity.ignoring()
//            .antMatchers(
//                HttpMethod.POST,
//                authenticationPath
//            )
//            .antMatchers(HttpMethod.OPTIONS, "/**")
//            .and()
//            .ignoring()
//            .antMatchers(
//                HttpMethod.GET,
//                "/" //Other Stuff You want to Ignore
//            )
//            .and()
//            .ignoring()
//            .antMatchers("/h2-console/**/**");//Should not be in Production!
//    }
//}


package com.example.api.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;
	
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenAuthorizationOncePerRequestFilter jwtAuthenticationTokenFilter;
	
	@Value("${jwt.get.token.uri}")
	private String authenticationPath;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(jwtInMemoryUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/create-user").permitAll()
		.anyRequest().authenticated();
		
		httpSecurity
		.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity
		.headers()
		.frameOptions().sameOrigin()  //H2 Console Needs this setting
		.cacheControl(); //disable caching
	}
	
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity
		.ignoring()
		.antMatchers(
				HttpMethod.POST,
				authenticationPath
				)
		.antMatchers(HttpMethod.OPTIONS, "/**")
		.and()
		.ignoring()
		.antMatchers(
				HttpMethod.GET,
				"/" //Other Stuff You want to Ignore
				)
		.and()
		.ignoring()
		.antMatchers("/h2-console/**/**");//Should not be in Production!
	}
	
	public JwtUserDetails getLoggedInUser() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && auth.getPrincipal() instanceof JwtUserDetails) {
	        return (JwtUserDetails) auth.getPrincipal();
	    }
	    return null;
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		  provider.setUserDetailsService(jwtInMemoryUserDetailsService);
		  provider.setPasswordEncoder(passwordEncoder());
		  return provider;
	}
}


