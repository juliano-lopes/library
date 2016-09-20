package com.jlopes.library;

import java.util.Scanner;

public class LibraryDisplayControl {
	LibraryManager library;
	Scanner entry;

	public LibraryDisplayControl(LibraryManager library) {
		this.library = library;
	}

	public int menuOptions() {
		int option;
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
		option = entry.nextInt();
		return option;
	}
}
