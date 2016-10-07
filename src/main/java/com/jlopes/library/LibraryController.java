package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;
import com.jlopes.library.io.Read;
import com.jlopes.library.io.Write;

public class LibraryController {
	private final LibraryManager library;

	public LibraryController(LibraryManager library) {
		this.library = library;
		Write.wellComeMessage();
	}

	public void decisionControl(MenuOptions option) {
		switch (option) {
		case DISPLAY_MENU_OPTIONS:
			menuOptions();
			break;
		case SEARCH_BOOK:
			Write.searchBookMessage();
			controlToSearchBook(Read.entry());
			break;
		case LIST_ALL_BOOKS:
			Write.showListBooks(library.getBooks());
			controlListBooks(Read.validNumericInput(Read
					.parseToValidNumber(Read.entry()), library.getBooks()
					.size()), library.getBooks());
			break;
		case LIST_AVAILABLE_BOOKS:
			Write.showListBooks(library.availableBooks());
			controlListBooks(Read.validNumericInput(Read
					.parseToValidNumber(Read.entry()), library.availableBooks()
					.size()), library.availableBooks());

			break;
		case RETURN_BOOK:
			Write.showListBooks(library.getCheckedBooksOut());
			controlBooksToReturn(Read.validNumericInput(Read
					.parseToValidNumber(Read.entry()), library
					.getCheckedBooksOut().size()), library.getCheckedBooksOut());
			break;
		case LEAVE_SYSTEM:
			Write.leaveSystemMessage();
			break;
		default:
			Write.invalidOptionMessage();
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
			Write.successCheckBooksInMessage();
		} else {
			Write.errorCheckBooksInMessage();
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
				Write.bookNotFoundMessage();
				menuOptions();
			} else {
				List<Book> listBooks = new ArrayList<Book>();
				listBooks.add(resultSearch);
				Write.showListBooks(listBooks);
				String strValue = Integer
						.toString(Read.validNumericInput(
								Read.parseToValidNumber(Read.entry()),
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
				Write.successCheckBooksOutMessage();
			} else {
				Write.errorCheckBooksOutMessage();
			}
		} else {
			Write.errorCheckBooksOutMessage();
		}
		menuOptions();
	}

	public void menuOptions() {
		Write.showMenuOptions();
		decisionControl(MenuOptions.option(Read.validNumericInput(
				Read.parseToValidNumber(Read.entry()),
				MenuOptions.values().length)));
	}
}
