package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LookAndSay {

	@Test
	public void testLookAndSay() {
		int n = 5;
		String s = "1";
		List<String> l = new ArrayList<>();
		String lns = lns(n, s, l);

		System.out.println(lns);
		System.out.println(l);
	}

	public String lns(int n, String s, List<String> l) {
		if (n == 0) {
			return s;
		} else {
			int i = 0, j = 1;
			char ch = s.charAt(0);
			StringBuilder sb = new StringBuilder();
			while (i < s.length()) {
				j = 1;
				while (i + 1 < s.length() && ch == s.charAt(i + 1)) {
					ch = s.charAt(i + 1);
					i++;
					j++;
				}

				sb.append(j);
				sb.append(ch);
				if (i + 1 < s.length())
					ch = s.charAt(++i);
				else
					++i;
			}
			l.add(sb.toString());
			return lns(--n, sb.toString(), l);
		}
	}

}
