package com.github.paweln1986;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PartialDigitsJoinerImplTest {

	private PartialDigitsJoiner objectUnderTest;

	@Before
	public void setUp() throws Exception {
		objectUnderTest = new PartialDigitsJoinerImpl();
	}

	@Test
	public void shouldReturnOn() throws Exception {
		// given
		List<Integer> list = createListToTest(1);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(1), joinedIntegers);
	}

	@Test
	public void shouldReturnTwo() throws Exception {
		// given
		List<Integer> list = createListToTest(1, 1);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(2), joinedIntegers);
	}

	@Test
	public void shouldReturnTree() throws Exception {
		// given
		List<Integer> list = createListToTest(1, 1, 1);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(3), joinedIntegers);
	}

	@Test
	public void shouldReturnFour() throws Exception {
		// given
		List<Integer> list = createListToTest(1, 5);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(4), joinedIntegers);
	}

	@Test
	public void shouldReturnFive() throws Exception {
		// given
		List<Integer> list = createListToTest(5);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(5), joinedIntegers);
	}

	@Test
	public void shouldReturnSix() throws Exception {
		// given
		List<Integer> list = createListToTest(5, 1);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(6), joinedIntegers);
	}

	@Test
	public void shouldReturnNine() throws Exception {
		// given
		List<Integer> list = createListToTest(1, 10);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(9), joinedIntegers);
	}

	@Test
	public void shouldReturn1990() throws Exception {
		// given
		List<Integer> list = createListToTest(1000,100,1000,10, 100);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(1990), joinedIntegers);
	}
	
	@Test
	public void shouldReturn2008() throws Exception {
		// given
		List<Integer> list = createListToTest(1000,1000,5,1,1,1);
		// when
		Integer joinedIntegers = objectUnderTest.join(list);
		// then
		assertEquals(new Integer(2008), joinedIntegers);
	}

	private List<Integer> createListToTest(Integer... elements) {
		return Arrays.asList(elements);
	}
}
