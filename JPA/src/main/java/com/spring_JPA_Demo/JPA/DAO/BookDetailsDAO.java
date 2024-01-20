package com.spring_JPA_Demo.JPA.DAO;

import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.BookDetails;
import com.spring_JPA_Demo.JPA.Models.BookPrimaryKey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository					 
@Transactional	

public class BookDetailsDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void saveBook(BookDetails bd) {
		em.persist(bd);
	}
	
	public BookDetails getBookDetails(String title,String language) {
		BookDetails bd = em.find(BookDetails.class, new BookPrimaryKey(title,language));
		return bd;
	}
	
	public BookDetails updateDetails(BookDetails bd) {
		em.merge(bd);
		return bd;
	}
	
	public void deleteDetails(BookDetails bd) {
		 bd = em.find(BookDetails.class,new BookPrimaryKey(bd.getTitle(),bd.getLanguage()));
		em.remove(bd);
	}
}
