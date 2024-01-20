package com.spring_JPA_Demo.JPA.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository					//In every DAO Should have this @Repository (Sub type of component annotation.
@Transactional				//To manage database transaction commit and rollback
public class ProductDAOImpl {
	
	@PersistenceContext
	private EntityManager em;		//EntityManager will manages all our entity.And it performs all database operation.
	
	//Create
	public int saveProduct(Product product) {	//insert(persist) product details into the table
		em.persist(product);   //insert query 
		return product.getId();
	}
	
	//Read
	public Product getProduct(int id) {
		Product product = em.find(Product.class, id);
		return product;
	}
	
	//update
	public Product updateQuantity(int id,int updatedQuantity) {
		Product product = em.find(Product.class, id);
		product.setQuantity(updatedQuantity);
		em.merge(product);
		return product;
	}
	
	//delete
	public void deleteProduct(int id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
	}
	
	//select * from Product
	public List<Product> getAllProduct(){
		Query query = em.createQuery("from Product");
		List<Product> products = query.getResultList();
		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
