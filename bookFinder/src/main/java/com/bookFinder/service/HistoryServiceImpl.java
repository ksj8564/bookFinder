package com.bookFinder.service;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookFinder.model.History;
import com.bookFinder.model.User;
import com.bookFinder.repo.HistoryRepository;
import com.bookFinder.repo.UserRepository;

@Service
@Transactional 
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryRepository historyRepository;
	
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public void save(History searchHistory, Principal principal) {	
		User user = userRepository.findByUsername(principal.getName());	
		searchHistory.setUserId(user.getId());
		searchHistory.setDateCreated(new Date());
		historyRepository.save(searchHistory);		
	}


	public List<History> findById(Principal principal) {
		User user = userRepository.findByUsername(principal.getName());		
		Pageable topTen = new PageRequest(0, 10);
		return historyRepository.findAllByUserId(user.getId(),topTen);
	}
	
}
