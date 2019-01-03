package com.jlopes.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jlopes.library.exception.BookDataShouldNotBeEmptyException;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long isbn;
	private String title;
	private String author;
	private String genrer;
	private String kindOfLiterature;
	private String publisher;

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenrer(String genrer) {
		this.genrer = genrer;
	}

	public void setKindOfLiterature(String kindOfLiterature) {
		this.kindOfLiterature = kindOfLiterature;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

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

	public Book() {

	}

	public Book(long isbn, String title, String author, String genrer, String kindOfLiterature, String publisher) {
		if (isDataEmpty(isbn, title, author, genrer, kindOfLiterature, publisher)) {
			throw new BookDataShouldNotBeEmptyException();
		}
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genrer = genrer;
		this.kindOfLiterature = kindOfLiterature;
		this.publisher = publisher;
	}

	public String toString() {
		return "Title: " + title + "\n" + "Author: " + author + "\n" + "Genrer: " + genrer + "\n"
				+ "Kind of literature: " + kindOfLiterature + "\n" + "Publisher: " + publisher + "\n";
	}

	private boolean isDataEmpty(long isbn, String... params) {
		for (String value : params) {
			if ((value.equals("")) || (isbn == 0)) {
				return true;
			}
		}
		return false;
	}
}
