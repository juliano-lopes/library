package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.LibraryManagerDataShouldNotBeNullException;
import com.jlopes.library.service.BookService;

@Component
public class LibraryManager {
	private BookService bookService;
	private List<Book> books;
	private List<Book> unavailableBooks;

	public List<Book> getBooks() {
		return books;
	}

	public List<Book> getUnavailableBooks() {
		return unavailableBooks;
	}

	public BookService getLibraryService() {
		return bookService;
	}

	@Autowired
	public LibraryManager(BookService bookService) {
		if (bookService == null) {
			throw new LibraryManagerDataShouldNotBeNullException();
		}
		this.bookService = bookService;
		this.books = new ArrayList<Book>(bookService.getBooks());
		this.unavailableBooks = new ArrayList<Book>();
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

	public Book getBookByIsbn(long isbn) {
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				return book;
			}
		}
		return null;
	}

	public boolean returningBook(Book book) {
		if (unavailableBooks.contains(book)) {
			return (unavailableBooks.remove(book));
		}
		return false;
	}

	public boolean takingBook(Book book) {
		return (unavailableBooks.add(book));
	}

	public List<Book> availableBooks() {
		List<Book> availableBooks = new ArrayList<Book>(books);
		availableBooks.removeAll(unavailableBooks);
		return availableBooks;
	}

	public boolean deleteBook(long isbn) {
		return (books.remove(getBookByIsbn(isbn)));
	}

}
