package com.leetcode.premium.fb;

public class SparseMultiplication {


    /**
     *          -->k        -->j
     *      i |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     * AB =   | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
     *                     | 0 0 1 |
     *
     * Calculate partial sum column
     *
     * |  1*7 1*0 1*0 |
     * |   0   0   0  |
     *
     *  A[0][1] skip
     *  A[0][2] skip
     *
     */
    public int[][] multiply(int[][] A, int[][] B) {

        int[][] ans = new int[A.length][B[0].length];

        for(int i = 0; i< A.length; i++){

            for(int k = 0; k < A[0].length; k++){

                //this calculates partial sum for each column and skp eagerly
                if(A[i][k]!=0){

                    for(int j=0; j< B[0].length; j++){

                        if(B[k][j]!=0)

                            ans[i][j] += (A[i][k] * B[k][j]);

                    }
                }
            }
        }
        return ans;
    }
}
