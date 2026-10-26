package com.ecommerce.ecommercewebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommercewebsite.Service.ProductService;
import com.ecommerce.ecommercewebsite.entity.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public List<Product> fetchAllProducts(){
		return service.FetchAllProducts();
	}
	@PostMapping("/save")
	public Product createProduct(@RequestBody Product product) {
	    return service.saveProduct(product);
	}
}
