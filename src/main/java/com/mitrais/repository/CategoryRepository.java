package com.mitrais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
