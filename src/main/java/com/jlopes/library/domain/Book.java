package com.jlopes.library.domain;

import com.jlopes.library.Utility;
import com.jlopes.library.exception.BookDataShouldNotBeEmptyException;

public class Book {
	private final long isbn;
	private final String title;
	private final String author;
	private final String genrer;
	private final String kindOfLiterature;
	private final String publisher;

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenrer() {
		return genrer;
	}

	public String getKindOfLiterature() {
		return kindOfLiterature;
	}

	public String getPublisher() {
		return publisher;
	}

	public Book(long isbn, String title, String author, String genrer,
			String kindOfLiterature, String publisher) {
		if (isDataEmpty(isbn, title, author, genrer, kindOfLiterature,
				publisher)) {
			throw new BookDataShouldNotBeEmptyException();
		}
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genrer = genrer;
		this.kindOfLiterature = kindOfLiterature;
		this.publisher = publisher;
	}

	private boolean isDataEmpty(long isbn, String... params) {
		if (isbn == 0) {
			return true;
		}
		if (Utility.isDataEmpty(params)) {
			return true;
		} else {
			return false;
		}
	}

}