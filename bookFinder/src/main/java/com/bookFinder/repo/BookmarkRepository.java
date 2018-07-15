package com.bookFinder.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookFinder.model.Bookmark;
 

@Repository("bookmarkerRepository")
public interface BookmarkRepository extends JpaRepository<Bookmark, String> {

	Bookmark findByBarcodeAndUserId(String barcode, int userId);
 
	void deleteByBarcodeAndUserId(String barcode, int userId); 
 


}


