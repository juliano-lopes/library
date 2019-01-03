package com.jlopes.library.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.BookDataShouldNotBeEmptyException;

public class BookTest {
	private Book book;

	@Before
	public void setUp() {
		book = new Book(111, "Se Houver Amanhã", "Sidney Sheldon", "Romance", "Literatura Estrangeira", "Record");
	}

	@Test(expected = BookDataShouldNotBeEmptyException.class)
	public void souldReturnTitleAndAuthorShouldNotBeEmptyException() {
		new Book(0, "Se Houver Amanhã", "Sidney Sheldon", "Romance", "Literatura Estrangeira", "Record");
	}

	@Test
	public void souldReturnBookIsbn() {
		long result = book.getIsbn();
		assertEquals(result, 111);
	}

	@Test
	public void souldReturnBookTitle() {
		String result = book.getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}

	@Test
	public void souldReturnBookAuthor() {
		String result = book.getAuthor();
		assertThat(result, is("Sidney Sheldon"));
	}

	@Test
	public void souldReturnBookGenrer() {
		String result = book.getGenrer();
		assertThat(result, is("Romance"));
	}

	@Test
	public void souldReturnBookKindOfLiterature() {
		String result = book.getKindOfLiterature();
		assertThat(result, is("Literatura Estrangeira"));
	}

	@Test
	public void souldReturnBookPublisher() {
		String result = book.getPublisher();
		assertThat(result, is("Record"));
	}

}
