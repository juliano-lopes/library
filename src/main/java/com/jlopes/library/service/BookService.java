package com.jlopes.library.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jlopes.library.domain.Book;

@Component
public class BookService {
	public Book bookNotExists() {
		return new Book(404, "Not Exists", "Not Exists", "Not Exists",
				"Not Exists", "Not Exists");
	}

	public List<Book> getBooks() {
		List<Book> books = Arrays.asList(
				new Book(1, "Se Houver Amanhã", "Sidney Sheldon", "Romance",
						"Literatura Estrangeira", "Record"), new Book(2,
						"As Aventuras de Sharpe1", "Bernard Cornwell",
						"Fixão Histórica", "Literatura Estrangeira", "Record"),
				new Book(3, "As Aventuras de Sharpe2", "Bernard Cornwell",
						"Fixão Histórica", "Literatura Estrangeira", "Record"),
				new Book(4, "As Aventuras de Sharpe3", "Bernard Cornwell",
						"Fixão Histórica", "Literatura Estrangeira", "Record"),
				new Book(5, "As Aventuras de Sharpe4", "Bernard Cornwell",
						"Fixão Histórica", "Literatura Estrangeira", "Record"));
		return books;
	}

	public Book newBook(long isbn, String title, String author, String genrer,
			String kindOfLiterature, String publisher) {
		return new Book(isbn, title, author, genrer, kindOfLiterature,
				publisher);
	}

}
