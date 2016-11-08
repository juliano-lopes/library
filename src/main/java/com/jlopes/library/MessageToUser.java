package com.jlopes.library;

import java.util.List;

import com.jlopes.library.domain.Book;

public class MessageToUser {
	public String wellComeMessage() {
		return "Wellcome  to your Biblioteca!";
	}

	public String showMenuOptions() {
		String message = "What do you like to do?\n";
		for (MenuOptions option : MenuOptions.values()) {
			if (!option.getDescription().equals("")) {
				message += option.toString() + "\n";
			}
		}
		return message;
	}

	public String searchBookMessage() {
		return "Write the book's title you wish to search. \n"
				+ "To go back to menu, press '0': \n\n";
	}

	public String showListBooks(List<Book> listBooks) {

		String message = "See the list of choosen books. \n"
				+ "If you want to select some of these books, please press the correspondent number to them, when there is it. \n"
				+ "To go back to menu, press '0': \n\n";
		int arrow = 1;
		for (Book book : listBooks) {

			message += "Book " + arrow + ":\n" + book.toString() + "\n";
			arrow++;
		}
		return message;
	}

	public String successCheckBooksOutMessage() {
		return "Successful check out!\n" + "Have a nice reading!\n";
	}

	public String errorCheckBooksOutMessage() {

		return "Sorry, it was not possible to check out this book...\n"
				+ "Please, chose another.\n";
	}

	public String successCheckBooksInMessage() {
		return "Successful return.\n";
	}

	public String errorCheckBooksInMessage() {

		return "Sorry, it was not possible to return this book...\n";
	}

	public String leaveSystemMessage() {
		return "See you soon!.\n";
	}

	public String invalidOptionMessage() {
		return "Invalid option...\n";
	}

	public String bookNotFoundMessage() {
		return "Book not found...\n"
				+ "Please, write the book's title correctly.\n";
	}

	public String thankMessage() {
		return "Thank you for utilizing our services!\n";
	}

}
