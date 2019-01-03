package com.mitrais.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String pageMenuLogin() {
		return "login";
	}
	
	@GetMapping("/kantin/home")
	public String pageHome(HttpServletRequest req) {
		return "konten/home";
	}
}
