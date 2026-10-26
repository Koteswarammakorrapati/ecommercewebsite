package com.ecommerce.ecommercewebsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommercewebsite.entity.Product;
import com.ecommerce.ecommercewebsite.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	//fetch all the products
	public List<Product> FetchAllProducts(){
		return repository.findAll();
	}
	//save
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
}
