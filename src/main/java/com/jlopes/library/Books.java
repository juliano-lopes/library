package com.jlopes.library;

public class Books {
	private final String title;
	private final String author;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Books(String title, String author) {
		this.title = title;
		this.author = author;
	}
}