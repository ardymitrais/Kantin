package com.mitrais.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitrais.entities.Category;
import com.mitrais.entities.Menu;
import com.mitrais.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping({"/admin/menu/index", "/pelanggan/menu/index"})
	public String pageMenuIndex(Model model) {
		List<Menu> dataMakanan = menuService.findAll();
		model.addAttribute("dataMakanan",dataMakanan);
		return "konten/menu/menuIndex";
	}
	
	@GetMapping("/admin/menu/baru")
	public String pageMenuBaru(Model model) {
		model.addAttribute("dataKategori",menuService.findAllCategory());
		model.addAttribute("menu", new Menu());
		model.addAttribute("submitUrl", "/admin/menu/simpan");
		return "konten/menu/menuBaru";
	}
	
	@GetMapping("/admin/menu/ubah/{id}")
	public String pageMenuUbah(Model model, @PathVariable String id) {
		List<Category> dataKategori = menuService.findAllCategory();

		Optional<Menu> dataMenu = menuService.findById( Integer.parseInt(id) );
		if(dataMenu.isPresent())
			model.addAttribute("menu", dataMenu.get());
		
		model.addAttribute("submitUrl", "/admin/menu/simpan");
		model.addAttribute("dataKategori",dataKategori);
		return "konten/menu/menuBaru";
	}
	
	@PostMapping("/admin/menu/simpan")
	public String pageMenuSimpan(Model model, RedirectAttributes redirectAttributes, @Valid Menu newMenu, Errors error) {
		System.out.println(newMenu.getMenuId());
		if(error.hasErrors()) {
			model.addAttribute("dataKategori",menuService.findAllCategory());
			return "konten/menu/menuBaru";
		}
		
		String status = menuService.save(newMenu);
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil disimpan" : "Data gagal disimpan!"));
		return "redirect:/admin/menu/index";
	}
	
	@GetMapping("/admin/menu/hapus/{id}")
	public String pageMenuHapus(RedirectAttributes redirectAttributes, @PathVariable String id) {
		String status = menuService.deleteById( Integer.parseInt(id) );
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil dihapus" : "Data gagal dihapus!"));
		return "redirect:/admin/menu/index";
	}

}
