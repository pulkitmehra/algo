package com.algo.problems;

import org.junit.Test;

public class RabinKarpSubString {


    @Test
    public void testHash() {
        // System.out.println(rabinKarp("tangom", "ng"));
        //System.out.println(hash("ab"));
        //System.out.println(rollingHash(hash("ab"), 'a', 'c', 2));
        //findSubString("ng", "tangom");
        int hash = hash("ab");
        int hash2 = hash("ca");
        System.out.println(hash);
        System.out.println(rollingHash(hash2, 'c', 'b', 2));
    }

    @Test
    public void testfindSubString() {
        findSubString("nar","canara");
    }

    public void findSubString(String s, String t){

        int sHash = hash(s);
        int tHash= hash(t.substring(0, s.length()));

        for(int i = s.length()-1; i < t.length();i++){
            String e = t.substring(i- (s.length()-1), i+1);
            if(sHash == tHash && e.equals(s)){
                System.out.println("found "+e);
                return;
            }
            if(i+1 < t.length()) {
                char chRem = t.charAt(i - (s.length() - 1));
                char chAdd = t.charAt(i + 1);
                tHash = rollingHash(tHash, chRem, chAdd, s.length());
            }
        }
    }

    public int rollingHash(int hash, char chRem, char chAd, int sLen) {
        hash = (hash - chRem)/10;
        hash =  hash + (chAd * (int) Math.pow(10, sLen-1));
        return hash;
    }

    public int hash(String s) { //"ab", 2
        int hash = 0;
        for (int i = 0; i < s.length(); i++) { // 0, 1 < 2
            hash += (s.charAt(i) * Math.pow(10, i)) ;
        }
        return hash;
    }

    /*
        This make sure that the number doesn't overflow
     */
    public int hornerHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = ( hash * 26 + s.charAt(i) ) % 997 ;
        }
        return hash % 997;
    }


    public int rabinKarp(String t, String s) {
        if (s.length() > t.length()) {
            return -1;
        }

        final int base = 26;
        int sHash = 0, tHash = 0, powerS = 1;

        for (int i = 0; i < s.length(); i++) {
            powerS = i > 0 ? powerS * base : 1;
            tHash = tHash * base + t.charAt(i);
            sHash = sHash * base + s.charAt(i);
        }

        for (int i = s.length(); i < t.length(); i++) {
            if (tHash == sHash && t.substring(i - s.length(), i).equals(s)) {
                return i - s.length();
            }
            tHash -= t.charAt(i - s.length()) * powerS;
            tHash = tHash * base + t.charAt(i);
        }

        if (tHash == sHash && t.substring(t.length() - s.length()).equals(s)) {
            return t.length() - s.length();
        }
        return -1;
    }


}
