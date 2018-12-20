package com.mitrais.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mitrais.model.interfaces.Menu;
import com.mitrais.service.MenuService;

@Controller
public class MakananController {
	@GetMapping({"/kantin/admin/list","/kantin/pelanggan/list"})
	public String pageMenuIndex(Model model) {
		
		MenuService menuService = new MenuService();
		List<Menu> myMenu = menuService.getAll();
		
		model.addAttribute("listMakanan", myMenu);
		return "/listMakanan";
	}
}
