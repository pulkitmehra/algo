package org.comp.algo.problems;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MerkleTree {
    // 12345678
    // 1234 5678
    // 12 34 56 78
    List<String> list = Arrays.asList("0", "1", "1", "1", "0", "1", "0", "1");

    @Test
    public void buildMerkleTree() {

        int i = 0;
        int j = 1;
        int h = 0;
        while (list.size() != 1) {
            while (j <= list.size() - 1) {
                String v = "(" + list.get(i) + list.get(j) + ")";
                list.set(h++, v);
                i = j + 1;
                j = i + 1;
            }
            i = 0;
            j = 1;
            list = list.subList(0, h);
            h = 0;
        }
        System.out.println(list);
    }

}

