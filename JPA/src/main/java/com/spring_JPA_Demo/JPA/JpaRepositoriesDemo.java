package com.spring_JPA_Demo.JPA;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring_JPA_Demo.JPA.Models.Address;
import com.spring_JPA_Demo.JPA.Models.Person;
import com.spring_JPA_Demo.JPA.jparepo.PersonRepositories;
//import com.spring_Jpa.Demo.repositories.PersonJpaRepositories;
//@SpringBootApplication
public class JpaRepositoriesDemo implements CommandLineRunner {
	
	@Autowired
	PersonRepositories PersonJpa;
	public static void main(String[] args) {
		SpringApplication.run(JpaRepositoriesDemo.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enter your choice 1.FindAll 2.Insert 3.Find by id 4.Delete By id");
		Scanner in = new Scanner(System.in);
		int choice=in.nextInt();
		switch(choice) {
		case 1:
			List<Person> person = PersonJpa.findAll();
			for(Person p:person) {
				System.out.println(p);
			}
			break;
		
		case 2:
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
			PersonJpa.save(p);
			System.out.println("Person Inserted successfully");
			break;
		case 3:
			System.out.println("Enter the id to find");
			int id=in.nextInt();
			Optional<Person> personById=PersonJpa.findById(id);
			if(personById.isPresent()) {
				System.out.println(personById);
			}
			else
				System.out.println("Person does not exists");
			break;
		case 4:
			System.out.println("Enter the id to delete");
			int idDelete=in.nextInt();
			PersonJpa.deleteById(idDelete);
			System.out.println("Person is deleted Succesfully");
			break;
		case 5:
			System.out.println("Enter firstname");
			in.next();
			String fn1=in.nextLine();
			PersonJpa.findByFirstname(fn1).forEach(System.out::println);
			break;
		case 6:
			System.out.println("Enter person id to updated");
			int id1=in.nextInt();
			in.nextLine();
			Optional<Person> p1=PersonJpa.findById(id1);
			if(p1.isPresent()) {
				Person personToUpdate= p1.get();
				System.out.println("choose specific field to update");
				System.out.println("1.firstname 2.lastname 3.email");
				int choicetoUpdate=in.nextInt();
				in.nextLine();
				switch(choicetoUpdate) {
				case 1:
					System.out.println("Enter the first name");
					String firstname=in.nextLine();			
					personToUpdate.setFirstname(firstname);
					PersonJpa.save(personToUpdate);
					break;
				}
			}
			break;
			
		case 7:
			System.out.println("Person sorted");
			PersonJpa.findAllByOrderByFirstnameAsc().forEach(System.out::println);
			break;
			
		case 8:
			System.out.println("Person by City");
			List<Person> person1=PersonJpa.findByAddressCityIgnoreCase("Chennai");
			for(Person p2:person1) {
				System.out.println(p2);
			}
			break;
			
		case 9: 
			System.out.println("Person by email");
			System.out.println("Enter the Email");
			String email1=in.nextLine();
			PersonJpa.findByEmail(email1).forEach(System.out::println);
			break;
			
		}
	}

}
