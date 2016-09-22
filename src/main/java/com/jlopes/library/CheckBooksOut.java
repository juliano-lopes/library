package com.jlopes.library;

import com.jlopes.library.domain.Book;
import com.jlopes.library.domain.User;
import com.jlopes.library.exception.CheckBookOutDataShouldNotBeNullException;

public class CheckBooksOut extends Utility {

	private final User user;
	private final Book book;

	public User getUser() {
		return user;
	}

	public Book getBook() {
		return book;
	}

	public CheckBooksOut(User user, Book book) {
		if ((isNull(user)) || (isNull(book))) {
			throw new CheckBookOutDataShouldNotBeNullException();
		}
		this.user = user;
		this.book = book;
	}

}
