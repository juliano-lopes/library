package com.jlopes.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = { "com.jlopes.library.domain" })
@ComponentScan(basePackages = { "com.jlopes.library.*" })
@EnableJpaRepositories(basePackages = { "com.jlopes.library.repository" })
@EnableTransactionManagement

public class LibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
