package com.spring_JPA_Demo.JPA.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(BookPrimaryKey.class)
public class BookDetails {
	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private String title;
	@Id
	private String language;
	private int price;
	
	public BookDetails(String title, String language, int price) {
		super();
		this.title = title;
		this.language = language;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDetails [title=" + title + ", language=" + language + ", price=" + price + "]";
	}
	
	
}
