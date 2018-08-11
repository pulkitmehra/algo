package com.leetcode.premium.fb;

import java.util.Arrays;

public class Reader4 {


    public int readI(char[] ans, int n) {

        char[] tmp = new char[4];
        int k=0, i=0;
        while(n > 0){
            i = -1;//read4(tmp);
            if(i==-1 || i==0) break;
            for(int j=0; j<i && j < n; j++){
                ans[k++] = tmp[j];
            }
            n -= i;
        }
        return k;

    }

    char[] tmp = new char[4];
    int r=0;
    int l=0;


    public int readII(char[] buf, int n) {

        //try reading from buffer if available
        int k=0;
        while(l>0 && k<n){
            buf[k++] = tmp[r++];
            l--;
        }
        if(k==n) return k;

        //this is for situation when ask is 5 and available is more than 4
        boolean brk = false;
        //try reading from buffer if available
        while( (k + 1) <= n ){

            int i = -1;//read4(tmp);
            if(i==-1 || i==0) return k;

            //ask is more but we have to break in this iteration as return is less than 4
            if(i < 4){
                brk = true;
            }

            //fill to buffer
            l = i; r = 0;
            for(int j=0; j<i && j< n && k< n; j++){
                buf[k++] = tmp[r++];
                l--;
            }

            //break as decided above
            if(brk){
                break;
            }
        }
        return k;
    }
}
