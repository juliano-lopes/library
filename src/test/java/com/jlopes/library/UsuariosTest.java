package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class UsuariosTest {
	@Test(expected = UsuarioDataShouldNotBeEmptyException.class)
	public void shouldReturnUsuarioDataShouldNotBeEmptyException() {
		new Usuarios("", "julopys@hotmail.com", "31993709668");
	}

	@Test
	public void shouldReturnUsuarioName() {
		Usuarios usuario = new Usuarios("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = usuario.getName();
		assertThat(result, is("Juliano Lopes"));
	}

	@Test
	public void shouldReturnUsuarioEmail() {
		Usuarios usuario = new Usuarios("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = usuario.getEmail();
		assertThat(result, is("julopys@hotmail.com"));
	}

	@Test
	public void shouldReturnUsuarioPhone() {
		Usuarios usuario = new Usuarios("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = usuario.getPhone();
		assertThat(result, is("31993709668"));
	}

}
