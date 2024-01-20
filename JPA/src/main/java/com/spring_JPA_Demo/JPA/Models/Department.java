package com.spring_JPA_Demo.JPA.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="dept_id_sequence",sequenceName = "dept_id_sequence",allocationSize = 1,initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dept_id_sequence")
	private int id;
	private String deptname;
	private String location;
	@OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Employee> employees;
	
	public Department() {}
	
	public Department(String deptname, String location, List<Employee> employees) {
		super();
		this.deptname = deptname;
		this.location = location;
		this.employees = employees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptname=" + deptname + ", location=" + location + ", employees=" + employees
				+ "]";
	}
	
	
	
}
