package com.domain.model;

public class ProductModel {
	
	private String name;
	
	private String description;
	
	private String codigo;
	
	private Float price;
	
	private int stock;

	public ProductModel() {
	}

	public ProductModel(String name, String description, String codigo, Float price, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.codigo = codigo;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
