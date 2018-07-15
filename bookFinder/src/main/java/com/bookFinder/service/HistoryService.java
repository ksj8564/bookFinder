package com.bookFinder.service;

import java.security.Principal;

import com.bookFinder.model.History;

public interface HistoryService {

	void save(History searchHistory, Principal principal);

}
