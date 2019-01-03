package com.mitrais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.entities.Roles;
import com.mitrais.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repo;
	
	public List<Roles> findAll(){
		return repo.findAll();
	}
}
