package org.comp.algo.sorting;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class SortingTest {

    @Test
    public void mergeTwoSortArray() {
        Integer[] a = new Integer[] {8, 9, 10, 11, null, null, null};
        Integer[] b = new Integer[] {1, 4, 7};

        int ai = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                ai = i - 1;
                break;
            }
        }

        int curr = a.length - 1;
        int bj = b.length - 1;

        while (ai >= 0 && bj >= 0) {
            if (b[bj] > a[ai]) {
                a[curr--] = b[bj--];
            } else if (b[bj] < a[ai]) {
                a[curr--] = a[ai--];
            } else {
                a[curr--] = b[bj--];
                a[curr--] = a[ai--];
            }
        }

        while (bj >= 0) {
            a[curr--] = b[bj--];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }

    }

    @Test
    public void groupAnagrams() {
        String[] arr = new String[] {"race", "acer", "marry", "yarrm"};
        Multimap<String, String> map = ArrayListMultimap.create();
        quickAnagramSort(arr, 0, arr.length - 1, map);
        System.out.println(Arrays.toString(arr));
        System.out.println(map);
    }

    public void quickAnagramSort(String[] arr, int lo, int hi, Multimap<String, String> map) {
        if (hi <= lo) {
            return;
        }

        int index = partition(arr, lo, hi, map);
        quickAnagramSort(arr, lo, index - 1, map);
        quickAnagramSort(arr, index, hi, map);
    }

    private int partition(String[] arr, int lo, int hi, Multimap<String, String> map) {
        int mid = lo + (hi - lo) / 2;
        String p = arr[mid];

        while (lo <= hi) {
            while (arr[lo].compareTo(p) < 0) {
                lo++;
            }

            while (arr[hi].compareTo(p) > 0) {
                hi--;
            }

            if (hi >= lo) {
                swap(lo, hi, arr);
                hi--;
                lo++;
            }
        }

        String s = insertionSort(p);
        map.put(s, p);
        return lo;
    }

    private void swap(int i, int j, String[] arr) {
        if (i == j) {
            return;
        }
        String t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    @Test
    public void insertionSort() {
        String s = "race";
        String s1 = "tom";
        String s2 = "me";
        String s3 = "m";

        System.out.println(insertionSort(s));
        System.out.println(insertionSort(s1));
        System.out.println(insertionSort(s2));
        System.out.println(insertionSort(s3));
    }

    private String insertionSort(String s) {

        if (s.length() < 2) {
            return s;
        }

        char[] arr = s.toCharArray();
        for (int i = 1; i <= arr.length - 1; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    char t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                } else {
                    break;
                }
            }

        }
        return String.valueOf(arr);
    }

    @Test
    public void exponentialSearch() {

        int[] a = new int[] {0, 1, 2, 5, 7, 8, 9, 10, 15, 17};
        int num = 1;
        if (elementAt(a, 0) != -1 && elementAt(a, 0) == num) {
            System.out.println(0);
            return;
        }

        int hiIndex = getBound(num, a, 0, elementAt(a, 1));
        int loIndex = hiIndex - 1;

        int hi = (int) Math.pow(2, hiIndex);
        int lo = (int) Math.pow(2, loIndex);
        System.out.println(binarySearch(a, num, lo, hi));
    }

    public int binarySearch(int[] arr, int num, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        int mv = elementAt(arr, mid);

        if (mv == -1 || num < mv) {
            return binarySearch(arr, num, lo, mid - 1);
        } else if (num > mv) {
            return binarySearch(arr, num, mid + 1, hi);
        } else if (num == mv) {
            return mid;
        }
        return -1;
    }

    int getBound(int num, int[] arr, int i, int value) {
        if (value == -1) {
            return i;
        }

        if (value < num) {
            return getBound(num, arr, i + 1, elementAt(arr, (int) Math.pow(2, i + 1)));
        }
        return i;
    }

    int elementAt(int[] a, int i) {
        try {
            return a[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    @Test
    public void searchWithEmptyString() {
        String[] a = new String[] {"", "a", "", "", "", "", "c", "", "", "e", "", "f", "", "", "g", "", "h"};
        int index = binarySearchWithEmpty(a, "c", 0, a.length - 1);
        if (index != -1) {
            System.out.println(a[index]);
        }
        System.out.println(index);
    }

    private int binarySearchWithEmpty(String[] a, String s, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }

        int m = lo + (hi - lo) / 2;

        if (a[m].equals("")) {
            int left = evalLeft(a, s, m - 1, lo);
            if (left >= 0) {
                return left;
            } else if (left == -1) {
                return binarySearchWithEmpty(a, s, lo, m);
            }
            int right = evalRight(a, s, m + 1, hi);
            if (right >= 0) {
                return right;
            } else if (right == -1) {
                return binarySearchWithEmpty(a, s, m + 1, hi);
            }
        } else if (s.compareTo(a[m]) < 0) {
            return binarySearchWithEmpty(a, s, lo, m);
        } else if (s.compareTo(a[m]) > 0) {
            return binarySearchWithEmpty(a, s, m + 1, hi);
        } else if (s.compareTo(a[m]) == 0) {
            return m;
        }
        return -1;
    }

    public int evalLeft(String[] a, String s, int m, int lo) {
        while (m >= lo) {
            if (a[m].equals("")) {
                m--;
                continue;
            } else if (a[m].compareTo(s) > 0) {
                return -1;
            } else if (a[m].compareTo(s) == 0)
                return m;
            else {
                return -2;
            }
        }
        return -2;
    }

    public int evalRight(String[] a, String s, int m, int hi) {
        while (m <= hi) {
            if (a[m].equals("")) {
                m++;
                continue;
            } else if (a[m].compareTo(s) < 0) {
                return -1;
            } else if (a[m].compareTo(s) == 0)
                return m;
            else {
                return -2;
            }
        }
        return -2;
    }

    @Test
    public void getRankInDynamicDataStructure() {
        Node root = insert(null, 30);
        insert(root, 15);
        insert(root, 10);
        insert(root, 5);

        insert(root, 13);
        insert(root, 12);
        insert(root, 14);

        insert(root, 17);
        insert(root, 16);
        insert(root, 19);

        insert(root, 45);
        insert(root, 50);
        insert(root, 48);
        insert(root, 35);
        insert(root, 37);

        print(root, "", true, "");
        System.out.println(rank(root, 30));

    }

    public static void print(Node n, String prefix, boolean isTail, String postfix) {
        if (n == null) {
            return;
        }
        System.out.println(prefix + (isTail ? "└── " : "├── ") + postfix + " v:" + n.v + " s:" + n.lsum);
        List<Node> children = Arrays.asList(n.l, n.r);
        for (int i = 0; i < children.size() - 1; i++) {
            print(children.get(i), prefix + (isTail ? "    " : "│   "), false, "l-");
        }

        if (children.size() > 0) {
            Node tNode = children.get(children.size() - 1);
            print(tNode, prefix + (isTail ? "    " : "│   "), true, "r-");
        }

    }

    private int rank(Node n, int x) {
        if (n == null) {
            return -1;
        }

        if (x < n.v) {
            return rank(n.l, x);
        } else if (x > n.v) {
            int r = rank(n.r, x);
            if (r != -1) {
                return r + n.lsum + 1;
            }
        } else if (n.v == x) {
            return n.lsum + 1;
        }
        return -1;
    }

    private Node insert(Node n, int v) {
        if (n == null) {
            return Node.get(v);
        }

        if (v <= n.v) {
            n.l = insert(n.l, v);
            n.lsum = n.lsum + 1;
        } else {
            n.r = insert(n.r, v);
        }
        return n;
    }

    private static class Node {
        int v;

        Node l;

        Node r;

        int lsum;

        static Node get(int v) {
            Node n = new Node();
            n.v = v;
            return n;
        }
    }

    @Test
    public void mergsort2() {
        int[] arr = new int[] {0, -1, -3, 4, 1, 5};
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
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

}


