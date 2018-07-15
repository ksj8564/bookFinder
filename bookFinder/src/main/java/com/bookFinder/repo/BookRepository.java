package com.bookFinder.repo;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookFinder.model.Book;
 

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, String> {
	

	Book findByBarcode(String barcode);
	
	@Query(value="SELECT new com.bookFinder.model.Book(c2.book_id, c2.title, c2.contents, c2.url, c2.isbn, c2.datetime, c2.authors, c2.publisher, c2.translators, c2.price, c2.sale_price, c2.sale_yn, c2.category, c2.thumbnail, c2.barcode, c2.ebook_barcode, c2.status)"
			+ " FROM Bookmark c1, Book c2 where c1.barcode = c2.barcode AND c1.userId = :userId")	
	List<Book> findByUserId(@Param("userId")int userId); 
}


