package com.jlopes.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.jlopes.library.LibraryManager;
import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.BookNotFoundException;
import com.jlopes.library.service.BookService;

@RestController
public class BookController {
	private final LibraryManager library;

	public BookController() {
		library = new LibraryManager(new BookService());
	}

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public Book getBook(@PathVariable long isbn) {
		Book book = library.getBookByIsbn(isbn);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@ExceptionHandler(BookNotFoundException.class)
	public String bookNotFound() {
		return "The book you are looking for was not found...";
	}

	@RequestMapping(value = "/book/search/{name}", method = RequestMethod.GET)
	public Book getSearchedBook(@PathVariable String name) {
		Book book = library.searchedBook(name);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@RequestMapping(value = "/book/all", method = RequestMethod.GET)
	public List<Book> getAll() {
		return library.getBooks();
	}

	@RequestMapping(value = "/book/available", method = RequestMethod.GET)
	public List<Book> getAvailable() {
		return library.availableBooks();
	}

}
