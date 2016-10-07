package com.jlopes.library.io;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReadTest {
	@Test
	public void shouldReturnZeroBecauseInputIsNotAValidNumber() {
		assertThat(Read.parseToValidNumber("asdf"), is(0));
	}

	@Test
	public void shouldReturnIntegerNumber() {
		assertThat(Read.parseToValidNumber("1234"), is(1234));
	}

	@Test
	public void shouldReturnZeroBecauseValueIsBiggerThanMaxValue() {
		assertThat(Read.validNumericInput(20, 15), is(0));
	}

	@Test
	public void shouldReturnTheSameValuePassedBecauseValueIsNotBiggerThanMaxValue() {
		assertThat(Read.validNumericInput(12, 15), is(12));
	}
}
