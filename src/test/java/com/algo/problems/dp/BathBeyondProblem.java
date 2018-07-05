package com.algo.problems.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class BathBeyondProblem {

	String word = "care";
	String word2 = "bedbathandbeyond";
	Map<String, Set<String>> cache = new HashMap<>();
	Set<String> dict = new HashSet<>();
	{
		dict.add("are");
		dict.add("care");
		dict.add("car");
		dict.add("care");
		dict.add("bed");
		dict.add("bath");
		dict.add("hand");
		dict.add("and");
		dict.add("beyond");
		dict.add("bat");
	}

	@Test
	public void testBathAndBeyond() {
		System.out.println(getDecompWords(word, 0, word.length()));
	}
	@Test
	public void testBathAndBeyond2() {
		System.out.println(getDecompWords(word2, 0, word.length()));
	}

	public Set<String> getDecompWords(String word, int index, int len) {
		if ("".equals(word) || index >= len) {
			return Collections.emptySet();
		}
		String key = word.substring(index);
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		int i = index;
		Set<String> itrSet = new HashSet<>();

		for (int j = i; j <= word.length(); j++) {
			itrSet.addAll(getDecompWords(word, index+1, len));
			String str = word.substring(i, j);
			if (!itrSet.contains(str) && dict.contains(str)) {
				itrSet.add(str);
				i = j;
			}
		}
		cache.put(key, itrSet);
		return itrSet;
	}

}
