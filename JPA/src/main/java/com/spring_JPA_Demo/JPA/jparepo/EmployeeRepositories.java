package com.spring_JPA_Demo.JPA.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.Employee;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepositories extends JpaRepository<Employee,Id> {
	List<Employee> findFirst3ByOrderByNameAsc();
	
}
