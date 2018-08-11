package org.comp.algo.question;

import org.junit.Test;

public class FindPeak {

    @Test
    public void onedarrayPeak() {
        int[] arr = new int[] {4, 5, 6, 7, 8, 7, 5, 4, 2, 1};
        System.out.println(findPeak(arr, 0, arr.length - 1));
    }

    @Test
    public void twodarrayFindPeak() {
        // @formatter:off
        int[][] arr = new int[][] {new int[] {1, 2, 3, 4, 5}, new int[] {1, 7, 9, 10, 3}, new int[] {2, 3, 6, 5, 3},
                new int[] {3, 2, 4, 8, 1}, new int[] {1, 9, 2, 3, 7}};
        // @formatter:on
        System.out.println(twoDpeak(arr, 0, arr.length - 1, 0, arr[0].length - 1));
    }

    public int twoDpeak(int[][] arr, int rs, int re, int cs, int ce) {
        int mr = re - (re - rs) / 2;
        int mc = ce - (ce - cs) / 2;

        Pair pr = findPeakByRow(arr[mr], cs, ce, mr);
        Pair pc = findPeakInColumn(arr, mc, rs, re);

        if (arr[pr.r][pr.c] >= arr[pc.r][pc.c]) {
            // check if up and down are low which is the answer
            if (pr.r + 1 <= arr.length - 1 && pr.r - 1 >= 0 && arr[pr.r + 1][pr.c] < arr[pr.r][pr.c]
                    && arr[pr.r - 1][pr.c] < arr[pr.r][pr.c]) {
                return arr[pr.r][pr.c];
            }
            else if (pr.r - 1 >= 0 && arr[pr.r - 1][pr.c] >= arr[pr.r][pr.c]) {
                // look up & down
                if (pr.c <= mc) {
                    return twoDpeak(arr, rs, mr, cs, mc);
                }
                else {
                    return twoDpeak(arr, rs, mr, mc, ce);
                }
            }
            else if (pr.r + 1 <= arr.length - 1 && arr[pr.r + 1][pr.c] > arr[pr.r][pr.c]) {
                if (pr.c < mc) {
                    return twoDpeak(arr, mr, re, cs, mc);
                }
                else {
                    return twoDpeak(arr, mr, re, mc, ce);
                }
            }
            else {
                return -1;
            }

        }
        else {
            // check if left and right are low which is the answer
            if (pc.c + 1 <= arr[0].length - 1 && pc.c - 1 >= 0 && arr[pc.r][pr.c + 1] < arr[pc.r][pc.c]
                    && arr[pc.r][pc.c - 1] < arr[pc.r][pc.c]) {
                return arr[pc.r][pc.c];
            }
            else if (pc.c - 1 >= 0 && arr[pc.r][pr.c - 1] >= arr[pc.r][pc.c]) {
                // left
                if (pc.r <= mr) {
                    return twoDpeak(arr, rs, mr, cs, mc);
                }
                else {
                    return twoDpeak(arr, mr, re, cs, mc);
                }
            }
            else if (pc.c + 1 <= arr[0].length - 1 && arr[pc.r][pc.c + 1] > arr[pc.r][pc.c]) {
                //
                if (pc.r < mr) {
                    return twoDpeak(arr, rs, mr, mc, ce);
                }
                else {
                    return twoDpeak(arr, mr, re, mc, ce);
                }
            }
            else {
                return -1;
            }
        }
    }

    public int findPeak(int[] arr, int start, int end) {

        int mid = end - (end - start) / 2;
        if ((mid - 1) >= 0 && arr[mid - 1] > arr[mid]) {
            return findPeak(arr, start, mid - 1);
        }
        else if ((mid + 1) <= arr.length - 1 && arr[mid + 1] > arr[mid]) {
            return findPeak(arr, mid + 1, end);
        }
        else {
            return arr[mid];
        }
    }

    public Pair findPeakInColumn(int[][] arr, int c, int rs, int re) {

        int m = re - (re - rs) / 2;
        // go up
        if (m - 1 >= 0 && arr[m - 1][c] > arr[m][c]) {
            return findPeakInColumn(arr, c, rs, m - 1);
        }
        else if (m + 1 > arr.length - 1 && arr[m + 1][c] > arr[m][c]) {
            return findPeakInColumn(arr, c, m + 1, re);
        }
        else {
            return Pair.of(m, c);
        }
    }

    public Pair findPeakByRow(int[] arr, int start, int end, int r) {

        int mid = end - (end - start) / 2;
        if ((mid - 1) >= 0 && arr[mid - 1] > arr[mid]) {
            return findPeakByRow(arr, start, mid - 1, r);
        }
        else if ((mid + 1) <= arr.length - 1 && arr[mid + 1] > arr[mid]) {
            return findPeakByRow(arr, mid + 1, end, r);
        }
        else {
            return Pair.of(r, mid);
        }
    }

    public static class Pair {
        int r;

        int c;

        public static Pair of(int r, int c) {
            Pair p = new Pair();
            p.r = r;
            p.c = c;
            return p;
        }
    }
}

