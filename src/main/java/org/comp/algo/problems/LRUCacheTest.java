package org.comp.algo.problems;

import java.util.LinkedHashMap;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void lruCacheFIFOtest() {
        LinkedHashMap<Integer, Integer> m = new LinkedHashMap() {
            
        };
        LRUCache cache = new LRUCache(3, false);
        cache.put(1, "a");
        cache.put(2, "a");
        cache.put(3, "a");
        cache.put(4, "a");
        cache.put(4, "a");
        cache.get(5);

        System.out.println(cache);
    }

    @Test
    public void lruCacheAccessOrderTest() {
        LRUCache cache = new LRUCache(3, true);
        cache.put(1, "a");
        cache.put(2, "a");
        cache.put(3, "a");

        cache.peek();

        cache.put(4, "a");
        cache.put(5, "a");
        cache.peek();

        cache.get(4);
        cache.peek();

        cache.put(6, "a");
        cache.peek();

        cache.get(5);
        cache.peek();

        System.out.println(cache);
    }

}


