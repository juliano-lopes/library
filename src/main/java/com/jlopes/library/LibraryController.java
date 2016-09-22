package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryController extends Utility {
	final LibraryDisplayControl displayControl;
	private final LibraryManager library;
	private final Users user;
	private int option;

	public void setOption(int option) {
		this.option = option;
	}

	public LibraryController(LibraryDisplayControl displayControl,
			LibraryManager library, Users user) {
		this.displayControl = displayControl;
		this.library = library;
		this.user = user;
	}

	public void decisionControl() {
		switch (option) {
		case 0:
			option = displayControl.displayWithMenuOptions();
			decisionControl();
			break;
		case 1:
			String search = displayControl.displaySearchBook();
			controlToSearchBook(search);
			break;
		case 2:
			controlListWithAllTheBooks();
			break;
		case 3:
			controlListWithAvailableBooks();
			break;
		case 4:
			controlBooksToReturn();
			break;
		case 5:
			displayControl.leaveSystem();
		}
	}

	private void controlBooksToReturn() {
		int value = displayControl.displayWithListBooksToReturn(library
				.checkedBooksOutByUser(user.getName()));
		String strValue = Integer.toString(value);
		if (isZero(strValue)) {
			option = value;
			decisionControl();
		} else {
			generalControlCheckBooksIn(value - 1);
		}
	}

	private void generalControlCheckBooksIn(int index) {
		CheckBooksOut checkBookOut = library.getCheckBooksOut().get(index);
		if (library.checkingBookIn(checkBookOut)) {
			displayControl.successCheckBooksIn();
		} else {
			displayControl.errorCheckBooksIn();
		}
		decisionControl();

	}

	private void controlListWithAvailableBooks() {
		int value = displayControl.displayWithListBooks(library
				.availableBooks());
		String strValue = Integer.toString(value);
		if (isZero(strValue)) {

			option = value;
			decisionControl();
		} else {
			controlAvailableCheckBooksOut(value);
		}

	}

	private void controlAvailableCheckBooksOut(int value) {
		Books book = library.availableBooks().get(value - 1);
		if (library.checkingBookOut(newCheckBooksOut(user, book))) {
			displayControl.successCheckBooksOut();
		} else {
			displayControl.errorCheckBooksOut();
		}
		decisionControl();

	}

	private void controlListWithAllTheBooks() {
		int value = displayControl.displayWithListBooks(library.getBooks());
		String strValue = Integer.toString(value);
		if (isZero(strValue)) {
			option = value;
			decisionControl();
		} else {
			generalControlCheckBooksOut(value - 1);
		}

	}

	private void controlToSearchBook(String search) {
		if (!isZero(search)) {
			Books resultSearch = library.searchedBook(search);
			if (isNull(resultSearch)) {
				System.out.println("Livro não encontrado...");
				decisionControl();
			} else {
				List<Books> listBooks = new ArrayList<Books>();
				listBooks.add(resultSearch);
				int value = displayControl.displayWithListBooks(listBooks);
				String strValue = Integer.toString(value);
				if (isZero(strValue)) {
					option = value;
					decisionControl();
				} else {
					generalControlCheckBooksOut(library.getBooks().indexOf(
							resultSearch));
				}

			}
		} else {
			option = Integer.parseInt(search);
			decisionControl();

		}
	}

	private void generalControlCheckBooksOut(int index) {
		Books book = library.getBooks().get(index);
		if (library.availableBooks().contains(book)) {
			if (library.checkingBookOut(newCheckBooksOut(user, book))) {
				displayControl.successCheckBooksOut();
			} else {
				displayControl.errorCheckBooksOut();
			}
		} else {
			displayControl.errorCheckBooksOut();
		}
		decisionControl();
	}

	private CheckBooksOut newCheckBooksOut(Users user, Books book) {
		return new CheckBooksOut(user, book);
	}
}
