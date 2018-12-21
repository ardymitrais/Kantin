package com.mitrais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.entities.Menu;
import com.mitrais.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository repo;
	
	public List<Menu> findAll(){
		List<Menu> data = repo.findAll();
		return data;
	}
	public void deleteById(int id) {
		
	}
}
