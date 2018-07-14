package com.bookFinder.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bookFinder.service.BookFinderServiceImpl;
 
@RestController
public class BookFinderApiController {
 
	@Autowired
	private BookFinderServiceImpl bookFinderService;

	/*@RequestMapping("/save")
	public Student save(Student param) {				
		return bookFinderService.save(param);
	} 
	
	
	
	@RequestMapping("/findAll")	
	public List<Student> findAll() {	
		System.out.println("AAAAAAAAAAAA");
		List<Student> result = bookFinderService.findAll();
		return result;
	} */
}
