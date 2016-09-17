package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
	public List<Books> getBooks() {
		Books book1 = new Books(1, "Se Houver Amanhã", "Sidney Sheldon",
				"Romance", "Literatura Estrangeira", "Record");
		Books book2 = new Books(2, "As Aventuras de Sharpe1",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Books book3 = new Books(3, "As Aventuras de Sharpe2",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Books book4 = new Books(4, "As Aventuras de Sharpe3",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");
		Books book5 = new Books(5, "As Aventuras de Sharpe4",
				"Bernard Cornwell", "Fixão Histórica",
				"Literatura Estrangeira", "Record");

		List<Books> books = new ArrayList<Books>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);

		return books;
	}

}
