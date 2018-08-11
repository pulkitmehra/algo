package org.comp.algo.problems;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {

    NavigableMap<Integer, String> map = new TreeMap<>();

    {
        map.put(50, "a");
        map.put(30, "b");
        map.put(60, "c");
        map.put(20, "d");
        map.put(70, "e");
        map.put(35, "f");
        map.put(10, "g");
        map.put(25, "h");
        map.put(32, "i");
        map.put(37, "j");
        map.put(75, "k");
        map.put(74, "l");
        map.put(78, "m");
    }

    @Test
    public void test() {
        System.out.println(map);

        // successor
        System.out.println(map.ceilingKey(38));
        System.out.println(map.ceilingEntry(38));
        System.out.println(map.higherEntry(37).getKey()); // this one give next higher key even the key is found

        // predecessor
        System.out.println(map.floorKey(36));
        System.out.println(map.floorEntry(36).getKey());
        System.out.println(map.lowerEntry(37).getKey()); // this one give one lower key even the key is found

        // read left most entry (minimum)
        System.out.println(map.firstEntry().getKey());
        System.out.println(map.pollFirstEntry().getKey());// remove min key
        // read right most entry (maximum)
        System.out.println(map.lastEntry().getKey());
        System.out.println(map.pollLastEntry().getKey());// remove max key

        Set<Entry<Integer, String>> entrySet = map.entrySet();
        for (Entry<Integer, String> entry : entrySet) {
            System.out.print(entry.getKey() + ",");

        }
        System.out.println();
        
        Set<Integer> keySet = map.keySet();
        System.out.println(keySet);
        
        NavigableSet<Integer> navigableKeySet = map.navigableKeySet();
        System.out.println(navigableKeySet);
        
        NavigableSet<Integer> descendingKeySet = map.descendingKeySet();
        System.out.println(descendingKeySet);

    }

}


