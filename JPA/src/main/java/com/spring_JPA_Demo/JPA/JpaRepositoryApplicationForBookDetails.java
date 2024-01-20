package com.spring_JPA_Demo.JPA;

import java.util.Optional;
import java.util.Scanner;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.spring_JPA_Demo.JPA.Models.BookDetails;
import com.spring_JPA_Demo.JPA.Models.BookPrimaryKey;
import com.spring_JPA_Demo.JPA.repForBookDetails.BookdetailsRepository;
@SpringBootApplication
public class JpaRepositoryApplicationForBookDetails implements CommandLineRunner {
	@Autowired
	BookdetailsRepository bookDetailsRepo;
	public static void main(String[] args) {
			SpringApplication.run(JpaRepositoryApplicationForBookDetails.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1.Find \n2.UpadatePrice \n3.Insert Book Details\n4.Top 3 Book by ASC \n"
				+ "5.Find By Title and Language \n6.Find Range Between From to To range\n 7.View the Book details Page by Page\n8.View the Book details page by Page DESC\n");
		int choice=in.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Find by id");
			Optional<BookDetails> bd=bookDetailsRepo.findById(new BookPrimaryKey("Java Tamil","Tamil"));
			if(bd.isPresent()) {
				BookDetails book=bd.get();
				System.out.println(book);
			}
			else {
				System.err.println("Not Found");
			}
		break;
		
		case 2:
			System.out.println("Enter the title and Language of the book to be updated \n");
			System.out.println("Enter the Title");
			in.nextLine();
			String title=in.nextLine();
			System.out.println("Enter the Language");
			String language=in.nextLine();
			
			Optional<BookDetails> bd1=bookDetailsRepo.findById(new BookPrimaryKey(title,language));
			if(bd1.isPresent()) {
				BookDetails book=bd1.get();
				System.out.println("Enter the new Price \n");
				int price = in.nextInt();
				book.setPrice(price);
				bookDetailsRepo.save(book);
			}
			else {
				System.out.println("Not Found");
			}
		break;	
		
		case 3:
			System.out.println("Ente the Book title");
			in.nextLine();
			String titletoInsert=in.nextLine();
			System.out.println("Enter the Book Language");
			String languagetoinsert=in.nextLine();
			System.out.println("Enter the Price");
			int price = in.nextInt();
			bookDetailsRepo.save(new BookDetails(titletoInsert,languagetoinsert,price));
		break;
			
		case 4:
			System.out.println("Top 3 Books order by price ascending");
			List<BookDetails> book=bookDetailsRepo.findFirst3ByOrderByPriceAsc();
			for(BookDetails b:book) {
				System.out.println(b);
			}
		break;
		
		case 5:
			System.out.println("Find title and language");
			System.out.println("Enter the title");
			in.nextLine();
			String titleToGet=in.nextLine();
			System.out.println("Enter the language");
			String languageToGet=in.nextLine();
			List<BookDetails> bookToFindTitleAndLanguage=bookDetailsRepo.findByTitleAndLanguage(titleToGet, languageToGet);
			System.out.println(bookToFindTitleAndLanguage);
			break;
			
		case 6:
			System.out.println("Find the Price between Range");
			System.out.println("Enter the From Range");
			int fromRange=in.nextInt();
			System.out.println("Enter the To Range");
			int toRange=in.nextInt();
			List<BookDetails> BookDetailsBetweenRange = bookDetailsRepo.findByPriceBetween(fromRange, toRange);
			System.out.println(BookDetailsBetweenRange);
			break;
			
		case 7:
			Pageable pageable = PageRequest.of(0, 5);
			Page<BookDetails> bookPages= bookDetailsRepo.findAll(pageable);
			bookPages.forEach(System.out::println);
			System.out.println("Total number of pages " + bookPages.getTotalPages());
			for(int i=1;i<bookPages.getTotalPages();i++) {
				System.out.println("----------".repeat(50));
				pageable=PageRequest.of(i, 5);
				bookPages=bookDetailsRepo.findAll(pageable);
				bookPages.forEach(System.out::println);
			}
		break;
		
		case 8:
			Pageable pageableSort = PageRequest.of(0, 5,Sort.by(Direction.DESC, "price"));
			Page<BookDetails> bookPagesSort= bookDetailsRepo.findAll(pageableSort);
			bookPagesSort.forEach(System.out::println);
			System.out.println("Total number of pages " + bookPagesSort.getTotalPages());
			for(int i=1;i<bookPagesSort.getTotalPages();i++) {
				System.out.println("----------".repeat(50));
				pageableSort=PageRequest.of(i, 5,Sort.by(Direction.DESC, "price"));
				bookPagesSort=bookDetailsRepo.findAll(pageableSort);
				bookPagesSort.forEach(System.out::println);
			}
		break;
		}
		
	}

}
