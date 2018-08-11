package org.comp.algo.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String> {
    private int capacity;

    private static float DEFAULT_LOAD_FACTOR = 1.00f;

    public LRUCache(int capacity, boolean accessOrder) {
        super(capacity, DEFAULT_LOAD_FACTOR, accessOrder);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > capacity;
    }

    public void peek() {
        this.keySet().iterator().forEachRemaining((e) -> {
            System.out.print(e);
        });
        System.out.println();
    }

}

