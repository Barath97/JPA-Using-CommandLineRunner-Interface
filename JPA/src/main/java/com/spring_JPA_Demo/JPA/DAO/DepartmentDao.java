package com.spring_JPA_Demo.JPA.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.Department;
import com.spring_JPA_Demo.JPA.Models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DepartmentDao {
	@PersistenceContext
	private EntityManager em;
	
	public Department saveDepartment(Department d) {
		em.persist(d);
		return d;
	}
	
	public Department getDepartment(int deptid) {
		Department d = em.find(Department.class, deptid);
		return d;
	}
	
	public void updateDepartment(Department d) {
		em.merge(d);
	}
	
	public void deleteDepartment(int did) {
		Department d = em.find(Department.class, did);
		List <Employee> employee=d.getEmployees();
		for(Employee emp:employee) {
			emp.setDepartment(null);
			em.merge(emp);
		}
		em.remove(d);
	}
	
	public void updateEmployee(Employee emp) {
		em.merge(emp);
	}
	
	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}
	
	public List<Employee> getEmployeeByName(String name){
		Query query=em.createNamedQuery("filterEmpBasedOnName");
		query.setParameter("name",name);
		return query.getResultList();
	}
	
	public List<Employee> getEmployeeByage(int age){
		Query query=em.createNamedQuery("filterByAge");
		query.setParameter("age",age);
		return query.getResultList();
	}
	
	public List<Employee> getEmployeeByDepartment(int depid){
		Query query=em.createNamedQuery("findEmployeeByDept");
		query.setParameter("Department",depid);
		return query.getResultList();
	}
	
	
	
	
	
	
}
