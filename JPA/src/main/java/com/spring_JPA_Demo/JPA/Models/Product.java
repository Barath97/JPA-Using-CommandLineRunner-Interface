package com.spring_JPA_Demo.JPA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                 	//@Entity is used to connect this class to some RDBMS.
@Table(name="product_details")		
public class Product {
	
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.AUTO)  	//for generating id value automatically
	private int id;
	private String productName;
	private double price;
	private int quantity;
	
	public Product() {}
	
	public Product( String productName, double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	
}
