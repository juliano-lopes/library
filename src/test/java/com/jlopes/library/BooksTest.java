package com.jlopes.library;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksTest {

	@Test
	public void souldReturnBookName() {
		Books book = new Books("Se Houver Amanh�", "Sidney Sheldon");
		String result = book.getTitle();
		assertThat(result, is("Se Houver Amanh�"));
	}

	@Test
	public void souldReturnBookAuthor() {
		Books book = new Books("Se Houver Amanh�", "Sidney Sheldon");
		String result = book.getAuthor();
		assertThat(result, is("Sidney Sheldon"));
	}

}
