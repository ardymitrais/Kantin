package com.mitrais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
	User findByUserNameAndUserPassword(String userName, String userPassword);
}
