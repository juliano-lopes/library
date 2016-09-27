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

	public void displayWellCome() {
		System.out.println("Bem-vindo(a) à sua Biblioteca!\n");
	}

	public int displayWithMenuOptions() {
		System.out.println("" + "O que gostaria de fazer?\n\n"
				+ "1. - Buscar por um livro;\n"
				+ "2. - Listar todos os livros;\n"
				+ "3. - Listar somente os livros disponíveis para retirada;\n"
				+ "4. - Realizar a devolução de um livro;\n"
				+ "5. - Sair do sistema...\n");
		return displayWithValidNumericInput();
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
		System.out.println("Digite o título do livro que deseja buscar. \n"
				+ "Para voltar ao menu digite '0': \n\n");
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
				.println("Veja a lista de livros escolhida. \n"
						+ "Caso queira selecionar alguma das obras exibidas, por favor digite o número correspondente à ela, quando houver. \n"
						+ "Para voltar ao menu digite '0': \n\n");
		int arrow = 1;
		for (Book book : listBooks) {
			System.out.println("LIVRO " + arrow + "\n" + "Título: "
					+ book.getTitle() + "\n" + "Autor: " + book.getAuthor()
					+ "\n" + "Gênero: " + book.getGenrer() + "\n"
					+ "Tipo de Literatura: " + book.getKindOfLiterature()
					+ "\n" + "Editora: " + book.getPublisher() + "\n"
					+ "====================\n\n");
			arrow++;
		}
		return displayWithValidNumericInput(listBooks);
	}

	public void displaySuccessCheckBooksOut() {
		System.out
				.println("Registro de retirada de livro realizado com sucesso!\n"
						+ "Obrigado por utilizar nossos serviços.\n"
						+ "Boa leitura!\n");
	}

	public void displayErrorCheckBooksOut() {
		System.out
				.println("Desculpe, não foi possível registrar a retirada deste livro...\n"
						+ "Por favor escolha outro.\n");
	}

	public void displaySuccessCheckBooksIn() {
		System.out
				.println("Registro de devolução de livro realizado com sucesso.\n"
						+ "Obrigado por utilizar nossos serviços!\n");
	}

	public void displayErrorCheckBooksIn() {
		System.out
				.println("Desculpe, não foi possível registrar a devolução deste livro...\n");
	}

	public void displayLeaveSystem() {
		System.out.println("Obrigado por utilizar nossos serviços!\n"
				+ "Até breve.\n");
		System.exit(0);
	}

	public void displayWithInvalidOptionMessage() {
		System.out.println("Opção inválida...\n");
	}

	public void displayBookNotFound() {
		System.out.println("Livro não encontrado...\n"
				+ "Por favor, digite o título do livro corretamente.\n");
	}

}
