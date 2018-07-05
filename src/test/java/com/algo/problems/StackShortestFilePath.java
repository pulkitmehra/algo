package com.algo.problems;

import java.util.ArrayDeque;

import org.junit.Test;

public class StackShortestFilePath {

	@Test
	public void testSucc() {
		String url = "/st/.//../abs/def/../z/././.";
		System.out.println(shortestFilepath(url));
	}
	
	@Test
	public void test2() {
		String url = "st/../abs/def/../z/././.";
		System.out.println(shortestFilepath(url));
	}

	private String shortestFilepath(String url) {

		ArrayDeque<String> stack = new ArrayDeque<>();

		if (url.charAt(0) == '/') {
			stack.addLast("/");
			url = url.substring(1);
		}

		for (String part : url.split("/")) {
			if (part.equals("") || part.equals(".")) {
				continue;
			}

			if (part.equals("..")) {
				if (stack.isEmpty() || isPartUnderflowRoot(stack)) {
					throw new IllegalStateException("Cant figure out path");
				}
				stack.pollLast();
			} else {
				stack.addLast(part);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			String e = stack.pollFirst();
			sb.append(e);
			if (!e.equals("/") && stack.size() >= 1)
				sb.append("/");
		}
		return sb.toString();
	}

	private boolean isPartUnderflowRoot(ArrayDeque<String> stack) {
		return stack.peekLast().equals("/");
	}

}
