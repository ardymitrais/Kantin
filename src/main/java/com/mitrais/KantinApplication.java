package com.mitrais;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mitrais.entities.Roles;
import com.mitrais.entities.User;
import com.mitrais.repository.UserRepository;

//import com.mitrais.config.MyConfiguration;

@SpringBootApplication
public class KantinApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(KantinApplication.class, args);
//		MyConfiguration mcfg = appContext.getBean(MyConfiguration.class);
		
//		System.out.println(mcfg.getName());
	}

}

