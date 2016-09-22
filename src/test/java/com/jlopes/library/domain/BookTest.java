package com.jlopes.library.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.jlopes.library.domain.Book;
import com.jlopes.library.exception.BookDataShouldNotBeEmptyException;

public class BookTest {
@Test(expected=BookDataShouldNotBeEmptyException.class)
	public void souldReturnTitleAndAuthorShouldNotBeEmptyException() {
		new Book(0, "Se Houver Amanhã","Sidney Sheldon","Romance","Literatura Estrangeira","Record");
	}
@Test
public void souldReturnBookIsbn() {
	Book book = new Book(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
	long result = book.getIsbn();
	assertEquals(result, 111);
}

@Test	
public void souldReturnBookTitle() {
		Book book = new Book(123,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}
@Test
	public void souldReturnBookAuthor() {
		Book book = new Book(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getAuthor();
		assertThat(result, is("Sidney Sheldon"));
	}
	@Test
	public void souldReturnBookGenrer() {
		Book book = new Book(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getGenrer();
		assertThat(result, is("Romance"));
	}
	@Test
	public void souldReturnBookKindOfLiterature() {
		Book book = new Book(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getKindOfLiterature();
		assertThat(result, is("Literatura Estrangeira"));
	}
	@Test
	public void souldReturnBookPublisher() {
		Book book = new Book(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getPublisher();
		assertThat(result, is("Record"));
	}
	
}
