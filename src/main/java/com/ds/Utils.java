package com.ds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	public static int[] increaseBy(int[] arr, int e) {
		int[] copy = new int[arr.length + e];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	public static int[] decreaseBy(int[] arr, int e) {
		int[] copy = new int[arr.length - e];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	public static void swap(int[] arr, int from, int to) {
		if (from == to)
			return;
		int t = arr[from];
		arr[from] = arr[to];
		arr[to] = t;
	}

	public static void swap(char[] arr, int from, int to) {
		if (from == to)
			return;
		char t = arr[from];
		arr[from] = arr[to];
		arr[to] = t;
	}

	public static List<String> readmin() {
		return readmin("/learning/algocode/src/main/resources/min.text");
	}

	public static List<String> readmin2() {
		return readmin("/learning/algocode/src/main/resources/min2.text");
	}

	public static List<String> readmin3() {
		return readmin("/learning/algocode/src/main/resources/min3.text");
	}

	public static List<List<String>> sortedLists() {
		List<List<String>> result = new ArrayList<>();
		result.add(readmin().stream().sorted().collect(Collectors.toList()));
		result.add(readmin2().stream().sorted().collect(Collectors.toList()));
		result.add(readmin3().stream().sorted().collect(Collectors.toList()));
		return result;
	}

	public static List<String> readmin(String file) {
		try {
			File f = new File(file);
			FileReader in = new FileReader(f);
			BufferedReader buf = new BufferedReader(in);
			return buf.lines().map((l) -> l.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
