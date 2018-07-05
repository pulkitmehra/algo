package com.algo.problems.dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * https://jlordiales.me/2014/03/01/dynamic-programming-edit-distance/
 * 
 * @author pulkitmehra
 *
 */
public class LevenshteinDistance {

	@Test
	public void topDownApproach() {
		System.out.println(editDistance("ABD", "AE", new HashMap<>()));
	}

	public int editDistance(String a, String b, Map<ST, Integer> cache) {
		if (a.equals(""))
			return b.length();
		if (b.equals(""))
			return a.length();

		ST key = ST.get(a, b);

		if (cache.containsKey(key)) {
			System.out.println("hit cache " + key);
			return cache.get(key);
		}

		int replace = (a.charAt(0) == b.charAt(0) ? 0 : 1) + editDistance(a.substring(1), b.substring(1), cache);
		int ins = 1 + editDistance(a, b.substring(1), cache);
		int del = 1 + editDistance(a.substring(1), b, cache);
		int min = Math.min(replace, Math.min(ins, del));
		cache.put(key, min);
		System.out.println(cache);
		return min;
	}

	public static class ST {
		String a;
		String b;

		public static ST get(String a, String b) {
			return new ST(a, b);
		}

		ST(String a, String b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "(" + a + "," + b + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((b == null) ? 0 : b.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ST other = (ST) obj;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (b == null) {
				if (other.b != null)
					return false;
			} else if (!b.equals(other.b))
				return false;
			return true;
		}

	}

}
