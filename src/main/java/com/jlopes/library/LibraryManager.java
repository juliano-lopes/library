package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager extends Utility {
	private List<Books> books;
	private List<CheckBooksOut> checkBooksOut;

	public List<CheckBooksOut> getCheckBooksOut() {
		return checkBooksOut;
	}

	public List<Books> getBooks() {
		return books;
	}

	public LibraryManager(List<Books> books) {
		if (isNull(books)) {
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.books = new ArrayList<Books>(books);
		this.checkBooksOut = new ArrayList<CheckBooksOut>();
	}

	public int quantityBooks() {
		return books.size();
	}

	public Books searchedBook(String search) {
		search = search.toLowerCase();
		for (Books book : books) {
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

	public List<Books> checkedBooksOut() {
		List<Books> checkedBooksOut = new ArrayList<Books>();
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

	public List<Books> availableBooks() {
		List<Books> availableBooks = new ArrayList<Books>(books);
		availableBooks.removeAll(checkedBooksOut());
		return availableBooks;
	}

}
