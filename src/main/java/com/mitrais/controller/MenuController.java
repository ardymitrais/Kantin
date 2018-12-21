package com.mitrais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mitrais.entities.Menu;
import com.mitrais.entities.User;
import com.mitrais.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/*/menu/index")
	public String pageIndex(Model model) {
		List<Menu> dataMakanan = menuService.findAll();
		model.addAttribute("dataMakanan",dataMakanan);
		return "konten/menuIndex";
	}
	
	@DeleteMapping("/*/menu/delete{id}")
	public String pageIndex(Model model, @PathVariable String id) {
		List<Menu> dataMakanan = menuService.findAll();
		model.addAttribute("dataMakanan",dataMakanan);
		return "konten/menuIndex";
	}

}
