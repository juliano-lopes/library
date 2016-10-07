package com.jlopes.library;

public enum MenuOptions {
	DISPLAY_MENU_OPTIONS(0, ""), SEARCH_BOOK(1, "Search a book"), LIST_ALL_BOOKS(
			2, "List all the books"), LIST_AVAILABLE_BOOKS(3,
			"List only available books"), RETURN_BOOK(4, "Return a book"), LEAVE_SYSTEM(
			5, "Leave the system"), INVALID_OPTION(-1, "");
	private final int value;
	private final String description;

	MenuOptions(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public static MenuOptions option(int option) {
		for (MenuOptions menuOption : MenuOptions.values()) {
			if (menuOption.value == option) {
				return menuOption;
			}
		}
		return MenuOptions.INVALID_OPTION;
	}

	public String toString() {
		return value + ". " + description;
	}
}
