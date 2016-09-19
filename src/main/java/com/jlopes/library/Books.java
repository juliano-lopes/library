package com.jlopes.library;

public class Books {
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

	public Books(long isbn, String title, String author, String genrer,
			String kindOfLiterature, String publisher) {
		if (isBookDataEmpty(isbn, title, author, genrer, kindOfLiterature,
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

	private boolean isBookDataEmpty(long isbn, String title, String author,
			String genrer, String kindOfLiterature, String publisher) {
		if ((isbn == 0) || (title.equals("")) || (author.equals(""))
				|| (genrer.equals("")) || (kindOfLiterature.equals(""))
				|| (publisher.equals(""))) {
			return true;
		} else {
			return false;
		}
	}
}