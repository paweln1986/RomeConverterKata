package com.github.paweln1986;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EndToEndTest {
	private String romNum;
	private Integer expected;
	private RomeConverter romeConverter;

	public EndToEndTest(String romNum, Integer expected) {
		this.romNum = romNum;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] { { "I", 1 }, { "V", 5 }, {"VII", 7} });
	}

	@Test
	public void test() {
		romeConverter = new RomeConverter(new RomePartialConverterImpl(),
				new PartialDigitsJoinerImpl());
		Integer convertToInt = romeConverter.convertToInt(romNum);
		assertEquals(expected, convertToInt);
	}

}
