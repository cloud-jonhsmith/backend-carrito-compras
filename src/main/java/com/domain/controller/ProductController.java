package com.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.entity.Product;
import com.domain.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@GetMapping("/")
	public String redirectUrl() {
		return "redirect:/products";
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productService.listAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@RequestMapping(value = "{productid}")
	public ResponseEntity<Product> getProductById(@PathVariable("productid") int productid){
		Optional<Product> optionalProduct = productService.findById(productid);
		if(optionalProduct.isPresent()) {
			return ResponseEntity.ok(optionalProduct.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productService.addProduct(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Optional<Product> optionalProduct = productService.findById(product.getId());
		if(optionalProduct.isPresent()) {
			Product updateProduct = optionalProduct.get();
			updateProduct.setName(product.getName());
			updateProduct.setDescription(product.getDescription());
			updateProduct.setCodigo(product.getCodigo());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setStock(product.getStock());
			productService.updateProduct(updateProduct);
			return ResponseEntity.ok(updateProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "{productid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("productid") int productid){
		productService.removeProduct(productid);
		return ResponseEntity.ok(null);
	}

}
