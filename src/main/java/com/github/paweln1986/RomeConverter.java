package com.github.paweln1986;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class RomeConverter {

	private static final String NULL_POINTER_MESSAGE = "String to convert should not be null.";
	private RomePartialConverter partialConverter;
	private PartialDigitsJoiner partialDigitsJoiner;

	public RomeConverter(RomePartialConverter partialConverter,
			PartialDigitsJoiner partialDigitsJoiner) {
		this.partialConverter = partialConverter;
		this.partialDigitsJoiner = partialDigitsJoiner;
	}

	public Integer convertToInt(String stringToConvert) {
		checkNotNull(stringToConvert, NULL_POINTER_MESSAGE);
		String[] strings = splitStringToConvert(stringToConvert);
		List<Integer> parsedIntegers = partialConverter.convert(strings);
		return partialDigitsJoiner.join(parsedIntegers);
	}

	private String[] splitStringToConvert(String stringToConvert) {
		Splitter results = Splitter.fixedLength(1).trimResults();
		Iterable<String> split = results.split(stringToConvert);
		String[] strings = Iterables.toArray(split, String.class);
		return strings;
	}

}
