package com.jlopes.library;

public class RentBooks extends Utility {

	private final Usuarios usuario;
	private final Books book;

	public Usuarios getUsuario() {
		return usuario;
	}

	public Books getBook() {
		return book;
	}

	public RentBooks(Usuarios usuario, Books book) {
		if ((isNull(usuario)) || (isNull(book))) {
			throw new RentBookDataShouldNotBeNullException();
		}
		this.usuario = usuario;
		this.book = book;
	}

}
