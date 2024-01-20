package com.spring_JPA_Demo.JPA.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity              
@Table(name="StudentDetails")
public class Student {
	
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dept;
	private int totalMarks;
	
	public Student() {}
	
	public Student(String name, String dept, int totalMarks) {
		super();
		this.name = name;
		this.dept = dept;
		this.totalMarks = totalMarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "Strudent [id=" + id + ", name=" + name + ", dept=" + dept + ", totalMarks=" + totalMarks + "]";
	}
	 
	
	
	
}
