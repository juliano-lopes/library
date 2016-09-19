package com.jlopes.library;

import java.util.List;

public class LibraryManager {
	private List<Books> books;

	public LibraryManager(List<Books> books) {
		if(isNull(books)){
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.books = books;
	}

	public int quantityBooks() {
		return books.size();
	}

	public boolean addBook(Books book) {
		if (books.add(book)) {
			return true;
		} else {
			return false;
		}
	}

	public Books shearchedBook(String shearch) {
		for (Books book : books) {
			if (book.getTitle().equals(shearch)) {
				return book;
			}
		}
		return null;
	}

	public boolean removeBook(String shearch) {
		Books shearchedBook = shearchedBook(shearch);
		if (!isNull(shearchedBook)) {
			if (books.remove(shearchedBook)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	private boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else {
			return false;
		}
	}
}
