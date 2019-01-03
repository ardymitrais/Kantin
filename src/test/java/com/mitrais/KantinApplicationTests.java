package com.mitrais;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitrais.entities.User;
import com.mitrais.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KantinApplicationTests {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Test
	public void contextLoads() {
	}
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserId(2);
		user.setUserName("Ardy");
		user.setUserPassword("12345");
		
		userRepository.save(user);
	}
	
	@Test
	public void testReadUser() {
		Optional<User> myUser = userRepository.findById(1);
		
		System.out.println(encoder.encode("12345") );
		
		assertEquals("Ardy", myUser.get().getUserName());
	}
}

