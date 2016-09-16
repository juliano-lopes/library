package com.jlopes.library;

public class Books {
	private final String title;
	private final String author;
	private final String genrer;
	private String kindOfLiterature;
	private String publisher;

	public void setKindOfLiterature(String kindOfLiterature) {
		this.kindOfLiterature = kindOfLiterature;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public Books(String title, String author, String genrer,
			String kindOfLiterature, String publisher) {
		if (isTitleOrAuthorEmpty(title, author)) {
			throw new TitleAndAuthorShouldNotBeEmptyException();
		}
		this.title = title;
		this.author = author;
		this.genrer = genrer;
		this.kindOfLiterature = kindOfLiterature;
		this.publisher = publisher;
	}

	private boolean isTitleOrAuthorEmpty(String title, String author) {
		if ((title == "") || (author == "")) {
			return true;
		} else {
			return false;
		}
	}
}