package com.jlopes.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jlopes.library.LibraryManager;
import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.BookNotFoundException;

@RestController
public class BookController {
	private final LibraryManager library;

	@Autowired
	public BookController(LibraryManager library) {
		this.library = library;
	}

	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
	public Book getBook(@PathVariable long isbn) {
		Book book = library.getBookByIsbn(isbn);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
	public Book getByName(@PathVariable String name) {
		Book book = library.searchedBook(name);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getAll() {
		return library.getBooks();
	}

	@RequestMapping(value = "/books/search", method = RequestMethod.GET)
	public List<Book> getAvailable(
			@RequestParam("available") boolean isAvailable) {
		if (isAvailable) {

			return library.availableBooks();
		}
		return library.getCheckedBooksOut();

	}

	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long isbn) {
		if (library.deleteBook(isbn)) {
			return "Book deleted";
		} else {
			return "Book not deleted";
		}

	}

}
