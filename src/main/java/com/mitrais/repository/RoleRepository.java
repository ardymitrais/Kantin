package com.mitrais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
