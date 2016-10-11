package com.jlopes.library.io;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReaderTest {
	@Test
	public void shouldReturnZeroBecauseInputIsNotAValidNumber() {
		assertThat(Reader.parseToValidNumber("asdf"), is(0));
	}

	@Test
	public void shouldReturnIntegerNumber() {
		assertThat(Reader.parseToValidNumber("1234"), is(1234));
	}

	@Test
	public void shouldReturnZeroBecauseValueIsBiggerThanMaxValue() {
		assertThat(Reader.validNumericInput(20, 15), is(0));
	}

	@Test
	public void shouldReturnTheSameValuePassedBecauseValueIsNotBiggerThanMaxValue() {
		assertThat(Reader.validNumericInput(12, 15), is(12));
	}
}
