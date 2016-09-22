package com.jlopes.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryDisplayControl extends Utility {
	Scanner entry;
	BufferedReader entryLine;
	String name;
	String email;
	String phone;

	public void displayWellCome() {
		System.out.println("Bem-vindo(a) � sua biBiblioteca!\n");
	}

	public List<String> displayToGetUserData() {
		List<String> userData = new ArrayList<String>();
		boolean ready = false;
		while (!ready) {

			System.out.println("Qual o seu nome?\n");
			entryLine = new BufferedReader(new InputStreamReader(System.in));

			try {
				name = entryLine.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Qual seu e-mail?\n");
			entryLine = new BufferedReader(new InputStreamReader(System.in));

			try {
				email = entryLine.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Qual seu telefone para contato?\n");
			entryLine = new BufferedReader(new InputStreamReader(System.in));

			try {
				phone = entryLine.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (isDataEmpty(name, email, phone)) {
				System.out
						.println("Os dados n�o podem ficar em branco. Por favor, os preencha corretamente.\n");
			} else {
				ready = true;
			}
		}

		userData.add(name);
		userData.add(email);
		userData.add(phone);
		return userData;
	}

	public int displayWithMenuOptions() {

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
		System.out.println("Digite o t�tulo do livro que deseja buscar: \n"
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

	public void successCheckBooksOut() {
		System.out.println("Obrigado por utilizar nossos servi�os!\n"
				+ "Registro de retirada de livro realizado com sucesso.\n"
				+ "Boa leitura!\n");
	}

	public void errorCheckBooksOut() {
		System.out
				.println("Desculpe, n�o foi poss�vel registrar a retirada deste livro...\n"
						+ "Por favor escolha outro.\n");
	}

	public void leaveSystem() {

		System.out.println("Obrigado por utilizar nossos servi�os!\n"
				+ "At� breve.\n");
		System.exit(0);
	}

	public void successCheckBooksIn() {
		System.out.println("Obrigado por utilizar nossos servi�os!\n"
				+ "Registro de devolu��o de livro realizado com sucesso.\n");
	}

	public void errorCheckBooksIn() {
		System.out
				.println("Desculpe, n�o foi poss�vel registrar a devolu��o deste livro...\n");
	}
}
