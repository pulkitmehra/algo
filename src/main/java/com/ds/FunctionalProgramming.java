package com.ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FunctionalProgramming {

	@Test
	public void flatMap() {
		List<String> lst = Arrays.asList("test", "for");
		List<Character> listOfChar = lst.stream().map(e -> e.chars()).flatMap(e -> e.mapToObj(i -> (char) i))
				.collect(Collectors.toList());
		System.out.println(listOfChar);
	}
}
