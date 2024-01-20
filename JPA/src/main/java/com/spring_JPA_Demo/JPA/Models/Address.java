package com.spring_JPA_Demo.JPA.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int doorNo;
	private String city;
	private String town;
	Address(){}
	public Address(int doorNo, String city, String town) {
		super();
		this.doorNo = doorNo;
		this.city = city;
		this.town = town;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", city=" + city + ", town=" + town + "]";
	}
	
	
}
