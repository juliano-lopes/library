package com.jlopes.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping(value = "/home")
	public String home() {
		String home = "<doctype html>"
				+ "<html lang='pt-br'>"
				+ "<head>"
				+ "<title> Biblioteca </title>"
				+ "<meta charset='iso-8859-1'>"
				+ "</head>"
				+ "<body>"
				+ "<header>"
				+ "<h1>Wellcome to your Biblioteca!</h1>"
				+ "<nav role='menu'>"
				+ "<ul>"
				+ "<li><a href='#'>Search a book</a></li>"
				+ "<li><a href='/book/all'>List all the books</a></li>"
				+ "<li><a href='/book/available'>List only available books</a></li>"
				+ "<li><a href='#'>Return a book</a></li>" + "</ul>" + "</nav>"
				+ "</header>" + "<div role='main'>" + "</div>" + "</body>"
				+ "</html>";
		return home;
	}
}
