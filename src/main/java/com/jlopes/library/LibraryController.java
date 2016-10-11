package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;
import com.jlopes.library.io.Reader;
import com.jlopes.library.io.Writer;

public class LibraryController {
	private final LibraryManager library;

	public LibraryController(LibraryManager library) {
		this.library = library;
		Writer.wellComeMessage();
	}

	public void decisionControl(MenuOptions option) {
		switch (option) {
		case DISPLAY_MENU_OPTIONS:
			menuOptions();
			break;
		case SEARCH_BOOK:
			Writer.searchBookMessage();
			controlToSearchBook(Reader.entry());
			break;
		case LIST_ALL_BOOKS:
			Writer.showListBooks(library.getBooks());
			controlListBooks(Reader.validNumericInput(Reader
					.parseToValidNumber(Reader.entry()), library.getBooks()
					.size()), library.getBooks());
			break;
		case LIST_AVAILABLE_BOOKS:
			Writer.showListBooks(library.availableBooks());
			controlListBooks(Reader.validNumericInput(Reader
					.parseToValidNumber(Reader.entry()), library.availableBooks()
					.size()), library.availableBooks());

			break;
		case RETURN_BOOK:
			Writer.showListBooks(library.getCheckedBooksOut());
			controlBooksToReturn(Reader.validNumericInput(Reader
					.parseToValidNumber(Reader.entry()), library
					.getCheckedBooksOut().size()), library.getCheckedBooksOut());
			break;
		case LEAVE_SYSTEM:
			Writer.leaveSystemMessage();
			break;
		default:
			Writer.invalidOptionMessage();
			menuOptions();
			break;
		}
	}

	private void controlBooksToReturn(int value, List<Book> books) {
		String strValue = Integer.toString(value);
		if (Utility.isZero(strValue)) {
			menuOptions();
		} else {
			controlCheckBooksIn(books.get(value - 1));
		}
	}

	private void controlCheckBooksIn(Book book) {
		if (library.checkingBookIn(book)) {
			Writer.successCheckBooksInMessage();
		} else {
			Writer.errorCheckBooksInMessage();
		}
		menuOptions();
	}

	private void controlListBooks(int value, List<Book> books) {
		String strValue = Integer.toString(value);
		if (Utility.isZero(strValue)) {
			menuOptions();
		} else {
			controlCheckBooksOut(books.get(value - 1));
		}
	}

	private void controlToSearchBook(String search) {
		if (!Utility.isZero(search)) {
			Book resultSearch = library.searchedBook(search);
			if (Utility.isNull(resultSearch)) {
				Writer.bookNotFoundMessage();
				menuOptions();
			} else {
				List<Book> listBooks = new ArrayList<Book>();
				listBooks.add(resultSearch);
				Writer.showListBooks(listBooks);
				String strValue = Integer
						.toString(Reader.validNumericInput(
								Reader.parseToValidNumber(Reader.entry()),
								listBooks.size()));
				if (Utility.isZero(strValue)) {
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
				Writer.successCheckBooksOutMessage();
			} else {
				Writer.errorCheckBooksOutMessage();
			}
		} else {
			Writer.errorCheckBooksOutMessage();
		}
		menuOptions();
	}

	public void menuOptions() {
		Writer.showMenuOptions();
		decisionControl(MenuOptions.option(Reader.validNumericInput(
				Reader.parseToValidNumber(Reader.entry()),
				MenuOptions.values().length)));
	}
}
