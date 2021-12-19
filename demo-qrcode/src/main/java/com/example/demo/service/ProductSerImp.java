package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepo;

@Service("ProductSer")
public class ProductSerImp implements ProductSer{
	
	@Autowired
	public ProductRepo productRepo;
	
	@Override
	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}

}
