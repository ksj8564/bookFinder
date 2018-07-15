package com.bookFinder.service;

import java.security.Principal;
import java.util.List;

import com.bookFinder.model.Book;
import com.bookFinder.model.Bookmark;

public interface BookmarkService {

	void save(Book book, Principal principal);

	void delete(Book book, Principal principal);

}
