package com.mitrais.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitrais.entities.Category;
import com.mitrais.entities.Menu;
import com.mitrais.entities.User;
import com.mitrais.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/admin/menu/index")
	public String pageMenuIndex(Model model) {
		List<Menu> dataMakanan = menuService.findAll();
		model.addAttribute("dataMakanan",dataMakanan);
		return "konten/menu/menuIndex";
	}
	
	@GetMapping("/admin/menu/baru")
	public String pageMenuBaru(Model model) {
		List<Category> dataKategori = menuService.findAllCategory();
		model.addAttribute("dataKategori",dataKategori);
		model.addAttribute("menu", new Menu());
		model.addAttribute("submitUrl", "/admin/menu/simpanBaru");
		return "konten/menu/menuBaru";
	}
	
	@GetMapping("/admin/menu/ubah/{id}")
	public String pageMenuUbah(Model model, @PathVariable String id) {
		List<Category> dataKategori = menuService.findAllCategory();

		Optional<Menu> dataMenu = menuService.findById( Integer.parseInt(id) );
		if(dataMenu.isPresent())
			model.addAttribute("menu", dataMenu.get());
		
		model.addAttribute("submitUrl", "/admin/menu/simpanPerubahan");
		model.addAttribute("dataKategori",dataKategori);
		return "konten/menu/menuBaru";
	}
	
	@PostMapping("/admin/menu/simpanBaru")
	public String pageMenuSimpanBaru(RedirectAttributes redirectAttributes, Menu newMenu) {
		String status = menuService.save(newMenu);
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil disimpan" : "Data gagal disimpan!"));
		return "redirect:/admin/menu/index";
	}
	
	@PostMapping("/admin/menu/simpanPerubahan")
	public String pageMenuSimpanPerubahan(RedirectAttributes redirectAttributes, Menu newMenu) {
		String status = menuService.save(newMenu);
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil diubah" : "Data gagal diubah!"));
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
