package com.jlopes.library;

public class CheckBooksOut extends Utility {

	private final Users user;
	private final Books book;

	public Users getUser() {
		return user;
	}

	public Books getBook() {
		return book;
	}

	public CheckBooksOut(Users user, Books book) {
		if ((isNull(user)) || (isNull(book))) {
			throw new CheckBookOutDataShouldNotBeNullException();
		}
		this.user = user;
		this.book = book;
	}

}
