package com.jdc.jpa.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.jpa.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
