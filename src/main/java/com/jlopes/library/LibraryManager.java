package com.jlopes.library;

import java.util.List;

public class LibraryManager {
	private List<Books> books;

	public LibraryManager(List<Books> books) {
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
}
