package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;

public class LibraryController {
	private final LibraryDisplayControl displayControl;
	private final LibraryManager library;

	public LibraryController(LibraryDisplayControl displayControl,
			LibraryManager library) {
		this.displayControl = displayControl;
		this.library = library;
	}

	public void decisionControl(MenuOptions option) {
		switch (option) {
		case DISPLAY_MENU_OPTIONS:
			menuOptions();
			break;
		case SEARCH_BOOK:
			String search = displayControl.displaySearchBook();
			controlToSearchBook(search);
			break;
		case LIST_ALL_BOOKS:
			controlListBooks(library.getBooks());
			break;
		case LIST_AVAILABLE_BOOKS:
			controlListBooks(library.availableBooks());
			break;
		case RETURN_BOOK:
			controlBooksToReturn(library.getCheckedBooksOut());
			break;
		case LEAVE_SYSTEM:
			displayControl.displayLeaveSystem();
			break;
		default:
			displayControl.displayWithInvalidOptionMessage();
			menuOptions();
			break;
		}
	}

	private void controlBooksToReturn(List<Book> books) {
		int value = displayControl.displayWithListBooks(books);
		String strValue = Integer.toString(value);
		if (Utility.isZero(strValue)) {
			menuOptions();
		} else {
			controlCheckBooksIn(books.get(value - 1));
		}
	}

	private void controlCheckBooksIn(Book book) {
		if (library.checkingBookIn(book)) {
			displayControl.displaySuccessCheckBooksIn();
		} else {
			displayControl.displayErrorCheckBooksIn();
		}
		menuOptions();
	}

	private void controlListBooks(List<Book> books) {
		int value = displayControl.displayWithListBooks(books);
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
				displayControl.displayBookNotFound();
				menuOptions();
			} else {
				List<Book> listBooks = new ArrayList<Book>();
				listBooks.add(resultSearch);
				int value = displayControl.displayWithListBooks(listBooks);
				String strValue = Integer.toString(value);
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
				displayControl.displaySuccessCheckBooksOut();
			} else {
				displayControl.displayErrorCheckBooksOut();
			}
		} else {
			displayControl.displayErrorCheckBooksOut();
		}
		menuOptions();
	}

	public void menuOptions() {
		decisionControl(MenuOptions.option(displayControl
				.displayWithMenuOptions()));
	}
}
