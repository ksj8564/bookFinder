package com.bookFinder.controller;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookFinder.model.History;
import com.bookFinder.service.HistoryServiceImpl;
 
@RestController
public class HistoryController {
	
	@Autowired
	private HistoryServiceImpl searchHistoryService;
	
	@RequestMapping(value={"/history/findAll"}, method = RequestMethod.GET)	
	public List<History> findAll(HttpServletRequest request) {	
		Principal principal = request.getUserPrincipal();	
		List<History> historyList = searchHistoryService.findById(principal);		
		return historyList;
	}
}
