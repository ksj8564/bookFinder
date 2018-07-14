package com.bookFinder.controller;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookFinder.model.Bookmark;
import com.bookFinder.model.User;
import com.bookFinder.service.BookFinderServiceImpl;
import com.bookFinder.service.UserServiceImpl;
 
@RestController
public class BookFinderApiController {
 
	@Autowired
	private BookFinderServiceImpl bookFinderService;
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/bookFinder/saveBookmark")
	public void saveBookmark(Bookmark bookmark, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();		
		User user = userService.findUserByUsername(principal.getName());	
		bookmark.setUserId(user.getUserId());
		System.out.println("AAAAAAAA : "+bookmark);
		bookFinderService.saveBookmark(bookmark);
	} 
	
	@RequestMapping("/bookFinder/deleteBookmark")
	public void deleteBookmark(Bookmark bookmark, HttpServletRequest request) {	
		Principal principal = request.getUserPrincipal();
		User user = userService.findUserByUsername(principal.getName());		
		bookFinderService.deleteBookmarkByIsbnAndUserId(bookmark.getIsbn(), user.getUserId());
	}
	
	
	/*
	@RequestMapping("/findAll")	
	public List<Student> findAll() {	
		System.out.println("AAAAAAAAAAAA");
		List<Student> result = bookFinderService.findAll();
		return result;
	} */
}
