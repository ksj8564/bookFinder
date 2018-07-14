package com.bookFinder.repo;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookFinder.model.Bookmark;
 

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, String> {

	Bookmark findBookmarkByIsbnAndUserId(String isbn, int userId);

	void deleteBookmarkByIsbnAndUserId(String isbn, int userId);

}


