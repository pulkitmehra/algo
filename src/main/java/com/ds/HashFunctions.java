package com.ds;

public class HashFunctions {

	/**
	 * Generally the array size should be a prime number. We determine prime number
	 * by first taking the tolerance of collision, say 3. Then get the size of key
	 * you foresee to load, say 2000, then 2000/3 = 666, choose the closes prime
	 * number, such that its not close to 2^x, for example we can pick 661 as prime
	 * number but its close to 2^9=512, so lets be far from it and choose another
	 * prime 719.
	 */
	public static int hashByDivision(String s, int mod) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash += i * s.charAt(i);
		}
		return hash % mod;
	}

	/**
	 * add the key with power of prime.Could overflow. abc -> ASCII (97) (98) (99)
	 * [97 * 3^0] + [98 * 3^1] + [99 * 3^2] Use Horner method for efficient hash
	 */
	public int hashForStrings(String key, int mod) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash += (Math.pow(3, i)) * key.charAt(i);
		}
		return hash % mod;
	}

	public int hashByHorner(String key, int mod) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = (32 * hash + key.charAt(i)) % mod;
		}
		return hash;
	}

}
