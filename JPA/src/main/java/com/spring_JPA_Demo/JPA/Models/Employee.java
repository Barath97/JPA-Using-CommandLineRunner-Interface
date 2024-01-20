package com.spring_JPA_Demo.JPA.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
@NamedQueries({
	@NamedQuery(name="filterEmpBasedOnName",query="Select e from Employee e where e.name>=:name"),
	
	//@NamedQuery(name="filterByAge",query="Select e from employee e where e.age>=:age"),
	
	@NamedQuery(name="findEmployeeByDept",query="select e from Employee e where e.department.id= :deptid")})

public class Employee {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="dept_id_sequence",sequenceName = "dept_id_sequence",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dept_id_sequence")
	private int id;
	private String name;
	private String email;
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;
	
	public Employee() {}
	
	public Employee(String name, String email,int age, Department department) {
		super();
		this.name = name;
		this.email = email;
		this.age=age;
		this.department = department;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", department="
				+ department + "]";
	}

	 
	
	
}
