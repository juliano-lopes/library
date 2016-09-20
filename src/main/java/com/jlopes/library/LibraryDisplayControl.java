package com.jlopes.library;

import java.util.Scanner;

public class LibraryDisplayControl {
	LibraryManager library;
	Scanner entry;

	public LibraryDisplayControl(LibraryManager library) {
		this.library = library;
	}

	public int menuOptions() {

		System.out
				.println("Bem-vindo(a) � sua Biblioteca!\n\n"
						+ "O que gostaria de fazer?\n\n"
						+ "1. - Buscar por um livro;\n"
						+ "2. - Listar todos os livros;\n"
						+ "3. - Listar somente os livros dispon�veis para retirada;\n"
						+ "4. - Listar os livros n�o dispon�veis para conhecer o que as pessoas andam lendo no momento;\n"
						+ "5. - Realizar a devolu��o de um livro;\n"
						+ "6. - Sair do sistema...\n");
		entry = new Scanner(System.in);

		return entry.nextInt();
	}

	public int displayWithAllTheBooks() {

		System.out
				.println("Veja o que temos em nossa biblioteca para voc�!\n"
						+ "Caso queira realizar a retirada de alguma das obras exibidas, por favor digite o n�mero correspondente a ela.\n"
						+ "Para voltar ao menu digite '0': \n\n");
		int arrow = 1;
		for (Books book : this.library.getBooks()) {
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

}
