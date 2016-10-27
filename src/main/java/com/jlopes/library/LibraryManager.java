package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.LibraryManagerDataShouldNotBeNullException;
import com.jlopes.library.service.BookService;

public class LibraryManager {
	private BookService bookService;
	private List<Book> books;
	private List<Book> checkedBooksOut;

	public List<Book> getBooks() {
		return books;
	}

	public List<Book> getCheckedBooksOut() {
		return checkedBooksOut;
	}

	public BookService getLibraryService() {
		return bookService;
	}

	public LibraryManager(BookService bookService) {
		if (bookService == null) {
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.bookService = bookService;
		this.books = new ArrayList<Book>(bookService.getBooks());
		this.checkedBooksOut = new ArrayList<Book>();
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

	public boolean checkingBookIn(Book checkBookOut) {
		if (checkedBooksOut.remove(checkBookOut)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkingBookOut(Book checkBookOut) {
		if (checkedBooksOut.add(checkBookOut)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Book> availableBooks() {
		List<Book> availableBooks = new ArrayList<Book>(books);
		availableBooks.removeAll(checkedBooksOut);
		return availableBooks;
	}
}
