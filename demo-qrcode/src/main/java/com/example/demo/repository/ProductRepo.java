package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository("ProductRepo")
public interface ProductRepo extends CrudRepository<Product, String>{

}
