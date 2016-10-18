package com.jlopes.library.io;

import java.util.List;

import com.jlopes.library.MenuOptions;
import com.jlopes.library.Utility;
import com.jlopes.library.domain.Book;

public class Writer {

	public void wellComeMessage() {
		System.out.println("Wellcome  to your Biblioteca!\n");
	}

	public void showMenuOptions() {
		System.out.println("What do you like to do?\n");
		for (MenuOptions option : MenuOptions.values()) {
			if (!Utility.isDataEmpty(option.getDescription())) {
				System.out.println(option.toString() + "\n");
			}
		}
	}

	public void searchBookMessage() {
		System.out.println("Write the book's title you wish to search. \n"
				+ "To go back to menu, press '0': \n\n");
	}

	public void showListBooks(List<Book> listBooks) {
		System.out
				.println("See the list of choosen books. \n"
						+ "If you want to select some of these books, please press the correspondent number to them, when there is it. \n"
						+ "To go back to menu, press '0': \n\n");
		int arrow = 1;
		for (Book book : listBooks) {
			System.out
					.println("Book " + arrow + ":\n" + book.toString() + "\n");
			arrow++;
		}
	}

	public void successCheckBooksOutMessage() {
		System.out
				.println("Successful check out!\n" + "Have a nice reading!\n");
		thankMessage();
	}

	public void errorCheckBooksOutMessage() {
		System.out
				.println("Sorry, it was not possible to check out this book...\n"
						+ "Please, chose another.\n");
	}

	public void successCheckBooksInMessage() {
		System.out.println("Successful return.\n");
		thankMessage();
	}

	public void errorCheckBooksInMessage() {
		System.out
				.println("Sorry, it was not possible to return this book...\n");
	}

	public void leaveSystemMessage() {
		thankMessage();
		System.out.println("See you soon!.\n");
		System.exit(0);
	}

	public void invalidOptionMessage() {
		System.out.println("Invalid option...\n");
	}

	public void bookNotFoundMessage() {
		System.out.println("Book not found...\n"
				+ "Please, write the book's title correctly.\n");
	}

	public void thankMessage() {
		System.out.println("Thank you for utilizing our services!\n");
	}

}
