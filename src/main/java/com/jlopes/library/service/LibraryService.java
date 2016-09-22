package com.jlopes.library.service;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;

public class LibraryService {
	public List<Book> getBooks() {
		Book book1 = new Book(1, "Se Houver Amanhã", "Sidney Sheldon",
				"Romance", "Literatura Estrangeira", "Record");
		Book book2 = new Book(2, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Book book3 = new Book(3, "As Aventuras de Sharpe2",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Book book4 = new Book(4, "As Aventuras de Sharpe3",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Book book5 = new Book(5, "As Aventuras de Sharpe4",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);

		return books;
	}

}
