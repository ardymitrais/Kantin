package com.mitrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.entities.Category;
import com.mitrais.entities.Menu;
import com.mitrais.repository.CategoryRepository;
import com.mitrais.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public Optional<Menu> findById(Integer id){
		Optional<Menu> menu = repo.findById(id);
		return menu;
	}
	
	public List<Menu> findAll(){
		List<Menu> data = repo.findAll();
		return data;
	}
	
	public String deleteById(int id) {
		Optional<Menu> menuExist = repo.findById(id);
		if(menuExist.isPresent()) {
			repo.deleteById(id);
			return "success";
		}
		else
			return "fail";
	}
	
	public String save(Menu menu) {
		Menu newMenu = repo.save(menu);
		if(newMenu!=null)
			return "success";
		else
			return "fail";
	}
	
	// category
	public List<Category> findAllCategory(){
		List<Category> data = categoryRepo.findAll();
		return data;
	}
	
	public Optional<Category> findCategoryById(Integer id) {
		Optional<Category> category = categoryRepo.findById(id);
		return category;
	}
}
