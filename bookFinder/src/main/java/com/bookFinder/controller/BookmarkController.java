package com.bookFinder.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookFinder.model.Book;
import com.bookFinder.service.BookServiceImpl;
import com.bookFinder.service.BookmarkServiceImpl;
 
@RestController
public class BookmarkController {
 
	@Autowired
	private BookmarkServiceImpl bookmarkService;
	
	 
	@Autowired
	private BookServiceImpl bookService;
	

	@RequestMapping(value={"/bookmark/findAll"}, method = RequestMethod.GET)	
	public List<Book> saveBookmark(HttpServletRequest request) {	
		Principal principal = request.getUserPrincipal();	
		List<Book> bookmarkList = bookService.findById(principal);		
		return bookmarkList;
	} 
	
	@RequestMapping(value={"/bookmark/save"}, method = RequestMethod.POST)	
	public void boomarkSave(Book book,HttpServletRequest request) {	
		Principal principal = request.getUserPrincipal();	
		bookmarkService.save(book,principal);	
	} 
	
	@RequestMapping(value={"/bookmark/delete"}, method = RequestMethod.POST)	
	public void bookmarkDelete(Book bookmark, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		bookmarkService.delete(bookmark,principal);
	}
	
}
