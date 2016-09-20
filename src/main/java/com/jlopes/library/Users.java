package com.jlopes.library;

public class Users extends Utility {
	private final String name;
	private final String email;
	private final String phone;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Users (String name, String email, String phone) {
		if (isDataEmpty(name, email, phone)) {
			throw new UserDataShouldNotBeEmptyException();
		}
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

}
