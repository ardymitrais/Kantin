package com.mitrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mitrais.entities.User;
import com.mitrais.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	public User auth(String userName, String userPassword) {
		User user = repo.findByUserNameAndUserPassword(userName, userPassword);
		return user;
	}
	
	public Optional<User> findById(Integer id){
		return repo.findById(id);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public String deleteById(int id) {
		Optional<User> dataExist = repo.findById(id);
		if(dataExist.isPresent()) {
			repo.deleteById(id);
			return "success";
		}
		else
			return "fail";
	}
	
	public String save(User dataInsertOrDelete) {
		User result = repo.save(dataInsertOrDelete);
		if(result!=null)
			return "success";
		else
			return "fail";
	}
}
