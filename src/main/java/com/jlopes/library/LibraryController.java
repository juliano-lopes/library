package com.jlopes.library;

import java.util.ArrayList;
import java.util.List;

import com.jlopes.library.domain.Book;

public class LibraryController {
	final LibraryDisplayControl displayControl;
	private final LibraryManager library;
	private int option;

	public void setOption(int option) {
		this.option = option;
	}

	public LibraryController(LibraryDisplayControl displayControl,
			LibraryManager library) {
		this.displayControl = displayControl;
		this.library = library;
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

			controlListBooks(library.getBooks());
			break;
		case 3:
			controlListBooks(library.availableBooks());
			break;
		case 4:

			controlBooksToReturn(library.getCheckedBooksOut());
			break;
		case 5:
			displayControl.leaveSystem();
		}
	}

	private void controlBooksToReturn(List<Book> list) {
		int value = displayControl.displayWithListBooks(list);
		String strValue = Integer.toString(value);

		if (Utility.isZero(strValue)) {
			option = value;
			decisionControl();
		} else {
			controlCheckBooksIn(list.get(value - 1));
		}
	}

	private void controlCheckBooksIn(Book book) {
		if (library.checkingBookIn(book)) {
			displayControl.successCheckBooksIn();
		} else {
			displayControl.errorCheckBooksIn();
		}
		decisionControl();

	}

	private void controlListBooks(List<Book> books) {
		int value = displayControl.displayWithListBooks(books);
		String strValue = Integer.toString(value);
		if (Utility.isZero(strValue)) {

			option = value;
			decisionControl();
		} else {
			controlCheckBooksOut(books.get(value - 1));
		}

	}

	private void controlToSearchBook(String search) {
		if (!Utility.isZero(search)) {
			Book resultSearch = library.searchedBook(search);
			if (Utility.isNull(resultSearch)) {
				System.out.println("Livro n�o encontrado...");
				decisionControl();
			} else {
				List<Book> listBooks = new ArrayList<Book>();
				listBooks.add(resultSearch);
				int value = displayControl.displayWithListBooks(listBooks);
				String strValue = Integer.toString(value);
				if (Utility.isZero(strValue)) {
					option = value;
					decisionControl();
				} else {
					controlCheckBooksOut(resultSearch);
				}

			}
		} else {
			option = Integer.parseInt(search);
			decisionControl();

		}
	}

	private void controlCheckBooksOut(Book book) {
		if (library.availableBooks().contains(book)) {
			if (library.checkingBookOut(book)) {
				displayControl.successCheckBooksOut();
			} else {
				displayControl.errorCheckBooksOut();
			}
		} else {
			displayControl.errorCheckBooksOut();
		}
		decisionControl();
	}

}
