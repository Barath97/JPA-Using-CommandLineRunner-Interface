package com.spring_JPA_Demo.JPA.repForBookDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_JPA_Demo.JPA.Models.BookDetails;
import com.spring_JPA_Demo.JPA.Models.BookPrimaryKey;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface BookdetailsRepository extends JpaRepository<BookDetails, BookPrimaryKey>  {
	List<BookDetails> findFirst3ByOrderByPriceAsc();
	List<BookDetails> findBypriceGreaterThan(int value);
	
	@Query(value = "select * from book_details where price =(Select max(price) from book_details)",nativeQuery=true)
	List <BookDetails> findCostlineBook();
	
	@Query(value="select b from BookDetails b where b.title=:title and b.language=:lang")
	List<BookDetails> findByTitleAndLanguage(@Param("title") String title,@Param("lang") String language);
	
	@Query(value="select b from BookDetails b where b.price between ?1 and ?2")
	List<BookDetails> findByPriceBetween(int value1,int value2);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
