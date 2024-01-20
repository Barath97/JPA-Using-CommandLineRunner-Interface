package com.spring_JPA_Demo.JPA.DAO;

import org.springframework.stereotype.Repository;

//import com.spring_JPA_Demo.JPA.Models.BookDetails;
import com.spring_JPA_Demo.JPA.Models.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Person savePerson(Person p) {
		em.persist(p);
		return p;
	}
	
	public Person getPerson(int id) {
		Person p =em.find(Person.class, id);
		return p;
	}
	
	public Person updateDetails(Person p) {
		em.merge(p);
		return p;
	}
	
	public void deletePerson(int id) {
		Person p =em.find(Person.class, id);
		em.remove(p);
	}
	
}
