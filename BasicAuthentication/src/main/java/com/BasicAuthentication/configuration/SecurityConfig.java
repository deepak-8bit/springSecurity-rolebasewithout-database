package com.BasicAuthentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .csrf().disable()

		     .authorizeRequests()
		     .antMatchers("/admin/**").hasRole("ADMIN")
		     .antMatchers("/user/**").hasRole("USER")
		     .antMatchers("/**").permitAll()
		     
		     .anyRequest()
		     .authenticated()
		     .and()
		     .httpBasic();
		    
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.inMemoryAuthentication()
		.withUser("deepak").password(this.passwordEncoder().encode("deepak@123")).roles("ADMIN")
		.and()
		.withUser("sunny").password(this.passwordEncoder().encode("sunny@123")).roles("USER");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	public PasswordEncoder passwordEncoders() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	

}
