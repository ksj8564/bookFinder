package com.bookFinder.service;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookFinder.model.Book;
import com.bookFinder.model.Bookmark;
import com.bookFinder.model.User;
import com.bookFinder.repo.BookRepository;
import com.bookFinder.repo.BookmarkRepository;
import com.bookFinder.repo.UserRepository;

@Service
@Transactional 
public class BookmarkServiceImpl implements BookmarkService{

	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;


	
	@Override
	public void delete(Book book, Principal principal) {
		User user = userRepository.findByUsername(principal.getName());	
		bookmarkRepository.deleteByBarcodeAndUserId(book.getBarcode(), user.getId());	
	}

	@Override
	public void save(Book book,Principal principal) {
		Bookmark bookmark = new Bookmark(); 			
		User user = userRepository.findByUsername(principal.getName());	
		bookmark.setUserId(user.getId());
		bookmark.setBarcode(book.getBarcode());
		if(bookmarkRepository.findByBarcodeAndUserId(bookmark.getBarcode(), bookmark.getUserId()) == null) {
			bookmarkRepository.save(bookmark);		
			if(null == bookRepository.findByBarcode(bookmark.getBarcode())) {
				bookRepository.save(book);			
			}
		}
	}
	
}
