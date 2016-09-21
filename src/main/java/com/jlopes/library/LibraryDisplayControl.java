package com.jlopes.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class LibraryDisplayControl {
	LibraryManager library;
	Scanner entry;
	BufferedReader entryLine;

	public LibraryDisplayControl(LibraryManager library) {
		this.library = library;
	}

	public int menuOptions() {

		System.out.println("" + "O que gostaria de fazer?\n\n"
				+ "1. - Buscar por um livro;\n"
				+ "2. - Listar todos os livros;\n"
				+ "3. - Listar somente os livros dispon�veis para retirada;\n"
				+ "4. - Realizar a devolu��o de um livro;\n"
				+ "5. - Sair do sistema...\n");
		entry = new Scanner(System.in);

		return entry.nextInt();
	}

	public String displaySearchBook() {
		System.out.println("Digite o t�tulo do livro que deseja buscar: \n");
		entryLine = new BufferedReader(new InputStreamReader(System.in));
		String search = "";
		try {
			search = entryLine.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return search.toLowerCase();
	}

	public int displayWithListBooks(List<Books> listBooks) {

		System.out
				.println("Veja a lista de livros escolhida. \n"
						+ "Caso queira realizar a retirada de alguma das obras exibidas, por favor digite o n�mero correspondente � ela, quando houver. \n"
						+ "Para voltar ao menu digite '0': \n\n");
		int arrow = 1;
		for (Books book : listBooks) {
			System.out.println("LIVRO " + arrow + "\n" + "T�tulo: "
					+ book.getTitle() + "\n" + "Autor: " + book.getAuthor()
					+ "\n" + "G�nero: " + book.getGenrer() + "\n"
					+ "Tipo de Literatura: " + book.getKindOfLiterature()
					+ "\n" + "Editora: " + book.getPublisher() + "\n"
					+ "====================\n\n");
			arrow++;
		}
		entry = new Scanner(System.in);

		return entry.nextInt();
	}

	public int displayWithListBooksToReturn(List<CheckBooksOut> listBooks) {
		System.out
				.println("Veja aqui o (s) livro (s) que identificamos em seu nome.\n"
						+ "Caso queira realizar a devolu��o, digite o n�mero que corresponde ao livro.\n"
						+ "Para voltar ao menu digite '0':\n\n");
		int arrow = 1;
		for (CheckBooksOut book : listBooks) {
			System.out.println("LIVRO " + arrow + "\n" + "T�tulo: "
					+ book.getBook().getTitle() + "\n" + "Autor: "
					+ book.getBook().getAuthor() + "\n" + "G�nero: "
					+ book.getBook().getGenrer() + "\n"
					+ "Tipo de Literatura: "
					+ book.getBook().getKindOfLiterature() + "\n" + "Editora: "
					+ book.getBook().getPublisher() + "\n"
					+ "====================\n\n");
			arrow++;
		}
		entry = new Scanner(System.in);

		return entry.nextInt();

	}
}