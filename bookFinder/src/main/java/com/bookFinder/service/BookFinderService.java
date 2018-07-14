package com.bookFinder.service;

import com.bookFinder.model.Bookmark;

public interface BookFinderService {

	public void saveBookmark(Bookmark bookmark);

	public void deleteBookmarkByIsbnAndUserId(String isbn, int userId);

	Bookmark findBookmarkByIsbnAndUserId(String isbn, int userId);
}
