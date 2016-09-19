package com.jlopes.library;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentBookTest {
	@Test
	public void shouldReturnUsuarioNameThatRentedTheBook() {
		Usuarios usuario = new Usuarios("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		Books book = new Books(123, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		RentBooks rentBook = new RentBooks(usuario, book);
		String result = rentBook.getUsuario().getName();
		assertThat(result, is("Juliano Lopes"));
	}

	@Test
	public void shouldReturnBookTitleRented() {
		Usuarios usuario = new Usuarios("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		Books book = new Books(123, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		RentBooks rentBook = new RentBooks(usuario, book);
		String result = rentBook.getBook().getTitle();
		assertThat(result, is("As Aventuras de Sharpe1"));
	}

}
