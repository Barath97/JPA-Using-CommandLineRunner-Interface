package com.spring_JPA_Demo.JPA.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.Person;

import jakarta.transaction.Transactional;
@Transactional
@Repository
public interface PersonRepositories extends JpaRepository<Person, Integer>{
	List<Person> findByFirstname(String firstname);
	List<Person> findAllByOrderByFirstnameAsc();
	List<Person> findByEmail(String email);
	List<Person> findByAddressCityIgnoreCase(String city);
}
