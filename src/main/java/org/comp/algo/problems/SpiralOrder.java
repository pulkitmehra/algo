package org.comp.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpiralOrder {

    int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    @Test
    public void readSpiralOrder() {
        int[][] arr = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7},};
        List<Integer> ans = new ArrayList<>();

        int m = arr.length, n = arr[0].length, total = m * n, y = 0, x = -1, d = 0, i = 0;
        while (i < total) {
            y = y + deltas[d][0];
            x = x + deltas[d][1];
            if (y < 0 || y > arr.length - 1 || x < 0 || x > arr[0].length - 1 || arr[y][x] == -1) {
                y = y - deltas[d][0];
                x = x - deltas[d][1];
                d = greedyNext(d, deltas.length - 1);
                continue;
            }
            ans.add(arr[y][x]);
            arr[y][x] = -1;
            i++;
        }
        System.out.println(ans);
    }

    private int greedyNext(int d, int size) {
        if (d == size) {
            return 0;
        }
        return d + 1;
    }

}

