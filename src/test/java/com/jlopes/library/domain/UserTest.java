package com.jlopes.library.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.jlopes.library.domain.User;
import com.jlopes.library.exception.UserDataShouldNotBeEmptyException;

public class UserTest {
	@Test(expected = UserDataShouldNotBeEmptyException.class)
	public void shouldReturnUserDataShouldNotBeEmptyException() {
		new User("", "julopys@hotmail.com", "31993709668");
	}

	@Test
	public void shouldReturnUserName() {
		User user = new User("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getName();
		assertThat(result, is("Juliano Lopes"));
	}

	@Test
	public void shouldReturnUserEmail() {
		User user = new User("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getEmail();
		assertThat(result, is("julopys@hotmail.com"));
	}

	@Test
	public void shouldReturnUserPhone() {
		User user = new User("Juliano Lopes", "julopys@hotmail.com",
				"31993709668");
		String result = user.getPhone();
		assertThat(result, is("31993709668"));
	}

}
