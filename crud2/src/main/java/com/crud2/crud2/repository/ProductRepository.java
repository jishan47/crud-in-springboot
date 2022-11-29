package com.crud2.crud2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud2.crud2.entity.Product;

public interface ProductRepository extends JpaRepository <Product,Integer>{

    Product findByName(String name);
    
}
