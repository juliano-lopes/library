package com.jlopes.library;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentBookTest {
	@Test
	public void shouldReturnUserNameThatRentedTheBook() {
		Users user = new Users("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		Books book = new Books(123, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		RentBooks rentBook = new RentBooks(user, book);
		String result = rentBook.getUser().getName();
		assertThat(result, is("Juliano Lopes"));
	}

	@Test
	public void shouldReturnBookTitleRented() {
		Users user = new Users("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		Books book = new Books(123, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		RentBooks rentBook = new RentBooks(user, book);
		String result = rentBook.getBook().getTitle();
		assertThat(result, is("As Aventuras de Sharpe1"));
	}

}
