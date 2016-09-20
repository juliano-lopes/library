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
				.println("Bem-vindo(a) à sua Biblioteca!\n\n"
						+ "O que gostaria de fazer?\n\n"
						+ "1. - Buscar por um livro;\n"
						+ "2. - Listar todos os livros;\n"
						+ "3. - Listar somente os livros disponíveis para retirada;\n"
						+ "4. - Listar os livros não disponíveis para conhecer o que as pessoas andam lendo no momento;\n"
						+ "5. - Realizar a devolução de um livro;\n"
						+ "6. - Sair do sistema...\n");
		entry = new Scanner(System.in);

		return entry.nextInt();
	}

	public int displayWithAllTheBooks() {

		System.out
				.println("Veja o que temos em nossa biblioteca para você!\n"
						+ "Caso queira realizar a retirada de alguma das obras exibidas, por favor digite o número correspondente a ela.\n"
						+ "Para voltar ao menu digite '0': \n\n");
		int arrow = 1;
		for (Books book : this.library.getBooks()) {
			System.out.println("LIVRO " + arrow + "\n" + "Título: "
					+ book.getTitle() + "\n" + "Autor: " + book.getAuthor()
					+ "\n" + "Gênero: " + book.getGenrer() + "\n"
					+ "Tipo de Literatura: " + book.getKindOfLiterature()
					+ "\n" + "Editora: " + book.getPublisher() + "\n"
					+ "====================\n\n");
			arrow++;
		}
		entry = new Scanner(System.in);

		return entry.nextInt();
	}

}
