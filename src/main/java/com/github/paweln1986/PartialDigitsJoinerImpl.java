package com.github.paweln1986;

import java.util.List;

import com.google.common.collect.Lists;

public class PartialDigitsJoinerImpl implements PartialDigitsJoiner {

	public Integer join(List<Integer> value) {
		List<Integer> reverse = Lists.reverse(value);
		return joinDigits(reverse);
	}

	private Integer joinDigits(List<Integer> value) {
		Integer valueToReturn = 0;
		Integer previousValue = 0;
		for (Integer integer : value) {
			valueToReturn = calculateNextDigit(valueToReturn, previousValue,
					integer);
			previousValue = integer;
		}
		return valueToReturn;
	}

	private Integer calculateNextDigit(Integer valueToReturn,
			Integer previousValue, Integer integer) {
		if (previousValue > integer) {
			valueToReturn -= integer;
		} else {
			valueToReturn += integer;
		}
		return valueToReturn;
	}

}
