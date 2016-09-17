package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BooksTest {
@Test(expected=BookDataShouldNotBeEmptyException.class)
	public void souldReturnTitleAndAuthorShouldNotBeEmptyException() {
		new Books(0, "Se Houver Amanhã","Sidney Sheldon","Romance","Literatura Estrangeira","Record");
	}
@Test
public void souldReturnBookIsbn() {
	Books book = new Books(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
	long result = book.getIsbn();
	assertEquals(result, 111);
}

@Test	
public void souldReturnBookTitle() {
		Books book = new Books(123,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getTitle();
		assertThat(result, is("Se Houver Amanhã"));
	}
@Test
	public void souldReturnBookAuthor() {
		Books book = new Books(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getAuthor();
		assertThat(result, is("Sidney Sheldon"));
	}
	@Test
	public void souldReturnBookGenrer() {
		Books book = new Books(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getGenrer();
		assertThat(result, is("Romance"));
	}
	@Test
	public void souldReturnBookKindOfLiterature() {
		Books book = new Books(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getKindOfLiterature();
		assertThat(result, is("Literatura Estrangeira"));
	}
	@Test
	public void souldReturnBookPublisher() {
		Books book = new Books(111,"Se Houver Amanhã", "Sidney Sheldon","Romance","Literatura Estrangeira","Record");
		String result = book.getPublisher();
		assertThat(result, is("Record"));
	}
	
}
