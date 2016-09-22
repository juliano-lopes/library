package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.LibraryManagerDataShouldNotBeNullException;

public class LibraryManager extends Utility {
	private List<Book> books;
	private List<CheckBooksOut> checkBooksOut;

	public List<CheckBooksOut> getCheckBooksOut() {
		return checkBooksOut;
	}

	public List<Book> getBooks() {
		return books;
	}

	public LibraryManager(List<Book> books) {
		if (isNull(books)) {
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.books = new ArrayList<Book>(books);
		this.checkBooksOut = new ArrayList<CheckBooksOut>();
	}

	public int quantityBooks() {
		return books.size();
	}

	public Book searchedBook(String search) {
		search = search.toLowerCase();
		for (Book book : books) {
			if (book.getTitle().toLowerCase().equals(search)) {
				return book;
			}
		}
		return null;
	}

	public boolean checkingBookIn(CheckBooksOut checkBookOut) {

		if (checkBooksOut.remove(checkBookOut)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkingBookOut(CheckBooksOut checkBookOut) {
		if (checkBooksOut.add(checkBookOut)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Book> checkedBooksOut() {
		List<Book> checkedBooksOut = new ArrayList<Book>();
		if (!checkBooksOut.isEmpty()) {
			for (CheckBooksOut checkBookOut : checkBooksOut) {
				checkedBooksOut.add(checkBookOut.getBook());
			}
			return checkedBooksOut;
		} else {
			return checkedBooksOut;
		}
	}

	public List<CheckBooksOut> checkedBooksOutByUser(String userName) {
		userName = userName.toLowerCase();
		List<CheckBooksOut> checkedBooksOut = new ArrayList<CheckBooksOut>();
		if (!checkBooksOut.isEmpty()) {
			for (CheckBooksOut checkBookOut : checkBooksOut) {
				if (checkBookOut.getUser().getName().toLowerCase()
						.equals(userName)) {
					checkedBooksOut.add(checkBookOut);
				}
			}
			return checkedBooksOut;
		} else {
			return checkedBooksOut;
		}

	}

	public List<Book> availableBooks() {
		List<Book> availableBooks = new ArrayList<Book>(books);
		availableBooks.removeAll(checkedBooksOut());
		return availableBooks;
	}

}
