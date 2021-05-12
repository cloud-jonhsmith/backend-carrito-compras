package com.domain.service;

import java.util.List;
import java.util.Optional;

import com.domain.entity.Product;

public interface ProductService {
	
	public abstract List<Product> listAllProducts();
	public abstract Optional<Product> findById(int id);
	public abstract Product addProduct(Product product);
	public abstract int removeProduct(int id);
	public abstract Product updateProduct(Product product);

}
