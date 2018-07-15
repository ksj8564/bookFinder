package com.bookFinder.service;

import java.security.Principal;
import java.util.List;

import com.bookFinder.model.Book;
import com.bookFinder.model.Bookmark;

public interface BookService {

	Bookmark findByBarcodeAndUserId(String barcode, int userId);

	void saveBookmark(Book book, Principal principal);

	List<Book> findById(Principal principal);

}
