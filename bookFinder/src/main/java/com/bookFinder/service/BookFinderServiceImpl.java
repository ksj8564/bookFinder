package com.bookFinder.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookFinder.model.User;
import com.bookFinder.repo.BookFinderRepository;

@Service
public class BookFinderServiceImpl implements BookFinderService{

	@Autowired
	private BookFinderRepository bookFinderRepository;
	
	
	@Override
	public List<User> findAll() {
		List<User> result = new ArrayList<User>();
		Iterable<User> Users = bookFinderRepository.findAll();
		Iterator<User> it = Users.iterator();
		while(it.hasNext()) {
			User User = it.next();			
			result.add(User);
		}
		return result;
	}


	public User save(User param) {
		return bookFinderRepository.save(param);
	}
 
	
}
