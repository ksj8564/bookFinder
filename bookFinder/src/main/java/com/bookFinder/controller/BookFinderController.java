package com.bookFinder.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookFinder.model.Student;
import com.bookFinder.service.BookFinderService;
 
@RestController
public class BookFinderController {
 
	@Autowired
	private BookFinderService bookFinderService;

	@RequestMapping("/save")
	public Student save(Student param) {				
		return bookFinderService.save(param);
	} 
	
	@RequestMapping("/findAll")	
	public List<Student> findAll() {	
		System.out.println("AAAAAAAAAAAA");
		List<Student> result = bookFinderService.findAll();
		return result;
	} 
}
