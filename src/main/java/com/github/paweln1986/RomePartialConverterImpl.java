package com.github.paweln1986;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomePartialConverterImpl implements RomePartialConverter {
	private Map<String, Integer> romeDigitConvertionMap;

	public RomePartialConverterImpl() {
		createConvertionMap();
	}

	public List<Integer> convert(String... string) {
		List<Integer> list = new ArrayList<Integer>();
		for (String stringToConvert : string) {
			Integer converted = romeDigitConvertionMap.get(stringToConvert.trim());
			list.add(converted);
		}
		return list;
	}

	private void createConvertionMap() {
		romeDigitConvertionMap = new HashMap<String, Integer>();
		romeDigitConvertionMap.put("I", new Integer(1));
		romeDigitConvertionMap.put("V", new Integer(5));
		romeDigitConvertionMap.put("X", new Integer(10));
		romeDigitConvertionMap.put("L", new Integer(50));
		romeDigitConvertionMap.put("C", new Integer(100));
		romeDigitConvertionMap.put("D", new Integer(500));
		romeDigitConvertionMap.put("M", new Integer(1000));
	}
}
