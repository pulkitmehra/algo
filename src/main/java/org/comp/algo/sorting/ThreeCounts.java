package org.comp.algo.sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ThreeCounts {

    @Test
    public void leftShiftTest() {
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-5 >>> 1));
    }

    @Test
    public void threeSums() {
        List<List<Integer>> threeSum = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : threeSum) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> subList = new ArrayList<>();
                subList.add(nums[0]);
                subList.add(nums[1]);
                subList.add(nums[2]);
                list.add(subList);
                return list;

            }
        }
        Set<Pair> set = new HashSet<>();

        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length - 1);
        int sum = 0;
        int mid = (nums.length - 1) / 2;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += sums(nums, i, 0, nums.length - 1, mid, set);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Pair p : set) {
            List<Integer> subList = new ArrayList<>();
            subList.add(p.i);
            subList.add(p.lo);
            subList.add(p.hi);
            list.add(subList);
        }

        return list;

    }

    public int sums(int[] nums, int i, int lo, int hi, int mid, Set<Pair> set) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        while (hi > lo) {
            if (hi == i) {
                hi--;
                continue;
            }
            if (lo == i) {
                lo++;
                continue;
            }
            //System.out.println("out: " + nums[i] + "" + nums[lo] + "" + nums[hi]);
            if (nums[i] + nums[lo] + nums[hi] == 0) {
                int[] parr = new int[] {nums[i], nums[lo], nums[hi]};
                //System.out.println("in:" + nums[i] + "" + nums[lo] + "" + nums[hi]);
                insertionSort(parr);
                Pair p = new Pair();
                p.i = parr[0];
                p.lo = parr[1];
                p.hi = parr[2];
                hi--;
                lo++;
                if (set.contains(p)) {
                    continue;
                } else {
                    set.add(p);
                }
                sum += 1;
         
            } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                lo++;
            } else {
                hi--;
            }

        }
        return sum;
    }

    public void insertionSort(int[] pairs) {
        for (int i = 1; i <= pairs.length - 1; i++) {

            for (int j = i; j > 0; j--) {
                if (pairs[j] < pairs[j - 1]) {
                    swap(pairs, j, j - 1);
                } else {
                    break;
                }
            }

        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void mergeSort(int[] arr, int[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + ((hi - lo) / 2);

        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);

        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int curr = lo;
        int lm = lo;
        int hm = mid + 1;
        while (lm <= mid && hm <= hi) {
            if (aux[lm] <= aux[hm]) {
                arr[curr++] = aux[lm++];
            } else if (aux[lm] > aux[hm]) {
                arr[curr++] = aux[hm++];
            }
        }

        while (lm <= mid) {
            arr[curr++] = aux[lm++];
        }

    }

    public static class Pair {

        int i;

        int lo;

        int hi;

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.i == this.i && p.lo == this.lo && p.hi == this.hi;
        }

        @Override
        public int hashCode() {
            return ("" + i + "" + lo + "" + hi).hashCode();
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Pair [i=" + i + ", lo=" + lo + ", hi=" + hi + "]";
        }

    }

}

