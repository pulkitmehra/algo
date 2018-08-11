package org.comp.algo.problems;

import org.junit.Test;

public class GroupShifting {

    int[] numbers = {7, 5, 7, 1, 9, 7, 8, 2};

    @Test
    public void arr_test() {
        int i = 0;
        groupElement(numbers, i);
    }

    private void groupElement(int[] arr, int i) {
        swap(arr, i, arr.length - 1);
    }

    private void qSort(int[] arr, int s, int e) {
        int p = pivot(arr, 0, arr.length - 1);
    }

    private int pivot(int[] arr, int s, int e) {
        int j = s - 1;
        while (s < e) {
            if (arr[s] <= arr[e]) {
                swap(arr, ++j, s);
            }
            s++;
        }
        swap(arr, ++j, e);
        return j;
    }

    private void swap(int[] arr, int from, int to) {
        if (from == to) {
            return;
        }
        int t = arr[from];
        arr[from] = arr[to];
        arr[to] = t;
    }

}


