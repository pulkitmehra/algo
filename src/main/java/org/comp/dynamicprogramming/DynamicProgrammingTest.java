package org.comp.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class DynamicProgrammingTest {

    /**
     * 0 1 2 3 4 5 6 7 0 1 1 2 3 5 8 13
     */
    @Test
    public void fibNacciSeries_normal() {
        System.out.println(fib(4));
    }

    @Test
    public void fibwithMemoization() {
        int i = 1;
        int[] mem = new int[i + 1];
        System.out.println(fibMemoization(i, mem));
    }

    @Test
    public void fibwithoutArr() {
        int n = 2;

        int a = 0;
        int b = 1;

        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        int i = 2;

        while (i <= n) {
            int c = a + b;
            a = b;
            b = c;
            i++;
        }

        System.out.println(b);
    }

    public int fibMemoization(int i, int[] mem) {
        if (i == 0 || i == 1)
            return i;

        if (mem[i] != 0) {
            return mem[i];
        }

        mem[i] = fibMemoization(i - 1, mem) + fibMemoization(i - 2, mem);
        return mem[i];
    }

    public int fib(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;

        return fib(i - 1) + fib(i - 2);
    }

    @Test
    public void numberOfStairCaseStep() {
        List<List<Integer>> list = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        hopCrude(5, 0, new ArrayList<>(), list, map);
        for (List<Integer> list2 : list) {
            System.out.println(list2);
        }
        System.out.println(list.size());
        // Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    }

    @Test
    public void justContNoOfWaysToReachTopInHop() {
        int n = 35;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        AtomicInteger i = new AtomicInteger();
        long start = System.currentTimeMillis();
        System.out.println(hopCountWays(n));
        // System.out.println(hopCountWaysWithMem(n, mem));
        System.out.println(i);
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) / 1000);

    }

    private int hopCountWaysWithMem(int n, int[] mem) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (mem[n] > -1) {
            return mem[n];
        } else {
            int count = hopCountWaysWithMem(n - 1, mem) + hopCountWaysWithMem(n - 2, mem)
                    + hopCountWaysWithMem(n - 3, mem);
            mem[n] = count;
            return mem[n];
        }
    }

    private int hopCountWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return hopCountWays(n - 1) + hopCountWays(n - 2) + hopCountWays(n - 3);
    }

    public List<List<Integer>> hopCrude(int rem, int hop, List<Integer> temp, List<List<Integer>> main,
            Map<String, List<Integer>> mem) {
        if (rem == 0) {
            temp.add(hop);
            main.add(temp);
            return main;
        }

        temp.add(hop);

        if (rem - 1 >= 0) {
            List<Integer> hop1List = new ArrayList<Integer>();
            hop1List.addAll(temp);

            hopCrude(rem - 1, 1, hop1List, main, mem);
        }

        if (rem - 2 >= 0) {
            List<Integer> hop2List = new ArrayList<Integer>();
            hop2List.addAll(temp);

            hopCrude(rem - 2, 2, hop2List, main, mem);
        }

        if (rem - 3 >= 0) {
            List<Integer> hop3List = new ArrayList<Integer>();
            hop3List.addAll(temp);

            hopCrude(rem - 3, 3, hop3List, main, mem);
        }

        List<Integer> list = mem.get("" + rem + hop);
        if (list != null) {

        }
        return main;
    }

    @Test
    public void numberOfPathInMatrix() {
        int i = 7;
        int[][] m = new int[i][i];
        int[][] mem = new int[i + 1][i + 1];
        for (int j = 0; j < mem.length; j++) {
            Arrays.fill(mem[j], -1);
        }

        m[1][1] = -1; // block
        m[3][3] = -1; // block
        m[1][4] = -1; // block
        m[4][4] = -2; // finishing point
        Map<String, List<List<String>>> memMap = new HashMap<>();
        List<List<String>> main = new ArrayList<>();
        findNumOfPath(m, 0, 0, main, new ArrayList<>(), memMap);
        System.out.println(main.size());
        for (List<String> list : main) {
            System.out.println(list);
        }
    }

    private List<List<String>> findNumOfPath(int[][] m, int r, int c, List<List<String>> main, List<String> temp,
            Map<String, List<List<String>>> memMap) {
        if (r > m.length - 1 || c > m[0].length - 1) {
            return main;
        }
        if (m[r][c] == -1) {
            return main; // block
        }
        if (m[r][c] == -2) {
            temp.add("" + r + c);
            main.add(temp);
            return main; // found
        }
        /*
         * if (memMap.containsKey("" + r + c)) { List<List<String>> list = memMap.get("" + r + c); for (List<String>
         * memList : list) { List<String> l = new ArrayList<>(temp); l.addAll(memList); main.add(l); } return main; }
         */

        temp.add("" + r + c);
        List<String> tempRow = new ArrayList<>();
        tempRow.addAll(temp);

        List<String> tempCol = new ArrayList<>();
        tempCol.addAll(temp);

        findNumOfPath(m, r + 1, c, main, tempRow, memMap);
        findNumOfPath(m, r, c + 1, main, tempCol, memMap);

        /*
         * List<List<String>> list = new ArrayList<>(); list.add(tempRow); list.add(tempCol); memMap.put("" + r + c,
         * list);
         */
        return main;
    }

    @Test
    public void countIfathInMatrix() {
        int i = 7;
        int[][] m = new int[i][i];
        int[][] mem = new int[i + 1][i + 1];
        for (int j = 0; j < mem.length; j++) {
            Arrays.fill(mem[j], -1);
        }

        m[1][1] = -1; // block
        m[3][3] = -1; // block
        m[1][4] = -1; // block
        m[4][4] = -2; // finishing point

        System.out.println(countIfathInMatrix(m, 0, 0, mem));
    }

    @Test
    public void findMagicTest() {
        int[] a = new int[] {0, 2, 3, 4, 3, 4, 7};
        System.out.println(findMagic(a, 0, 6));
    }

    private Integer findMagic(int[] a, int lo, int hi) {
        if (hi < lo) {
            return null;
        }

        int mid = lo + (hi - lo) / 2;
        if (a[mid] == mid) {
            return mid;
        }

        if (a[mid] < mid) {
            return findMagic(a, mid + 1, hi);
        } else {
            return findMagic(a, lo, mid - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(0 / 2);
    }

    int countIfathInMatrix(int[][] m, int r, int c, int[][] mem) {
        if (r > m.length - 1 || c > m[0].length - 1) {
            return 0;
        }
        if (m[r][c] == -1) {
            return 0; // block
        }
        if (m[r][c] == -2) {
            return 1; // found
        }
        if (mem[r][c] != -1) {
            return mem[r][c];
        }

        mem[r][c] = countIfathInMatrix(m, r + 1, c, mem) + countIfathInMatrix(m, r, c + 1, mem);
        return mem[r][c];
    }

    @Test
    public void testString() {
        List<String> asList = Arrays.asList("a", "b");
        for (String v : asList) {
            v = v.concat("x");
        }
        System.out.println(asList);
    }

    @Test
    public void multiplyNumber() {
        int p = 15;
        int q = 0;

        int big = p > q ? p : q;
        int small = p < q ? p : q;
        int i = 1;
        int sum = small;
        while (big - (1 << i) >= 0) {
            sum += sum;
            i++;
        }

        int left = big - (1 << (i - 1));
        for (int j = 0; j < left; j++) {
            sum = sum + small;
        }
        System.out.println(sum);
    }

    @Test
    public void permutation() {
        List<String> p = new ArrayList<>();
        String s = "abc";
        if (s.length() <= 1) {
            System.out.println(s);
        }
        System.out.println(permutation(s, "", p));
    }

    List<String> permutation(String s, String curr, List<String> p) {
        List<String> permutations = new ArrayList<>();
        if (s.equals("")) {
            permutations.add("");
            return permutations;
        }

        String first = s.substring(0, 1);
        String left = s.substring(1);
        List<String> res = permutation(left, first, p);

        for (int j = 0; j < res.size(); j++) {
            String word = res.get(j);
            for (int i = 0; i <= res.get(j).length(); i++) {
                String start = word.substring(0, i);
                String end = word.substring(i);
                permutations.add(start + first + end);
            }
        }

        return permutations;
    }

    @Test
    public void permutation2() {
        String s = "abc";
        System.out.println(permutation2(s));
    }

    private List<String> permutation2(String s) {
        if (s == null)
            return null;

        List<String> permututation = new ArrayList<>();
        if (s.length() == 0) {
            List<String> l = new ArrayList<>();
            l.add("");
            return l;
        }

        char curr = s.charAt(0);
        String left = s.substring(1);
        List<String> perm = permutation2(left);
        for (String word : perm) {
            for (int j = 0; j <= word.length(); j++) {
                String fhalf = word.substring(0, j);
                String lhalf = word.substring(j);
                permututation.add(fhalf + curr + lhalf);

            }
        }
        return permututation;
    }

    @Test
    public void insertAt() {
        char ch = '1';
        String s = "abc";
        int i = 3;
        String start = s.substring(0, i);
        String end = s.substring(i);
        System.out.println(start + ch + end);

        for (int j = 0; j < s.length(); j++) {
            System.out.println(s.substring(0, j));
            System.out.println(s.substring(j + 1));
            System.out.println("-------");
        }
    }

    /**
     * Sub string s = abc substring goes one more than the length 00 or 11 or 22 or 33 will give "" 01 will give a 12
     * will give b 23 will give c
     */
    @Test
    public void subStringUnderstand() {
        String s = "abc";

        for (int i = 0; i < s.length(); i++) {
            String b = s.substring(0, i); // 0,1
            String e = s.substring(3, 3); // 2
            System.out.println(b + "," + e);
        }
    }

    @Test
    public void permutation3() {
        System.out.println(permutation3("abc"));
    }

    private List<String> permutation3(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            res.add("");
            return res;
        }

        for (int i = 0; i < len; i++) {
            String start = s.substring(0, i);
            String end = s.substring(i + 1, len);
            List<String> partials = permutation3(start + end);

            for (String v : partials) {
                res.add(s.charAt(i) + v);
            }
        }
        return res;
    }

    @Test
    public void permutationWithDuplicate() {
        String s = "aab";
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 1);
        ArrayList<String> results = new ArrayList<>();
        permutationWithDuplicate(map, "", s.length(), results);

    }

    private void permutationWithDuplicate(Map<String, Integer> map, String prefix, int remaining,
            List<String> results) {
        if (remaining == 0) {
            results.add(prefix);
            return;
        }

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count > 0) {
                map.put(key, count - 1);
                permutationWithDuplicate(map, prefix + key, remaining - 1, results);
                map.put(key, count);
            }
        }
    }

    @Test
    public void pairs() {
        int n = 3;
        Set<String> list = new HashSet<>();
        System.out.println(pairs(3));
    }

    Set<String> pairs(int n) {
        Set<String> partials = new HashSet<>();

        if (n == 0) {
            partials.add("");
            return partials;
        }

        Set<String> parts = pairs(n - 1);
        for (String part : parts) {
            for (int i = 0; i < part.length(); i++) {
                if (part.charAt(i) == '(') {
                    String newPair = insertAt(i, part);
                    partials.add(newPair);
                }
            }
            partials.add("()" + part);
        }
        return partials;
    }

    private String insertAt(int pos, String s) {
        return s.substring(0, pos + 1) + "()" + s.substring(pos + 1);
    }

    @Test
    public void fillPaint() {
        Pixel[][] arr = new Pixel[3][3];
        arr[0][0] = Pixel.get("G");
        arr[0][1] = Pixel.get("R");
        arr[0][2] = Pixel.get("R");
        arr[1][0] = Pixel.get("G");
        arr[1][1] = Pixel.get("G");
        arr[1][2] = Pixel.get("B");
        arr[2][0] = Pixel.get("R");
        arr[2][1] = Pixel.get("B");
        arr[2][2] = Pixel.get("R");
        print(arr);

        fill(1, 1, arr, "R", "");

        print(arr);
    }

    void print(Pixel[][] p) {
        System.out.println("");
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + "   ");
            }
            System.out.println("");
        }
    }

    private void fill(int r, int c, Pixel[][] arr, String dc, String pc) {
        if (r < 0 || r > arr.length - 1 || c < 0 || c > arr[0].length - 1)
            return;

        Pixel p = arr[r][c];
        if (p.visited) {
            return;
        } else {
            p.visited();
        }

        if (p.color == dc || (!pc.equals("") && pc != p.color)) {
            return;
        }

        fill(r + 1, c, arr, dc, p.color);
        fill(r - 1, c, arr, dc, p.color);
        fill(r, c + 1, arr, dc, p.color);
        fill(r, c - 1, arr, dc, p.color);
        p.color = dc;

    }

    private static class Pixel {
        String color;

        boolean visited;

        public static Pixel get(String c) {
            Pixel p = new Pixel();
            p.color = c;
            return p;
        }

        void visited() {
            this.visited = true;
        }

        public String toString() {
            return color + (visited == false ? "-" : "+");
        }
    }

    @Test
    public void countoins() {
        int sum = 11;
        System.out.println(countCoins(sum));
    }

    private int countCoins(int rem) {
        if (rem == 0) {
            return 1;
        }

        int total = 0;
        //if (rem >= 1 && rem % 1 >= 0) {
        if ( rem % 1 == 0) {
            total += countCoins(rem - 1);
            rem = rem - 1;
        }
        if ( rem % 5 == 0) {
        //if (rem >= 5 && rem % 5 >= 0) {
            total += countCoins(rem - 5);
            rem = rem - 5;
        }
        if ( rem % 10 == 0) {
        //if (rem >= 10 && rem % 10 >= 0) {
            total += countCoins(rem - 10);
            rem = rem - 10;
        }
        if ( rem % 25 == 0) {
        //if (rem >= 25 && rem % 25 >= 0) {
            total += countCoins(rem - 25);
            rem = rem - 25;
        }
        return total;
    }

    @Test
    public void remainder() {
        System.out.println(3 % 5);
    }
}
