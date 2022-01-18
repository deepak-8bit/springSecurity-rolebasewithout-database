package com.BasicAuthentication.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BasicAuthentication.modal.User;
import com.BasicAuthentication.service.AppService;

@RestController
@RequestMapping("/user")
public class AppController {
	
	
	@Autowired
	private AppService appservice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/save")
	public User saveuser(@Valid @RequestBody User user) {
		String pwd =user.getPassword();
		String ecrptpwd=passwordEncoder.encode(pwd);
		user.setPassword(ecrptpwd);
		return appservice.saveuser(user);
//		return "user added =  "+user.getId();
		
	}
	
	@PostMapping("/saveusers")
	public List<User> saveusers(@RequestBody List<User> user) {
		return appservice.saveusers(user);
//		return "save successfully";
		
	}
	
	
	@GetMapping("/showall")
	public List<User> showalluser(){
		return appservice.showall();
	}
	
	@GetMapping("/show/{id}")
	public Optional<User> showuser(@PathVariable Long id){
		return appservice.showuser(id);
	}
	
}
