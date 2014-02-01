package com.github.paweln1986;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RomeConverterTest {

	private static final String XIIIV = "XIIIV";
	private static final String NULL_POINTER_MESSAGE = "String to convert should not be null.";
	private static final String EMPTY_STRING = "";
	private RomeConverter objectUnderTest;

	@Mock
	private RomePartialConverter partialConverter;
	@Mock
	private PartialDigitsJoiner partialDigitsJoiner;
	private Integer convertToInt;

	@Before
	public void setUp() throws Exception {
		objectUnderTest = new RomeConverter(partialConverter, partialDigitsJoiner);
	}

	@Test
	public void shouldThrowNullPointerExceptionWhenNullWasPassingToConvert()
			throws Exception {
		// given
		// when
		catchException(objectUnderTest).convertToInt(null);
		// then
		assertThat(caughtException()).isInstanceOf(NullPointerException.class)
				.hasMessage(NULL_POINTER_MESSAGE);
	}

	@Test
	public void shouldReturnZeroWhenEmptyStringWasConverted() throws Exception {
		// given
		// when
		Integer returnedValu = objectUnderTest.convertToInt(EMPTY_STRING);
		// then
		assertEquals(new Integer(0), returnedValu);
	}

	@Test
	public void shouldSplitStringIntoCharsAngDelegateThemToPartialConverter()
			throws Exception {
		// given
		String stringToConvert = XIIIV;
		// when
		objectUnderTest.convertToInt(stringToConvert);
		// then
		verify(partialConverter).convert("X", "I", "I", "I", "V");
	}
	
	@Test
	public void shouldDelegatePartialConvertedDigitsToPartialDigitsJoiner() throws Exception {
		// given
		List<Integer> value = Arrays.asList(10,1,1,1,5);
		String stringToConvert = XIIIV;
		when(partialConverter.convert("X", "I", "I", "I", "V")).thenReturn(value);
		// when
		objectUnderTest.convertToInt(stringToConvert);
		// then
		verify(partialDigitsJoiner).join(value);
	}
	
}
