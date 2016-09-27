package com.jlopes.library;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.service.BookService;

public class UtilityTest {
	@Test
	public void shouldReturnTrueIfObjectIsNull() {
		List<Book> book = null;
		assertTrue(Utility.isNull(book));
	}

	@Test
	public void shouldReturnTrueIfValuesAreEmpty() {
		String value1 = "";
		String value2 = "";
		String value3 = "";
		assertTrue(Utility.isDataEmpty(value1, value2, value3));
	}

	@Test
	public void shouldReturnTrueIfDigitsAreNumeric() {
		String digits = "1234";
		assertTrue(Utility.isNumber(digits));
	}

	@Test
	public void shouldReturnFalseIfObjectIsNotNull() {
		BookService bookService = new BookService();
		List<Book> book = bookService.getBooks();
		assertFalse(Utility.isNull(book));
	}

	@Test
	public void shouldReturnFalseIfValuesAreNotEmpty() {
		String value1 = "test1";
		String value2 = "test2";
		String value3 = "test3";
		assertFalse(Utility.isDataEmpty(value1, value2, value3));
	}

	@Test
	public void shouldReturnFalseIfDigitsAreNotNumeric() {
		String digits = "123e";
		assertFalse(Utility.isNumber(digits));
	}

}
