package com.bookFinder.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookFinder.model.Student;
import com.bookFinder.repo.BookFinderRepository;

@Service
public class BookFinderServiceImpl implements BookFinderService{

	@Autowired
	private BookFinderRepository bookFinderRepository;
	
	
	@Override
	public List<Student> findAll() {
		List<Student> result = new ArrayList<Student>();
		Iterable<Student> students = bookFinderRepository.findAll();
		Iterator<Student> it = students.iterator();
		while(it.hasNext()) {
			Student student = it.next();			
			result.add(student);
		}
		return result;
	}


	public Student save(Student param) {
		return bookFinderRepository.save(param);
	}
 
	
}
