package com.mitrais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.entities.User;
import com.mitrais.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User auth(String userName, String userPassword) {
		User user = repo.findByUserNameAndUserPassword(userName, userPassword);
		return user;
	}
}
