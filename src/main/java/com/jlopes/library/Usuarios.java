package com.jlopes.library;

public class Usuarios {
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

	public Usuarios(String name, String email, String phone) {
		if (isUsuarioDataEmpty(name, email, phone)) {
			throw new UsuarioDataShouldNotBeEmptyException();
		}
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	private boolean isUsuarioDataEmpty(String name, String email, String phone) {
		if ((name.equals("")) || (email.equals("")) || (phone.equals(""))) {
			return true;
		} else {
			return false;
		}
	}
}
