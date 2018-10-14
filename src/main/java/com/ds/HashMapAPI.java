package com.ds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class HashMapAPI {

	Map<String, LinkedList<String>> map = new HashMap<>();

	@Test
	public void hashMapApi() {
		map.computeIfAbsent("a", k -> new LinkedList<>()).add("b");
		map.computeIfAbsent("a", k -> new LinkedList<>()).add("d");
		System.out.println(map);

		map.computeIfPresent("a", (k, v) -> {
			v.set(0, "c");
			return v;
		});
		System.out.println(map);
	}

	@Test
	public void incrementValueInMap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.putIfAbsent(1, 2);
		map.computeIfAbsent(2, k -> map.get(1) + 1);
		System.out.println(map);
	}

	@Test
	public void linkedHashMapOrder(){
		Map<Integer, Integer> map =new LinkedHashMap<>();
		map.put(1,1);
		map.put(2,2);
		map.put(3,2);

		System.out.println(map);
	}
	@Test
	public void linkedhashMap() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(5, 1.0f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > 5;
			}
		};

		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		printKeys(map);
		map.get(4);
		printKeys(map);
		map.put(6,6);
		System.out.println(getLastAccess(map));
		map.get(5);
		System.out.println(map);
		System.out.println(getLastAccess(map));

	}

	private Integer getLastAccess(LinkedHashMap<Integer, Integer> map) {
		return ((Entry<Integer, Integer>) map.entrySet().toArray()[map.size() - 1]).getKey();
	}

	private void printKeys(LinkedHashMap<Integer, Integer> map) {
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<java.lang.Integer, java.lang.Integer> entry = (Map.Entry<java.lang.Integer, java.lang.Integer>) it
					.next();
			System.out.print(entry.getKey() + ",");
		}
		System.out.println();
	}
}
