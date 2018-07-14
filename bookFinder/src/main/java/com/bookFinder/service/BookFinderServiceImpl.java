package com.bookFinder.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookFinder.model.Bookmark;
import com.bookFinder.repo.BookmarkRepository;

@Service
@Transactional 
public class BookFinderServiceImpl implements BookFinderService{

	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Override
	public void saveBookmark(Bookmark bookmark) {
		if(findBookmarkByIsbnAndUserId(bookmark.getIsbn(), bookmark.getUserId()) == null) {
			bookmarkRepository.save(bookmark); 
		}		
	}
	
	@Override
	public void deleteBookmarkByIsbnAndUserId(String isbn, int userId) {
		bookmarkRepository.deleteBookmarkByIsbnAndUserId(isbn, userId);
	}

	@Override
	public Bookmark findBookmarkByIsbnAndUserId(String isbn, int userId) {
		return bookmarkRepository.findBookmarkByIsbnAndUserId(isbn, userId);
	}

	
}
