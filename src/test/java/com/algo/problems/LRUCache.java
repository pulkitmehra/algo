package com.algo.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	int capacity;
	LinkedHashMap<Integer, Integer> map;

	public LRUCache(int capacity) {
		map = new LinkedHashMap(capacity, 1.0f, true) {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		map.put(key, value);
	}

	/**
	 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
	 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
	 */

}
