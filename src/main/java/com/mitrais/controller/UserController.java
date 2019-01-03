package com.mitrais.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitrais.entities.User;
import com.mitrais.service.RoleService;
import com.mitrais.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/admin/user/index")
	public String pageIndex(Model model) {
		model.addAttribute("dataUser",userService.findAll());
		return "konten/user/userIndex";
	}
	
	@GetMapping("/admin/user/baru")
	public String pageBaru(Model model) {
		model.addAttribute("dataRole",roleService.findAll());
		model.addAttribute("user", new User());
		return "konten/user/userForm";
	}
	
	@GetMapping("/admin/user/ubah/{id}")
	public String pageUbah(Model model, @PathVariable String id) {
		Optional<User> dataUser = userService.findById( Integer.parseInt(id) );
		if(dataUser.isPresent())
			model.addAttribute("user", dataUser.get());
		else
			model.addAttribute("user", new User());
		
		model.addAttribute("dataRole",roleService.findAll());
		return "konten/user/userForm";
	}
	
	@PostMapping("/admin/user/simpan")
	public String pageSimpan(Model model, RedirectAttributes redirectAttributes, @Valid User newData, Errors error) {
		
		if( newData.getUserId()==null ){
			//insert
			newData.setUserPassword( bCryptPasswordEncoder.encode(newData.getUserPassword()) );
		}
		else {
			//update
			if(newData.getUserPassword().matches("~stillsame~")) {
				Optional<User> dataUser = userService.findById(newData.getUserId());
				if(dataUser.isPresent()) {
					User dataUserLama = dataUser.get();
					newData.setUserPassword( dataUserLama.getUserPassword() );
				}
			}
			else
				newData.setUserPassword( bCryptPasswordEncoder.encode(newData.getUserPassword()) );				
			
		}
		
		if(error.hasErrors()) {
			model.addAttribute("dataRole",roleService.findAll());
			return "konten/user/userForm";
		}
		
		String status = userService.save(newData);
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil disimpan" : "Data gagal disimpan!"));
		return "redirect:/admin/user/index";
	}
	
	@GetMapping("/admin/user/hapus/{id}")
	public String pageHapus(RedirectAttributes redirectAttributes, @PathVariable String id) {
		String status = userService.deleteById( Integer.parseInt(id) );
		redirectAttributes.addFlashAttribute("status", status);
		redirectAttributes.addFlashAttribute("message", (status=="success"? "Data berhasil dihapus" : "Data gagal dihapus!"));
		return "redirect:/admin/user/index";
	}

}
