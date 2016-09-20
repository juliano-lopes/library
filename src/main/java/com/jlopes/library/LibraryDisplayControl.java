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
				.println("Bem-vindo(a) à sua Biblioteca!\n\n"
						+ "O que gostaria de fazer?\n\n"
						+ "1. - Buscar por um livro;\n"
						+ "2. - Listar todos os livros;\n"
						+ "3. - Listar somente os livros disponíveis para retirada;\n"
						+ "4. - Listar os livros não disponíveis para conhecer o que as pessoas andam lendo no momento;\n"
						+ "5. - Realizar a devolução de um livro;\n"
						+ "6. - Sair do sistema...\n");
		entry = new Scanner(System.in);
		option = entry.nextInt();
		return option;
	}
}
