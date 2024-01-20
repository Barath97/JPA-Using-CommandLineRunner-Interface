package com.spring_JPA_Demo.JPA.Models;

public class BookPrimaryKey {
	private String title;
	private String language;
	
	
	public BookPrimaryKey(String title, String language) {
		super();
		this.title = title;
		this.language = language;
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


	public BookPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "BookPrimaryKey [title=" + title + ", language=" + language + "]";
	}
	
	
	
}
