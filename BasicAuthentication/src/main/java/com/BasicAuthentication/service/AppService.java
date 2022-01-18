package com.BasicAuthentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BasicAuthentication.modal.User;
import com.BasicAuthentication.repository.AppRepository;

@Service
public class AppService {

	@Autowired
	private AppRepository repo;

	public User saveuser(User user) {
		return repo.save(user);
	}
	
	public List<User> saveusers(List<User> user){
		return (List<User>) repo.saveAll(user);	
	}
	
	
	public List<User> showall(){
		return (List<User>) repo.findAll();
	}
	
	public Optional<User> showuser(Long id) {
		return repo.findById(id);
		
	}
	
}
