package com.jlopes.library;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class UsersTest {
	@Test(expected = UserDataShouldNotBeEmptyException.class)
	public void shouldReturnUserDataShouldNotBeEmptyException() {
		new Users("", "julopys@hotmail.com", "31993709668");
	}

	@Test
	public void shouldReturnUserName() {
		Users user = new Users("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getName();
		assertThat(result, is("Juliano Lopes"));
	}

	@Test
	public void shouldReturnUserEmail() {
		Users user = new Users("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getEmail();
		assertThat(result, is("julopys@hotmail.com"));
	}

	@Test
	public void shouldReturnUserPhone() {
		Users user = new Users("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getPhone();
		assertThat(result, is("31993709668"));
	}

}
