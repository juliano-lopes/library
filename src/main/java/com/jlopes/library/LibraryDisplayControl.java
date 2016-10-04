package com.jlopes.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.jlopes.library.domain.Book;

public class LibraryDisplayControl {
	Scanner entry;
	BufferedReader entryLine;

	public LibraryDisplayControl() {
		displayWellCome();
	}

	public void displayWellCome() {
		System.out.println("Wellcome  to your Biblioteca!\n");
	}

	public MenuOptions displayWithMenuOptions() {
		System.out.println("" + "What do you like to do?\n");
		for (MenuOptions option : MenuOptions.values()) {
			if (!Utility.isDataEmpty(option.getDescription())) {
				System.out.println(option.getValue() + ". "
						+ option.getDescription());
			}
		}
		return MenuOptions.option(displayWithValidNumericInput());
	}

	private int displayWithValidNumericInput() {
		entry = new Scanner(System.in);
		String option = entry.nextLine();
		if (Utility.isDataEmpty(option)) {
			displayWithInvalidOptionMessage();
			return 0;
		}
		if (Utility.isNumber(option)) {
			return Integer.parseInt(option);
		} else {
			displayWithInvalidOptionMessage();
			return 0;
		}
	}

	private int displayWithValidNumericInput(List<Book> books) {
		int option = displayWithValidNumericInput();
		if (option > books.size()) {
			displayWithInvalidOptionMessage();
			return 0;
		} else {
			return option;
		}
	}

	public String displaySearchBook() {
		System.out.println("Write the book's title you wish to search. \n"
				+ "To go back to menu, press '0': \n\n");
		entryLine = new BufferedReader(new InputStreamReader(System.in));
		String search = "";
		try {
			search = entryLine.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return search.toLowerCase();
	}

	public int displayWithListBooks(List<Book> listBooks) {
		System.out
				.println("See the list of choosen books. \n"
						+ "If you want to select some of these books, please press the correspondent number to them, when there is it. \n"
						+ "To go back to menu, press '0': \n\n");
		int arrow = 1;
		for (Book book : listBooks) {
			System.out.println("Book " + arrow + "\n" + "Title: "
					+ book.getTitle() + "\n" + "Author: " + book.getAuthor()
					+ "\n" + "Genrer: " + book.getGenrer() + "\n"
					+ "Kind of literature: " + book.getKindOfLiterature()
					+ "\n" + "Publisher: " + book.getPublisher() + "\n"
					+ "====================\n\n");
			arrow++;
		}
		return displayWithValidNumericInput(listBooks);
	}

	public void displaySuccessCheckBooksOut() {
		System.out
				.println("Successful check out!\n" + "Have a nice reading!\n");
		displayThankMessage();
	}

	public void displayErrorCheckBooksOut() {
		System.out
				.println("Sorry, it was not possible to check out this book...\n"
						+ "Please, chose another.\n");
	}

	public void displaySuccessCheckBooksIn() {
		System.out.println("Successful return.\n");
		displayThankMessage();
	}

	public void displayErrorCheckBooksIn() {
		System.out
				.println("Sorry, it was not possible to return this book...\n");
	}

	public void displayLeaveSystem() {
		displayThankMessage();
		System.out.println("See you soon!.\n");
		System.exit(0);
	}

	public void displayWithInvalidOptionMessage() {
		System.out.println("Invalid option...\n");
	}

	public void displayBookNotFound() {
		System.out.println("Book not found...\n"
				+ "Please, write the book's title correctly.\n");
	}

	public void displayThankMessage() {
		System.out.println("Thank you for utilizing our services!\n");
	}

}
