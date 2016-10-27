package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;
import com.jlopes.library.io.Reader;
import com.jlopes.library.io.Writer;

public class LibraryController {
	private final LibraryManager library;
	private final Writer writer;
	private final Reader reader;

	public LibraryController(LibraryManager library, Writer writer,
			Reader reader) {
		this.library = library;
		this.writer = writer;
		this.reader = reader;
		writer.wellComeMessage();
	}

	public void decisionControl(MenuOptions option) {
		switch (option) {
		case DISPLAY_MENU_OPTIONS:
			menuOptions();
			break;
		case SEARCH_BOOK:
			writer.searchBookMessage();
			controlToSearchBook(reader.entry());
			break;
		case LIST_ALL_BOOKS:
			writer.showListBooks(library.getBooks());
			controlListBooks(reader.validNumericInput(reader
					.parseToValidNumber(reader.entry()), library.getBooks()
					.size()), library.getBooks());
			break;
		case LIST_AVAILABLE_BOOKS:
			writer.showListBooks(library.availableBooks());
			controlListBooks(reader.validNumericInput(reader
					.parseToValidNumber(reader.entry()), library
					.availableBooks().size()), library.availableBooks());

			break;
		case RETURN_BOOK:
			writer.showListBooks(library.getCheckedBooksOut());
			controlBooksToReturn(reader.validNumericInput(reader
					.parseToValidNumber(reader.entry()), library
					.getCheckedBooksOut().size()), library.getCheckedBooksOut());
			break;
		case LEAVE_SYSTEM:
			writer.leaveSystemMessage();
			break;
		default:
			writer.invalidOptionMessage();
			menuOptions();
			break;
		}
	}

	private void controlBooksToReturn(int value, List<Book> books) {
		if (value == 0) {
			menuOptions();
		} else {
			controlCheckBooksIn(books.get(value - 1));
		}
	}

	private void controlCheckBooksIn(Book book) {
		if (library.checkingBookIn(book)) {
			writer.successCheckBooksInMessage();
		} else {
			writer.errorCheckBooksInMessage();
		}
		menuOptions();
	}

	private void controlListBooks(int value, List<Book> books) {
		if (value == 0) {
			menuOptions();
		} else {
			controlCheckBooksOut(books.get(value - 1));
		}
	}

	private void controlToSearchBook(String search) {
		if (!search.equals("0")) {
			Book resultSearch = library.searchedBook(search);
			if (resultSearch == null) {
				writer.bookNotFoundMessage();
				menuOptions();
			} else {
				List<Book> listBooks = new ArrayList<Book>();
				listBooks.add(resultSearch);
				writer.showListBooks(listBooks);
				int value = reader.validNumericInput(
						reader.parseToValidNumber(reader.entry()),
						listBooks.size());
				if (value == 0) {
					menuOptions();
				} else {
					controlCheckBooksOut(resultSearch);
				}
			}
		} else {
			menuOptions();
		}
	}

	private void controlCheckBooksOut(Book book) {
		if (library.availableBooks().contains(book)) {
			if (library.checkingBookOut(book)) {
				writer.successCheckBooksOutMessage();
			} else {
				writer.errorCheckBooksOutMessage();
			}
		} else {
			writer.errorCheckBooksOutMessage();
		}
		menuOptions();
	}

	public void menuOptions() {
		writer.showMenuOptions();
		decisionControl(MenuOptions.option(reader.validNumericInput(
				reader.parseToValidNumber(reader.entry()),
				MenuOptions.values().length)));
	}
}
