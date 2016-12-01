package com.jlopes.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jlopes.library.LibraryManager;
import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

@RestController
public class BookController {
	private final LibraryManager library;

	public BookController() {
		library = new LibraryManager(new BookService());
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
