package com.jlopes.library;

public enum MenuOptions {
	DISPLAY_MENU_OPTIONS(0), SEARCH_BOOK(1), LIST_ALL_BOOKS(2), LIST_AVAILABLE_BOOKS(
			3), RETURN_BOOK(4), LEAVE_SYSTEM(5), INVALID_OPTION(-1);
	private int value;

	MenuOptions(int value) {
		this.value = value;
	}

	public static MenuOptions option(int option) {
		for (MenuOptions menuOption : MenuOptions.values()) {
			if (menuOption.value == option) {
				return menuOption;
			}
		}
		return MenuOptions.INVALID_OPTION;
	}
}
