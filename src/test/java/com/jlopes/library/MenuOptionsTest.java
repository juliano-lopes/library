package com.jlopes.library;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuOptionsTest {
	@Test
	public void shouldReturnMenuOption() {
		assertThat(MenuOptions.option(0), is(MenuOptions.DISPLAY_MENU_OPTIONS));
	}
}
