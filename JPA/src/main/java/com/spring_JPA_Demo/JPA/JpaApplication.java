package com.spring_JPA_Demo.JPA;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring_JPA_Demo.JPA.DAO.BookDetailsDAO;
import com.spring_JPA_Demo.JPA.DAO.PersonDAO;
import com.spring_JPA_Demo.JPA.DAO.ProductDAOImpl;
import com.spring_JPA_Demo.JPA.DAO.StudentDAO;
import com.spring_JPA_Demo.JPA.Models.Address;
import com.spring_JPA_Demo.JPA.Models.BookDetails;
import com.spring_JPA_Demo.JPA.Models.Person;
import com.spring_JPA_Demo.JPA.Models.Product;
import com.spring_JPA_Demo.JPA.Models.Student;

//@SpringBootApplication

public class JpaApplication implements CommandLineRunner {
	@Autowired
	//ProductDAOImpl productDao;
	//StudentDAO studentdao;
	//BookDetailsDAO bookdao;
	PersonDAO persondao;
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	public Person savePerson(Person p) {
		p=persondao.savePerson(p);
		return p;
	}
	
	public void updatePerson(Person p) {
		persondao.updateDetails(p);
	}
	
	public Person getPerson(int id) {
		return persondao.getPerson(id);
	}

	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		int id=productDao.saveProduct(new Product("Realme Pro Max 5",150.50,50));
//		System.out.println("ID generated is " + id);
		
//		Product product = productDao.getProduct(1);
//		System.out.println(product);
		
//		Product product = productDao.updateQuantity(1, 50);
//		System.out.println(product);
		
//		productDao.deleteProduct(1);
		
//		List<Product> product = productDao.getAllProduct();
//		
//		for(Product P: product) {
//			System.out.println(P);
//		}
		
//		 int id= studentdao.saveStudent(new Student("Barath","Mechanical",484));
//		System.out.println("ID generated is " + id);
		
//		BookDetails bd = new BookDetails("Java Book","English",20);
//		BookDetails bd1= new BookDetails("Java Book","tamil",45);
//		
//		bookdao.saveBook(bd);
//		bookdao.saveBook(bd1);
		
//		BookDetails bd3=bookdao.getBookDetails("Java Book","English");
//		System.out.println(bd3);
//		bd3.setPrice(400);
//		bookdao.updateDetails(bd3);

//		bookdao.deleteDetails(bd3);
		
//		Person p=new Person("Simth","Hack","smithhack@gmail.com",new Address(50,"Chennai","TN"));
//		p = persondao.savePerson(p);
//		System.out.println(p);
		
//		System.out.println(persondao.getPerson(1));
		
//		Person p = persondao.getPerson(1);
//		System.out.println(p.getFirstname());
		
//		Person p =persondao.getPerson(1);
//		Address address = p.getAddress();
//		address.setCity("Bangalore");
//		p.setAddress(address);
//		persondao.updateDetails(p);
		
		JpaApplication jpa=context.getBean(JpaApplication.class);
		Scanner in =new Scanner(System.in);
		System.out.println("Enter the Choice ");
		int choice = in.nextInt();
		switch(choice) {
		case 1: 
			System.out.println("Enter the First Name");
			in.nextLine();
			String fn=in.nextLine();
			System.out.println("Enter the Last Name");
			String ln=in.nextLine();
			System.out.println("Enter the Email");
			String email = in.nextLine();
			System.out.println("Enter the Door No");
			int dn=in.nextInt();
			System.out.println("Enter the City");
			in.nextLine();
			String city=in.nextLine();
			System.out.println("Enter the Town");
			String town = in.nextLine();
			
			Person p = new Person(fn,ln,email,new Address(dn,city,town));
			jpa.savePerson(p);
			break;
			
		case 2:
			System.out.println("Enter the Id to get Person Details");
			int id=in.nextInt();
			Person p1 =jpa.getPerson(id);
			if(p1==null) {
				System.out.println("Entered person does'nt exists");
			}
			else
				System.out.println(p1);
			break;
		
		case 3:
			System.out.println("Enter the Id To update");
			int idTOUpdate=in.nextInt();
			Person person = persondao.getPerson(idTOUpdate);
			Address address = person.getAddress();
			address.setCity("Pune");
			person.setAddress(address);
			persondao.updateDetails(person);
			break;
		case 4:
			System.out.println("Enter the id to be deleted");
			int deleteId=in.nextInt();
			persondao.deletePerson(deleteId);
		}
	}
	


}
