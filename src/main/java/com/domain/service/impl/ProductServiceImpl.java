package com.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.domain.entity.Product;
import com.domain.repository.ProductJpaRepository;
import com.domain.service.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productJpaRepository")
	private ProductJpaRepository productJpaRepository;

	@Override
	public List<Product> listAllProducts() {
		return productJpaRepository.findAll();
	}
	
	@Override
	public Optional<Product> findById(int id) {
		return productJpaRepository.findById(id);
	}

	@Override
	public Product addProduct(Product product) {
		return productJpaRepository.save(product);
	}

	@Override
	public int removeProduct(int id) {
		productJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Product updateProduct(Product product) {
		return productJpaRepository.save(product);
	}

}
