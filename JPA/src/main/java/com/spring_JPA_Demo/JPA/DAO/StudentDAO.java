package com.spring_JPA_Demo.JPA.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.spring_JPA_Demo.JPA.Models.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository					 
@Transactional				 
public class StudentDAO {
	
	@PersistenceContext
	private EntityManager em;		     
	
	//Create
	public int saveStudent(Student student) {	 
		em.persist(student);     
		return student.getId();
	}
	
	//Read
	public Student getStudent(int id) {
		Student student = em.find(Student.class, id);
		return student;
	}
	
	//update
	public Student updateTotalMarks(int id,int updateTotalMarks) {
		Student student = em.find(Student.class, id);
		student.setTotalMarks(updateTotalMarks);
		em.merge(student);
		return student;
	}
	
	//delete
	public void deleteStudent(int id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
	
	//select * from Product
	public List<Student> getAllStudent(){
		Query query = em.createQuery("from Student");
		List<Student> student = query.getResultList();
		return student;
	}
	
}