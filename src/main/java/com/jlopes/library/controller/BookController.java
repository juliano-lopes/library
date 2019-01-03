package com.jlopes.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.BookNotFoundException;
import com.jlopes.library.repository.BookRepository;

@RestController
public class BookController {
	private final BookRepository bRepo;

	@Autowired
	public BookController(BookRepository bRepo) {
		this.bRepo = bRepo;
	}

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public Book getBook(@PathVariable("isbn") long isbn) {
		Book book = bRepo.findByIsbn(isbn);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@RequestMapping(value = "/book/title/{title}", method = RequestMethod.GET)
	public Book getByTitle(@PathVariable("title") String title) {
		Book book = bRepo.findByTitle(title);
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	@RequestMapping(value = "/book/all", method = RequestMethod.GET)
	public List<Book> getAll() {
		return (List<Book>) bRepo.findAll();
	}

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.DELETE)
	public String delete(@PathVariable long isbn) {
		try {
			bRepo.delete(bRepo.findByIsbn(isbn));
			return "Book deleted";
		} catch (Exception e) {
			return "Book not deleted";
		}

	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public boolean newBook(Book book) {
		try {
			bRepo.save(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
