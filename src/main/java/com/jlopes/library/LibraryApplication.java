package com.jlopes.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EntityScan(basePackages = { "com.julopes.library.domain" })
//@ComponentScan(basePackages = { "com.julopes.*" })
//@EnableJpaRepositories(basePackages = { "com.julopes.library.repository" })
@EnableTransactionManagement

public class LibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
