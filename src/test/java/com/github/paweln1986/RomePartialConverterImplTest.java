package com.github.paweln1986;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RomePartialConverterImplTest {
	private RomePartialConverter objectUnderTest;

	@Before
	public void setUp() throws Exception {
		objectUnderTest = new RomePartialConverterImpl();
	}

	@Test
	public void shouldReturnEmptyListWhenEmptyListPassesAsParameter()
			throws Exception {
		// given
		String[] romeTen = {};
		Integer[] expectedDigits = {};
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeTen);
		// then
		checkListContains(convertedToInt, expectedDigits);
	}

	@Test
	public void shouldRetunrOneWhenRomeIWasPassedAsParameter() throws Exception {
		// given
		String romeOne = "I";
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeOne);
		// then
		checkListContains(convertedToInt, 1);
	}

	@Test
	public void shouldReturnFiveWhenRomeVWasPassed() throws Exception {
		// given
		String romeFive = "V";
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeFive);
		// then
		checkListContains(convertedToInt, 5);
	}

	@Test
	public void shouldReturnTenWhenRomeXWasPassed() throws Exception {
		// given
		String romeTen = "X";
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeTen);
		// then
		checkListContains(convertedToInt, 10);
	}

	@Test
	public void shouldReturnFivtenWhenRomeLWasPassed() throws Exception {
		// given
		String[] romeFiveten = { "L", "C", "D", "M" };
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeFiveten);
		// then
		checkListContains(convertedToInt, 50, 100, 500, 1000);
	}

	@Test
	public void shouldReturnListWithValidParsedStringInSameOrder()
			throws Exception {
		// given
		String[] romeTen = { "X", "I", "I", "I", "V" };
		Integer[] expectedDigits = { 10, 1, 1, 1, 5 };
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeTen);
		// then
		checkListContains(convertedToInt, expectedDigits);
	}

	@Test
	public void shouldTrimStringWhenThereAreSpaces() throws Exception {
		// given
		String[] romeTen = { "X ", " I", " I ", "I", " V" };
		Integer[] expectedDigits = { 10, 1, 1, 1, 5 };
		// when
		List<Integer> convertedToInt = objectUnderTest.convert(romeTen);
		// then
		checkListContains(convertedToInt, expectedDigits);
	}

	private void checkListContains(List<Integer> convertedToInt,
			Integer... values) {
		assertThat(convertedToInt).isNotNull().containsExactly(values);
	}

}
