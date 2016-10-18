package com.jlopes.library.io;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ReaderTest {
	private Reader reader;

	@Before
	public void setUp() {
		reader = new Reader(new Scanner(System.in));
	}

	@Test
	public void shouldReturnZeroBecauseInputIsNotAValidNumber() {
		assertThat(reader.parseToValidNumber("asdf"), is(0));
	}

	@Test
	public void shouldReturnIntegerNumber() {
		assertThat(reader.parseToValidNumber("1234"), is(1234));
	}

	@Test
	public void shouldReturnZeroBecauseValueIsBiggerThanMaxValue() {
		assertThat(reader.validNumericInput(20, 15), is(0));
	}

	@Test
	public void shouldReturnTheSameValuePassedBecauseValueIsNotBiggerThanMaxValue() {
		assertThat(reader.validNumericInput(12, 15), is(12));
	}
}
