package com.jlopes.library;

public class RentBooks extends Utility {

	private final Users user;
	private final Books book;

	public Users getUser() {
		return user;
	}

	public Books getBook() {
		return book;
	}

	public RentBooks(Users user, Books book) {
		if ((isNull(user)) || (isNull(book))) {
			throw new RentBookDataShouldNotBeNullException();
		}
		this.user = user;
		this.book = book;
	}

}
