package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager extends Utility {
	private List<Books> books;
	private List<RentBooks> rentBooks;

	public LibraryManager(List<Books> books) {
		if (isNull(books)) {
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.books = books;
		this.rentBooks = new ArrayList<RentBooks>();
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

	public Books searchedBook(String search) {
		for (Books book : books) {
			if (book.getTitle().equals(search)) {
				return book;
			}
		}
		return null;
	}

	public boolean removeBook(String search) {
		Books searchedBook = searchedBook(search);
		if (!isNull(searchedBook)) {
			if (books.remove(searchedBook)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean rentBook(RentBooks rentBook) {
		if (rentBooks.add(rentBook)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Books> leasedBooks() {
		List<Books> leasedBooks = new ArrayList<Books>();
		if (!rentBooks.isEmpty()) {
			for (RentBooks rentBook : rentBooks) {
				leasedBooks.add(rentBook.getBook());
			}
			return leasedBooks;
		} else {
			return null;
		}
	}

}
