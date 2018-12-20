package com.mitrais.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mitrais.entities.Makanan;
import com.mitrais.entities.Minuman;
import com.mitrais.model.interfaces.Menu;

@Service
public class MenuService {
	
	private List<Menu> myMenu = new ArrayList<Menu>();
	
	public MenuService(){
		myMenu.add(new Makanan("Rendang",10000));
		myMenu.add(new Makanan("Tempe",5000));
		myMenu.add(new Minuman("Es Teh",2500));
	}
	
	public List<Menu> getAll(){
		return myMenu;
	}
}
