package com.jlopes.library.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

public class BookServiceTest {

	@Test
	public void shouldReturnListOfBooks() {
		BookService bookService = new BookService();
		List<Book> books = bookService.getBooks();
		assertTrue(books.size() > 0);
	}
}